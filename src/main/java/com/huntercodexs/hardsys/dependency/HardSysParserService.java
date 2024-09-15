package com.huntercodexs.hardsys.dependency;

import java.util.List;

public class HardSysParserService {

    public static String jsonCreatorRFC8259(List<String> input, String mainField) {

        //JSON: Valid (RFC 8259)
        StringBuilder jsonFormat;
        String jsonEnd = "}}";

        if (mainField == null || mainField.isEmpty()) {
            jsonFormat = new StringBuilder("{");
            jsonEnd = "}";

            if (input == null || input.isEmpty()) {
                return "{}";
            }

        } else {
            jsonFormat = new StringBuilder("{\""+mainField+"\":{");

            if (input == null || input.isEmpty()) {
                return "{\""+mainField+"\":{}}";
            }
        }

        for (String line : input) {

            //Prevent formatting error from incorrect character usage [
            line = line.replaceAll("\\[", "(").replaceAll("]", ")");

            String[] fields = line
                    .trim()
                    .replaceAll("([.@#\\-/)(\\\\_0-9a-zA-Z]+): ", "[$1],")
                    .replaceAll(",([^\\[[a-zA-Z]\\]]+)", "")
                    .replaceAll("]\\[", ",")
                    .replaceAll("[\\[\\]]", "")
                    .split(",");

            String[] values = line
                    .trim()
                    .replaceAll("([.@#\\-/)(\\\\_0-9a-zA-Z]+): ", " ")
                    .replaceAll("_", "{:under:}")
                    .replaceAll(" ", "_")
                    .replaceAll("__", "{:split:}")
                    .replaceAll("_", " ")
                    .replaceAll("\\{:under:}", "_")
                    .split("\\{:split:}");

            //System.out.println("[Parser] FIELDS: "+Arrays.toString(fields));
            //System.out.println("[Parser] VALUES: "+Arrays.toString(values));

            try {

                for (int i = 0; i < fields.length; i++) {
                    jsonFormat
                            //Field
                            .append("\"").append(fields[i].trim()).append("\"").append(":")
                            //Value
                            .append("\"").append(values[i].trim()).append("\"").append(",");
                }

            } catch (Exception ex) {
                System.out.println("[EXCEPTION] jsonCreatorRFC8259: "+ex.getMessage());
            }
        }

        jsonFormat.append(jsonEnd);

        //Hotfix and finish
        String jsonResponse = String.valueOf(jsonFormat).replaceAll(","+jsonEnd+"$", jsonEnd);
        jsonResponse = jsonResponse.replaceAll("(\":\"\")(,})", "$1}");
        jsonResponse = jsonResponse.replaceAll("(\":\"\")([-_0-9a-zA-Z]+)", "$1,\"$2");

        return jsonResponse;
    }

    public static String jsonMergerRFC8259(List<String> input, String mainField) {

        if (mainField == null || mainField.isEmpty()) {
            mainField = "Object";
        }

        StringBuilder jsonResponse = new StringBuilder("{\"" + mainField + "\": {");

        for (String jsonItem : input) {
            jsonResponse
                    .append(jsonItem.replaceAll("}$", "").replaceAll("^\\{", ""))
                    .append(",");
        }

        return (jsonResponse+"}}").replaceAll("},}", "}}");

    }

}
