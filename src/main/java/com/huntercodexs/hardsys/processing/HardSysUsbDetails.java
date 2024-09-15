package com.huntercodexs.hardsys.processing;

import com.huntercodexs.hardsys.core.HardSysBase;
import com.huntercodexs.hardsys.command.HardSysCommands;

import java.util.ArrayList;
import java.util.List;

import static com.huntercodexs.hardsys.dependency.HardSysParserService.jsonCreatorRFC8259;

public class HardSysUsbDetails extends HardSysBase {

    private final String resourceName = "usb";
    private final List<String> usbDetails;
    private final HardSysCommands command;

    public HardSysUsbDetails(List<String> usb, HardSysCommands command) {
        this.command = command;
        this.usbDetails = usb;
    }

    private List<String> detailsFromLinuxCommandInxi() {
        List<String> filter = new ArrayList<>();
        for (String details : this.usbDetails) {

            details = indexer(details, "(Device-[0-9]): ([0-9]-[0-9]):([0-9])", "$1: $2.$3", "", false);
            details = indexer(details, "info: ", "info", ": ", true);
            details = indexer(details, "rev: ", "rev", ": ", true);
            details = indexer(details, "Hub: ", "Hub", ": ", true);
            details = indexer(details, "type: ", "type", ": ", true);
            details = indexer(details, "driver: ", "driver", ": ", true);
            details = indexer(details, "ports: ", "ports", ": ", true);
            filter.add(details);

        }
        return filter;
    }

    private List<String> detailsFromLinuxCommandHwinfo() {
        List<String> filter = new ArrayList<>();
        for (String details : this.usbDetails) {
            if (details == null || details.isEmpty()) continue;
            filter.add(detailsFilter(details, "source"));
        }
        return filter;
    }

    private List<String> detailsFromLinuxCommandLshw() {
        List<String> listFilter = new ArrayList<>();
        int index = 0;
        for (String details : this.usbDetails) {
            if (details.isEmpty() || !details.contains(hardsysCheck("usb"))) continue;
            listFilter.add(lshwFilter(details, hardsysCheck("usb"), index));
            index++;
        }
        return listFilter;
    }

    private List<String> detailsFromLinuxCommandLscpu() {
        List<String> filter = new ArrayList<>();
        int n = 0;
        for (String details : this.usbDetails) {
            filter.add(details
                    .replaceAll("(Device-[0-9]): ([0-9]-[0-9]):([0-9])", "$1: $2.$3")
                    .replaceFirst("info: ", "info_"+n+": ")
                    .replaceFirst("rev: ", "rev_"+n+": ")
                    .replaceFirst("Hub: ", "hub_"+n+": ")
                    .replaceFirst("type: ", "type_"+n+": ")
                    .replaceFirst("driver: ", "driver_"+n+": ")
                    .replaceFirst("ports: ", "ports_"+n+": "));
            n++;
        }
        return filter;
    }

    private List<String> detailsFromLinuxCommandLscpu2() {
        List<String> filter = new ArrayList<>();
        int n = 0;
        for (String details : this.usbDetails) {
            filter.add(details
                    .replaceAll("(Device-[0-9]): ([0-9]-[0-9]):([0-9])", "$1: $2.$3")
                    .replaceFirst("info: ", "info_"+n+": ")
                    .replaceFirst("rev: ", "rev_"+n+": ")
                    .replaceFirst("Hub: ", "hub_"+n+": ")
                    .replaceFirst("type: ", "type_"+n+": ")
                    .replaceFirst("driver: ", "driver_"+n+": ")
                    .replaceFirst("ports: ", "ports_"+n+": "));
            n++;
        }
        return filter;
    }

    private List<String> detailsFromLinuxCommandDmidecode() {
        List<String> filter = new ArrayList<>();
        int n = 0;
        for (String details : this.usbDetails) {
            filter.add(details
                    .replaceAll("(Device-[0-9]): ([0-9]-[0-9]):([0-9])", "$1: $2.$3")
                    .replaceFirst("info: ", "info_"+n+": ")
                    .replaceFirst("rev: ", "rev_"+n+": ")
                    .replaceFirst("Hub: ", "hub_"+n+": ")
                    .replaceFirst("type: ", "type_"+n+": ")
                    .replaceFirst("driver: ", "driver_"+n+": ")
                    .replaceFirst("ports: ", "ports_"+n+": "));
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
