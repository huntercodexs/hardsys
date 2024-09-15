package com.huntercodexs.hardsys.processing;

import com.huntercodexs.hardsys.core.HardSysBase;
import com.huntercodexs.hardsys.command.HardSysCommands;

import java.util.ArrayList;
import java.util.List;

import static com.huntercodexs.hardsys.dependency.HardSysParserService.jsonCreatorRFC8259;

public class HardSysRunningDetails extends HardSysBase {

    private final String resourceName = "running";
    private final List<String> runningDetails;
    private final HardSysCommands command;

    public HardSysRunningDetails(List<String> runningDetails, HardSysCommands command) {
        this.command = command;
        this.runningDetails = runningDetails;
    }

    private List<String> detailsFromLinuxCommandInxi() {
        List<String> filter = new ArrayList<>();
        for (String details : this.runningDetails) {

            details = indexer(details, "Compilers: ", "compilers: N/A ", "", false);
            details = indexer(details, "Client: ", "client", ": ", true);
            filter.add(details);

        }
        return filter;
    }

    private List<String> detailsFromLinuxCommandHwinfo() {
        List<String> filter = new ArrayList<>();
        int n = 0;
        for (String details : this.runningDetails) {
            filter.add(details
                    .replaceAll("Compilers: ", "compilers: N/A ")
                    .replaceFirst("Client: ", "client_"+n+": ")
            );
            n++;
        }
        return filter;
    }

    private List<String> detailsFromLinuxCommandLshw() {
        List<String> listFilter = new ArrayList<>();
        int index = 0;
        for (String details : this.runningDetails) {
            if (details.isEmpty() || !details.contains(hardsysCheck("running"))) continue;
            listFilter.add(lshwFilter(details, hardsysCheck("running"), index));
            index++;
        }
        return listFilter;
    }

    private List<String> detailsFromLinuxCommandLscpu() {
        List<String> filter = new ArrayList<>();
        int n = 0;
        for (String details : this.runningDetails) {
            filter.add(details
                    .replaceAll("Compilers: ", "compilers: N/A ")
                    .replaceFirst("Client: ", "client_"+n+": ")
            );
            n++;
        }
        return filter;
    }

    private List<String> detailsFromLinuxCommandLscpu2() {
        List<String> filter = new ArrayList<>();
        int n = 0;
        for (String details : this.runningDetails) {
            filter.add(details
                    .replaceAll("Compilers: ", "compilers: N/A ")
                    .replaceFirst("Client: ", "client_"+n+": ")
            );
            n++;
        }
        return filter;
    }

    private List<String> detailsFromLinuxCommandDmidecode() {
        List<String> filter = new ArrayList<>();
        int n = 0;
        for (String details : this.runningDetails) {
            filter.add(details
                    .replaceAll("Compilers: ", "compilers: N/A ")
                    .replaceFirst("Client: ", "client_"+n+": ")
            );
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
