package com.huntercodexs.hardsys.processing;

import com.huntercodexs.hardsys.core.HardSysBase;
import com.huntercodexs.hardsys.command.HardSysCommands;

import java.util.ArrayList;
import java.util.List;

import static com.huntercodexs.hardsys.dependency.HardSysParserService.jsonCreatorRFC8259;

public class HardSysMachineDetails extends HardSysBase {

    private final String resourceName = "machine";
    private final List<String> machineDetails;
    private final HardSysCommands command;

    public HardSysMachineDetails(List<String> machine, HardSysCommands command) {
        this.command = command;
        this.machineDetails = machine;
    }

    private List<String> detailsFromLinuxCommandInxi() {
        List<String> filter = new ArrayList<>();
        for (String details : this.machineDetails) {

            details = indexer(details, "Type: ", "type", ": ", false);
            details = indexer(details, "System: ", "system", ": ", false);
            details = indexer(details, "serial: ", "serial", ": ", true);
            details = indexer(details, "v: ", "version", ": ", true);
            filter.add(details);

        }
        return filter;
    }

    private List<String> detailsFromLinuxCommandHwinfo() {
        List<String> filter = new ArrayList<>();
        int n = 0;
        for (String details : this.machineDetails) {
            filter.add(details
                    .replaceAll("Type:", "type:")
                    .replaceAll("System:", "system:")
                    .replaceFirst("serial:", "serial_"+n+":")
                    .replaceFirst(" v:", " version_"+n+":"));
            n++;
        }
        return filter;
    }

    private List<String> detailsFromLinuxCommandLshw() {
        List<String> listFilter = new ArrayList<>();
        int index = 0;
        for (String details : this.machineDetails) {
            if (details.isEmpty() || !details.contains(hardsysCheck("machine"))) continue;
            listFilter.add(lshwFilter(details, hardsysCheck("machine"), index));
            index++;
        }
        return listFilter;
    }

    private List<String> detailsFromLinuxCommandLscpu() {
        List<String> filter = new ArrayList<>();
        int n = 0;
        for (String details : this.machineDetails) {
            filter.add(details
                    .replaceAll("Type:", "type:")
                    .replaceAll("System:", "system:")
                    .replaceFirst("serial:", "serial_"+n+":")
                    .replaceFirst(" v:", " version_"+n+":"));
            n++;
        }
        return filter;
    }

    private List<String> detailsFromLinuxCommandLscpu2() {
        List<String> filter = new ArrayList<>();
        int n = 0;
        for (String details : this.machineDetails) {
            filter.add(details
                    .replaceAll("Type:", "type:")
                    .replaceAll("System:", "system:")
                    .replaceFirst("serial:", "serial_"+n+":")
                    .replaceFirst(" v:", " version_"+n+":"));
            n++;
        }
        return filter;
    }

    private List<String> detailsFromLinuxCommandDmidecode() {
        List<String> filter = new ArrayList<>();
        int n = 0;
        for (String details : this.machineDetails) {
            filter.add(details
                    .replaceAll("Type:", "type:")
                    .replaceAll("System:", "system:")
                    .replaceFirst("serial:", "serial_"+n+":")
                    .replaceFirst(" v:", " version_"+n+":"));
            n++;
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
