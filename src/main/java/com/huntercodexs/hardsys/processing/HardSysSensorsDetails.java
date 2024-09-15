package com.huntercodexs.hardsys.processing;

import com.huntercodexs.hardsys.command.HardSysCommands;
import com.huntercodexs.hardsys.core.HardSysBase;

import java.util.ArrayList;
import java.util.List;

import static com.huntercodexs.hardsys.dependency.HardSysParserService.jsonCreatorRFC8259;

public class HardSysSensorsDetails extends HardSysBase {

    private final String resourceName = "sensors";
    private final List<String> sensorsDetails;
    private final HardSysCommands command;

    public HardSysSensorsDetails(List<String> sensors, HardSysCommands command) {
        this.command = command;
        this.sensorsDetails = sensors;
    }

    private List<String> detailsFromLinuxCommandInxi() {
        List<String> filter = new ArrayList<>();
        for (String details : this.sensorsDetails) {
            filter.add(details
                    .replaceAll("System Temperatures: ", "temp: ºC ")
                    .replaceAll("Fan Speeds \\(RPM\\): ", "rpm: ")
            );
        }
        return filter;
    }

    private List<String> detailsFromLinuxCommandHwinfo() {
        List<String> filter = new ArrayList<>();
        for (String details : this.sensorsDetails) {
            filter.add(details
                    .replaceAll("System Temperatures: ", "systemTemperatures: ºC ")
                    .replaceAll("Fan Speeds \\(RPM\\): ", "fanSpeedsRPM: ")
            );
        }
        return filter;
    }

    private List<String> detailsFromLinuxCommandLshw() {
        List<String> listFilter = new ArrayList<>();
        int index = 0;
        for (String details : this.sensorsDetails) {
            if (details.isEmpty() || !details.contains(hardsysCheck("sensors"))) continue;
            listFilter.add(lshwFilter(details, hardsysCheck("sensors"), index));
            index++;
        }
        return listFilter;
    }

    private List<String> detailsFromLinuxCommandLscpu() {
        List<String> filter = new ArrayList<>();
        for (String details : this.sensorsDetails) {
            filter.add(details
                    .replaceAll("System Temperatures: ", "systemTemperatures: ºC ")
                    .replaceAll("Fan Speeds \\(RPM\\): ", "fanSpeedsRPM: ")
            );
        }
        return filter;
    }

    private List<String> detailsFromLinuxCommandLscpu2() {
        List<String> filter = new ArrayList<>();
        for (String details : this.sensorsDetails) {
            filter.add(details
                    .replaceAll("System Temperatures: ", "systemTemperatures: ºC ")
                    .replaceAll("Fan Speeds \\(RPM\\): ", "fanSpeedsRPM: ")
            );
        }
        return filter;
    }

    private List<String> detailsFromLinuxCommandDmidecode() {
        List<String> filter = new ArrayList<>();
        for (String details : this.sensorsDetails) {
            filter.add(details
                    .replaceAll("System Temperatures: ", "systemTemperatures: ºC ")
                    .replaceAll("Fan Speeds \\(RPM\\): ", "fanSpeedsRPM: ")
            );
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
