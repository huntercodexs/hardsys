package com.huntercodexs.hardsys.processing;

import com.huntercodexs.hardsys.core.HardSysBase;
import com.huntercodexs.hardsys.command.HardSysCommands;

import java.util.ArrayList;
import java.util.List;

import static com.huntercodexs.hardsys.dependency.HardSysParserService.jsonCreatorRFC8259;

public class HardSysNicInterfaceDetails extends HardSysBase {

    private final String resourceName = "nicInterface";
    private final HardSysCommands command;
    private final List<String> nicInterfaceDetails;

    public HardSysNicInterfaceDetails(List<String> network, HardSysCommands command) {
        this.command = command;
        this.nicInterfaceDetails = network;
    }

    private List<String> detailsFromLinuxCommandInxi() {
        List<String> filter = new ArrayList<>();
        for (String details : this.nicInterfaceDetails) {

            details = indexer(details, "bus ID: ", "busId", ": ", false);
            details = indexer(details, "v: ", "version", ": ", true);
            details = indexer(details, "driver: ", "driver", ": ", true);
            details = indexer(details, "port: ", "port", ": ", true);
            details = indexer(details, "busId: ", "busId", ": ", true);
            details = indexer(details, "IF: ", "IF", ": ", true);
            details = indexer(details, "state: ", "state", ": ", true);
            details = indexer(details, "mac: ", "mac", ": ", true);
            filter.add(details);

        }
        return filter;
    }

    private List<String> detailsFromLinuxCommandHwinfo() {
        List<String> listFilter = new ArrayList<>();
        int index = 0;
        for (String details : this.nicInterfaceDetails) {
            if (details.isEmpty() || !details.contains(hardsysCheck("nicInterface"))) continue;
            listFilter.add(sourceFilter(details, hardsysCheck("nicInterface"), index, "source", "source"));
            index++;
        }
        return listFilter;
    }

    private List<String> detailsFromLinuxCommandLshw() {
        List<String> listFilter = new ArrayList<>();
        int index = 0;
        for (String details : this.nicInterfaceDetails) {
            if (details.isEmpty() || !details.contains(hardsysCheck("nicInterface"))) continue;
            listFilter.add(lshwFilter(details, hardsysCheck("nicInterface"), index));
            index++;
        }
        return listFilter;
    }

    private List<String> detailsFromLinuxCommandLscpu() {
        List<String> filter = new ArrayList<>();
        int n = 0;
        for (String details : this.nicInterfaceDetails) {
            filter.add(details
                    .replaceAll("bus ID: ", "busId: ")
                    .replaceFirst(" v:", " version_"+n+":")
                    .replaceFirst("driver: ", "driver_"+n+": ")
                    .replaceFirst("port: ", "port_"+n+": ")
                    .replaceFirst("busId: ", "busId_"+n+": ")
                    .replaceFirst("IF: ", "IF_"+n+": ")
                    .replaceFirst("state: ", "state_"+n+": ")
                    .replaceFirst("mac: ", "mac_"+n+": "));
            n++;
        }
        return filter;
    }

    private List<String> detailsFromLinuxCommandLscpu2() {
        List<String> filter = new ArrayList<>();
        int n = 0;
        for (String details : this.nicInterfaceDetails) {
            filter.add(details
                    .replaceAll("bus ID: ", "busId: ")
                    .replaceFirst(" v:", " version_"+n+":")
                    .replaceFirst("driver: ", "driver_"+n+": ")
                    .replaceFirst("port: ", "port_"+n+": ")
                    .replaceFirst("busId: ", "busId_"+n+": ")
                    .replaceFirst("IF: ", "IF_"+n+": ")
                    .replaceFirst("state: ", "state_"+n+": ")
                    .replaceFirst("mac: ", "mac_"+n+": "));
            n++;
        }
        return filter;
    }

    private List<String> detailsFromLinuxCommandDmidecode() {
        List<String> filter = new ArrayList<>();
        int n = 0;
        for (String details : this.nicInterfaceDetails) {
            filter.add(details
                    .replaceAll("bus ID: ", "busId: ")
                    .replaceFirst(" v:", " version_"+n+":")
                    .replaceFirst("driver: ", "driver_"+n+": ")
                    .replaceFirst("port: ", "port_"+n+": ")
                    .replaceFirst("busId: ", "busId_"+n+": ")
                    .replaceFirst("IF: ", "IF_"+n+": ")
                    .replaceFirst("state: ", "state_"+n+": ")
                    .replaceFirst("mac: ", "mac_"+n+": "));
            n++;
        }
        return filter;
    }

    public String getDetails() {
        if (this.command.equals(HardSysCommands.INXI)) {
            return jsonCreatorRFC8259(detailsFromLinuxCommandInxi(), hardsysCheck(resourceName));
        } else if (this.command.equals(HardSysCommands.HWINFO)) {
            return jsonCreatorRFC8259(detailsFromLinuxCommandHwinfo(), resourceName);
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
