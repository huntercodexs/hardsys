package com.huntercodexs.hardsys.processing;

import com.huntercodexs.hardsys.core.HardSysBase;
import com.huntercodexs.hardsys.command.HardSysCommands;

import java.util.ArrayList;
import java.util.List;

import static com.huntercodexs.hardsys.dependency.HardSysParserService.jsonCreatorRFC8259;

public class HardSysSystemDetails extends HardSysBase {

    private final String resourceName = "system";
    private final List<String> systemDetails;
    private final HardSysCommands command;

    public HardSysSystemDetails(List<String> system, HardSysCommands command) {
        this.command = command;
        this.systemDetails = system;
    }

    private List<String> detailsFromLinuxCommandInxi() {
        List<String> filter = new ArrayList<>();
        for (String details : this.systemDetails) {
            filter.add(details
                    .replaceAll("Kernel:", "kernel:")
                    .replaceAll("Desktop:", "desktop:")
                    .replaceAll("Distro:", "distro:"));
        }
        return filter;
    }

    private List<String> detailsFromLinuxCommandHwinfo() {
        List<String> filter = new ArrayList<>();
        for (String details : this.systemDetails) {
            if (details.isEmpty()) continue;
            filter.add(details
                    .replaceAll("type: system ", "")
                    .replaceAll("Kernel:", "kernel:")
                    .replaceAll("Desktop:", "desktop:")
                    .replaceAll("Distro:", "distro:"));
        }
        return filter;
    }

    private List<String> detailsFromLinuxCommandLshw() {
        List<String> listFilter = new ArrayList<>();
        int index = 0;
        for (String details : this.systemDetails) {
            if (details.isEmpty() || !details.contains(hardsysCheck("system"))) continue;
            listFilter.add(lshwFilter(details, hardsysCheck("system"), index));
            index++;
        }
        return listFilter;
    }

    private List<String> detailsFromLinuxCommandLscpu() {
        List<String> filter = new ArrayList<>();
        for (String details : this.systemDetails) {
            filter.add(details
                    .replaceAll("Kernel:", "kernel:")
                    .replaceAll("Desktop:", "desktop:")
                    .replaceAll("Distro:", "distro:"));
        }
        return filter;
    }

    private List<String> detailsFromLinuxCommandLscpu2() {
        List<String> filter = new ArrayList<>();
        for (String details : this.systemDetails) {
            filter.add(details
                    .replaceAll("Kernel:", "kernel:")
                    .replaceAll("Desktop:", "desktop:")
                    .replaceAll("Distro:", "distro:"));
        }
        return filter;
    }

    private List<String> detailsFromLinuxCommandDmidecode() {
        List<String> filter = new ArrayList<>();
        for (String details : this.systemDetails) {
            filter.add(details
                    .replaceAll("Kernel:", "kernel:")
                    .replaceAll("Desktop:", "desktop:")
                    .replaceAll("Distro:", "distro:"));
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
