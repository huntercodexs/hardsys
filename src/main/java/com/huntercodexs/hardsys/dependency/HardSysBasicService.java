package com.huntercodexs.hardsys.dependency;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class HardSysBasicService {

    private int index = 0;

    public void setIndex(int index) {
        this.index = index;
    }

    public static int stringCounter(String input, String pattern) {

        int counter = 0;

        try {

            while (true) {

                String begin = input.replaceFirst(
                        pattern, "#<" + counter + "#{{{ REPLACED }}}#" + counter + ">#");

                String result = StringUtils
                        .substringBetween(begin, "#<" + counter + "#", "#" + counter + ">#")
                        .trim();

                counter+=1;

                if (result.isEmpty()) break;
                input = begin;

            }

            return counter;

        } catch (Exception ex) {
            return counter;
        }

    }

    public String replaceIndexing(
            String input,
            String target,
            String replacement,
            String separator,
            boolean useIndex
    ) {
        int index = this.index;
        String replace;

        if (separator == null) separator = "";

        while (true) {

            if (useIndex) {
                replace = input.replaceFirst(target, replacement+"_"+index+separator);
                index++;
            } else {
                replace = input.replaceFirst(target, replacement+separator);
            }

            if (!replace.contains(target)) {
                break;
            }

            input = replace;

        }

        this.index = index;

        return replace;
    }

    public static String stringExtractor(String input, String clear, String pattern, String replacer, int index) {

        try {

            String begin = input.replaceAll(pattern, "#<" + index + "#" + replacer + "#" + index + ">#");
            String extract = begin.replaceAll(", ", " ");

            return StringUtils
                    .substringBetween(extract, "#<" + index + "#", "#" + index + ">#")
                    .replaceAll(clear + ":", "").trim();

        } catch (Exception ex) {
            return "";
        }

    }

    public static List<String> listClear(List<String> items, String replace, String replacement) {
        List<String> result = new ArrayList<>();
        for (String current : items) {
            result.add(current.replaceAll(replace, replacement));
        }
        return result;
    }

    public static String alphaFieldPattern(String input, String field, String useChars) {

        try {

            if (useChars == null) {
                useChars = "";
            }

            String qty = "";
            if (useChars.equals(" ")) {
                qty = "{1,} ";
            }

            String pattern = "("+field+")(:)( ?)([-)(}{\\]\\[/@#%_.0-9a-zA-Z"+useChars+"]+)"+qty;
            String replacement = "#<1#{{{REPLACE}}}:$4#1>#";
            String begin = input.replaceAll(pattern, replacement);
            String extract = begin.replaceAll(", ", " ");

            return StringUtils
                    .substringBetween(extract, "#<1#", "#1>#")
                    .replaceAll("\\{\\{\\{REPLACE}}}:", "")
                    .replaceAll("\"", "")
                    .trim();

        } catch (Exception ex) {
            return "";
        }

    }

    public static List<String> listNormalize(
            List<String> items,
            String delimiter,
            List<List<String>> listFix
    ) {
        String join = "";
        boolean deviceOn = false;
        List<String> list = new ArrayList<>();

        for (String item : items) {

            for (List<String> clear : listFix) {
                item = item.replaceAll(clear.get(0), clear.get(1));
            }

            String[] delimiters = delimiter.split("\\|");

            boolean contains = false;
            for (String delimit : delimiters) {

                if (item.contains(delimit)) {
                    contains = true;
                    break;
                }
            }

            if (contains) {

                if (deviceOn) {
                    list.add(join);
                    join = item;
                } else {
                    join = item;
                    deviceOn = true;
                }

            } else {
                join += " "+item;
            }

        }

        //Get last Device
        list.add(join);

        return list;
    }
}
