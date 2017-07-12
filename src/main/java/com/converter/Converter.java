package com.converter;

import java.util.List;


public class Converter {

    private String destinationTableName;
    private FileReader reader;
    private FileWriter writer;

    public Converter(String inputFilePath, String destinationTableName) {
        reader = new FileReader(inputFilePath);
        writer = new FileWriter();
        this.destinationTableName = destinationTableName;
    }

    private List<String> getInput() {
        return reader.readAllLines();
    }

    private String generateRequest() {
        List<String> input = getInput();
        StringBuilder request = new StringBuilder();

        request.append("INSERT INTO ").append(destinationTableName)
                .append(" (").append(input.get(0)).append(") VALUES ");

        for (int i = 1; i < input.size(); i++) {
            String[] currentValues = input.get(i).split(",");
            request.append("(");
            for (int j = 0; j < currentValues.length; j++) {
                if (isInteger(currentValues[j]) || isDouble(currentValues[j])) {
                    if (j < currentValues.length - 1) {
                        request.append(currentValues[j]).append(",");
                    } else {
                        request.append(currentValues[j]);
                    }
                } else {
                    if (j < currentValues.length - 1) {
                        request.append("\"").append(currentValues[j]).append("\",");
                    } else {
                        request.append("\"").append(currentValues[j]).append("\"");
                    }
                }
            }
            if (i < input.size() - 1) request.append("),");
            else request.append(");");
        }
        return request.toString();
    }

    public void writeRequest() {
        writer.writeToFile(generateRequest());
    }

    private boolean isInteger(String s) {
        return s.matches("\\d+");
    }

    private boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
