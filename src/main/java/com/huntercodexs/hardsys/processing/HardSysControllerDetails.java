package com.huntercodexs.hardsys.processing;

import com.huntercodexs.hardsys.command.HardSysCommands;
import com.huntercodexs.hardsys.core.HardSysBase;

import java.util.ArrayList;
import java.util.List;

import static com.huntercodexs.hardsys.dependency.HardSysParserService.jsonCreatorRFC8259;

public class HardSysControllerDetails extends HardSysBase {

    private final String resourceName = "controller";
    private final HardSysCommands command;
    private final List<String> controllerDetails;

    public HardSysControllerDetails(List<String> baseboard, HardSysCommands command) {
        this.command = command;
        this.controllerDetails = baseboard;
    }

    private List<String> detailsFromLinuxCommandInxi() {
        List<String> filter = new ArrayList<>();
        for (String baseboard : this.controllerDetails) {
            filter.add(baseboard.replaceAll("CONTROLLER: ", resourceName+": "));
        }
        return filter;
    }

    private List<String> detailsFromLinuxCommandHwinfo() {
        List<String> filter = new ArrayList<>();
        for (String baseboard : this.controllerDetails) {
            filter.add(baseboard.replaceAll("CONTROLLER: ", resourceName+": "));
        }
        return filter;
    }

    private List<String> detailsFromLinuxCommandLshw() {
        List<String> listFilter = new ArrayList<>();
        int index = 0;
        for (String details : this.controllerDetails) {
            if (details.isEmpty() || !details.contains(hardsysCheck("controller"))) continue;
            listFilter.add(lshwFilter(details, hardsysCheck("controller"), index));
            index++;
        }
        return listFilter;
    }

    private List<String> detailsFromLinuxCommandLscpu() {
        List<String> filter = new ArrayList<>();
        for (String baseboard : this.controllerDetails) {
            filter.add(baseboard.replaceAll("CONTROLLER: ", resourceName+": "));
        }
        return filter;
    }

    private List<String> detailsFromLinuxCommandLscpu2() {
        List<String> filter = new ArrayList<>();
        for (String baseboard : this.controllerDetails) {
            filter.add(baseboard.replaceAll("CONTROLLER: ", resourceName+": "));
        }
        return filter;
    }

    private List<String> detailsFromLinuxCommandDmidecode() {
        List<String> filter = new ArrayList<>();
        for (String baseboard : this.controllerDetails) {
            filter.add(baseboard.replaceAll("CONTROLLER: ", resourceName+": "));
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
        throw new RuntimeException("Invalid command for " + hardsysCheck(resourceName) + ": " + this.command);
    }

}
