package com.huntercodexs.hardsys.processing;

import com.huntercodexs.hardsys.core.HardSysBase;
import com.huntercodexs.hardsys.command.HardSysCommands;

import java.util.ArrayList;
import java.util.List;

import static com.huntercodexs.hardsys.dependency.HardSysParserService.jsonCreatorRFC8259;

public class HardSysAudioDetails extends HardSysBase {

    private final String resourceName = "audio";
    private final List<String> audioDetails;
    private final HardSysCommands command;

    public HardSysAudioDetails(List<String> audio, HardSysCommands command) {
        this.command = command;
        this.audioDetails = audio;
    }

    private List<String> detailsFromLinuxCommandInxi() {
        List<String> filter = new ArrayList<>();
        for (String details : this.audioDetails) {

            details = indexer(details, "Sound Server: ", "soundServer", ": ", false);
            details = indexer(details, "v: ", "version", ": ", true);
            details = indexer(details, "bus ID: ", "busId", ": ", true);
            details = indexer(details, "vendor: ", "vendor", ": ", true);
            details = indexer(details, "driver: ", "driver", ": ", true);
            details = indexer(details, "busId: ", "busId", ": ", true);
            filter.add(details);

        }
        return filter;
    }

    private List<String> detailsFromLinuxCommandHwinfo() {
        List<String> filter = new ArrayList<>();
        for (String details : this.audioDetails) {
            if (details == null || details.isEmpty()) continue;
            filter.add(detailsFilter(details, "source"));
        }
        return filter;
    }

    private List<String> detailsFromLinuxCommandLshw() {
        List<String> listFilter = new ArrayList<>();
        int index = 0;
        for (String details : this.audioDetails) {
            if (details.isEmpty() || !details.contains(hardsysCheck("audio"))) continue;
            listFilter.add(lshwFilter(details, hardsysCheck("audio"), index));
            index++;
        }
        return listFilter;
    }

    private List<String> detailsFromLinuxCommandLscpu() {
        List<String> filter = new ArrayList<>();
        int n = 0;
        for (String details : this.audioDetails) {
            filter.add(details
                    .replaceAll("Sound Server: ", "soundServer: ")
                    .replaceFirst(" v:", " version_"+n+":")
                    .replaceAll("bus ID: ", "busId: ")
                    .replaceFirst("vendor: ", "vendor_"+n+": ")
                    .replaceFirst("driver: ", "driver_"+n+": ")
                    .replaceFirst("busId: ", "busId_"+n+": "));
            n++;
        }
        return filter;
    }

    private List<String> detailsFromLinuxCommandLscpu2() {
        List<String> filter = new ArrayList<>();
        int n = 0;
        for (String details : this.audioDetails) {
            filter.add(details
                    .replaceAll("Sound Server: ", "soundServer: ")
                    .replaceFirst(" v:", " version_"+n+":")
                    .replaceAll("bus ID: ", "busId: ")
                    .replaceFirst("vendor: ", "vendor_"+n+": ")
                    .replaceFirst("driver: ", "driver_"+n+": ")
                    .replaceFirst("busId: ", "busId_"+n+": "));
            n++;
        }
        return filter;
    }

    private List<String> detailsFromLinuxCommandDmidecode() {
        List<String> filter = new ArrayList<>();
        int n = 0;
        for (String details : this.audioDetails) {
            filter.add(details
                    .replaceAll("Sound Server: ", "soundServer: ")
                    .replaceFirst(" v:", " version_"+n+":")
                    .replaceAll("bus ID: ", "busId: ")
                    .replaceFirst("vendor: ", "vendor_"+n+": ")
                    .replaceFirst("driver: ", "driver_"+n+": ")
                    .replaceFirst("busId: ", "busId_"+n+": "));
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
