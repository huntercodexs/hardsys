package com.huntercodexs.hardsys.processing;

import com.huntercodexs.hardsys.core.HardSysBase;
import com.huntercodexs.hardsys.command.HardSysCommands;

import java.util.ArrayList;
import java.util.List;

import static com.huntercodexs.hardsys.dependency.HardSysParserService.jsonCreatorRFC8259;

/**
 * @implNote This class only process for JSON format results
 * */
public class HardSysProcessorDetails extends HardSysBase {

    private final String resourceName = "processor";
    private final List<String> processorDetails;
    private final HardSysCommands command;

    public HardSysProcessorDetails(List<String> processor, HardSysCommands command) {
        this.command = command;
        this.processorDetails = processor;
    }

    private List<String> detailsFromLinuxCommandInxi() {
        List<String> filter = new ArrayList<>();
        for (String details : this.processorDetails) {
            filter.add(details
                    .replaceAll("Core speeds \\(MHz\\): 1:", "coreSpeeds: MHz 1:"));
        }
        return filter;
    }

    private List<String> detailsFromLinuxCommandHwinfo() {
        List<String> filter = new ArrayList<>();
        for (String details : this.processorDetails) {
            if (details == null || details.isEmpty()) continue;
            filter.add(detailsFilter(details, "core"));
        }
        return filter;
    }

    private List<String> detailsFromLinuxCommandLshw() {
        List<String> listFilter = new ArrayList<>();
        int index = 0;
        for (String details : this.processorDetails) {
            if (details.isEmpty() || !details.contains(hardsysCheck("processor"))) continue;
            listFilter.add(lshwFilter(details, hardsysCheck("processor"), index));
            index++;
        }
        return listFilter;
    }

    private List<String> detailsFromLinuxCommandLscpu() {
        List<String> filter = new ArrayList<>();
        for (String details : this.processorDetails) {
            filter.add(details
                    .replaceAll("Core speeds \\(MHz\\): 1:", "coreSpeeds: MHz 1:"));
        }
        return filter;
    }

    private List<String> detailsFromLinuxCommandLscpu2() {
        List<String> filter = new ArrayList<>();
        for (String details : this.processorDetails) {
            filter.add(details
                    .replaceAll("Core speeds \\(MHz\\): 1:", "coreSpeeds: MHz 1:"));
        }
        return filter;
    }

    private List<String> detailsFromLinuxCommandDmidecode() {
        List<String> filter = new ArrayList<>();
        for (String details : this.processorDetails) {
            filter.add(details
                    .replaceAll("Core speeds \\(MHz\\): 1:", "coreSpeeds: MHz 1:"));
        }
        return filter;
    }

    public String getDetails() {
        if (this.command.equals(HardSysCommands.INXI)) {
            return jsonCreatorRFC8259(detailsFromLinuxCommandInxi(), hardsysCheck(resourceName));
        } else if (this.command.equals(HardSysCommands.HWINFO)) {
            return jsonCreatorRFC8259(detailsFromLinuxCommandHwinfo(), hardsysCheck(resourceName));
        } else if (this.command.equals(HardSysCommands.LSHW)) {
            return jsonCreatorRFC8259(detailsFromLinuxCommandLshw(), hardsysCheck(resourceName));
        } else if (this.command.equals(HardSysCommands.LSCPU)) {
            return jsonCreatorRFC8259(detailsFromLinuxCommandLscpu(), hardsysCheck(resourceName));
        } else if (this.command.equals(HardSysCommands.LSPCI)) {
            return jsonCreatorRFC8259(detailsFromLinuxCommandLscpu2(), hardsysCheck(resourceName));
        } else if (this.command.equals(HardSysCommands.DMIDECODE)) {
            return jsonCreatorRFC8259(detailsFromLinuxCommandDmidecode(), hardsysCheck(resourceName));
        }
        throw new RuntimeException("Invalid command for "+ hardsysCheck(resourceName) +": " + this.command);
    }

}
