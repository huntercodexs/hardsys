package com.huntercodexs.hardsys.core;

import com.huntercodexs.hardsys.dependency.HardSysBasicService;
import com.huntercodexs.hardsys.command.HardSysCommands;
import com.huntercodexs.hardsys.dto.HardSysResourcesDto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;

import static com.huntercodexs.hardsys.command.HardSysCommands.sysCmd;

public abstract class HardSysBase extends HardSysPattern {

    private boolean jsonOn = false;
    private final HardSysBasicService stringHandler = new HardSysBasicService();

    protected HardSysCommands command;
    protected HashMap<String, Object> transport;
    protected HashMap<String, List<String>> resources;

    protected String[] hardsysFields() {
        Field[] fields = HardSysResourcesDto.class.getDeclaredFields();
        int len = fields.length;
        String[] names = new String[len];

        for (int i = 0; i < len; i++) {
            names[i] = fields[i].getName();
        }
        return names;
    }

    protected String hardsysCheck(String target) {
        Field[] fields = HardSysResourcesDto.class.getDeclaredFields();

        for (Field field : fields) {
            if (field.getName().equalsIgnoreCase(target)) {
                return target;
            }
        }
        throw new RuntimeException("ERROR: HARDSYS resource not found: " + target);
    }

    protected BufferedReader execute(HardSysCommands command) {
        Process process;
        try {
            process = Runtime.getRuntime().exec(sysCmd(command));
            return  new BufferedReader(new InputStreamReader(process.getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected void setJsonOn() {
        this.jsonOn = true;
    }

    protected boolean getJsonOn() {
        return this.jsonOn;
    }

    protected void indexerRestart() {
        this.stringHandler.setIndex(0);
    }

    protected void indexerUpdate(int index) {
        this.stringHandler.setIndex(index);
    }

    protected String indexer(String input, String target, String replacement, String separator, boolean indexer) {
        return this.stringHandler.replaceIndexing(input, target, replacement, separator, indexer);
    }

    protected String detailsFilter(String input, String field) {
        input = indexer(input, "(\\w+)", field+": $1", "", false);
        input = indexer(input, field+": ", field, ": ", true);
        return input;
    }

    protected String sourceFilter(String input, String type, int index, String field, String replacer) {
        input = input.replaceAll("type: "+type+" ", "");

        indexerUpdate(index);
        input = indexer(input, field+": ", replacer, ": ", true);

        indexerUpdate(index);
        input = indexer(input, "description: ", "description", ": ", true);

        input = input.replaceAll("\\.@\\.", ":");

        return input;
    }

    protected String lshwFilter(String input, String type, int index) {
        input = input.replaceAll("type: "+type+" ", "");

        indexerUpdate(index);
        input = indexer(input, "source: ", "source", ": ", true);

        indexerUpdate(index);
        input = indexer(input, "description: ", "description", ": ", true);

        indexerUpdate(index);
        input = indexer(input, "device: ", "device", ": ", true);

        return input;
    }

}
