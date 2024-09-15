package com.huntercodexs.hardsys.processing;

import com.huntercodexs.hardsys.command.HardSysCommands;
import com.huntercodexs.hardsys.core.HardSysBase;

import java.util.ArrayList;
import java.util.List;

import static com.huntercodexs.hardsys.dependency.HardSysParserService.jsonCreatorRFC8259;

public class HardSysMultimediaDetails extends HardSysBase {

    private final String resName = "multimedia";
    private final String resNameUpper = resName.toUpperCase();
    private final HardSysCommands command;
    private final List<String> multimediaDetails;

    public HardSysMultimediaDetails(List<String> devices, HardSysCommands command) {
        this.command = command;
        this.multimediaDetails = devices;
    }

    private List<String> detailsFromLinuxCommandInxi() {
        List<String> filter = new ArrayList<>();
        for (String details : this.multimediaDetails) {
            filter.add(details.replaceAll(resNameUpper+": ", resName+": "));
        }
        return filter;
    }

    private List<String> detailsFromLinuxCommandHwinfo() {
        List<String> filter = new ArrayList<>();
        for (String details : this.multimediaDetails) {
            if (details == null || details.isEmpty()) continue;
            filter.add(detailsFilter(details, "name"));
        }
        return filter;
    }

    private List<String> detailsFromLinuxCommandLshw() {
        List<String> listFilter = new ArrayList<>();
        int index = 0;
        for (String details : this.multimediaDetails) {
            if (details.isEmpty() || !details.contains(hardsysCheck("multimedia"))) continue;
            listFilter.add(lshwFilter(details, hardsysCheck("multimedia"), index));
            index++;
        }
        return listFilter;
    }

    private List<String> detailsFromLinuxCommandLscpu() {
        List<String> filter = new ArrayList<>();
        for (String details : this.multimediaDetails) {
            filter.add(details.replaceAll(resNameUpper+": ", resName+": "));
        }
        return filter;
    }

    private List<String> detailsFromLinuxCommandLscpu2() {
        List<String> filter = new ArrayList<>();
        for (String details : this.multimediaDetails) {
            filter.add(details.replaceAll(resNameUpper+": ", resName+": "));
        }
        return filter;
    }

    private List<String> detailsFromLinuxCommandDmidecode() {
        List<String> filter = new ArrayList<>();
        for (String details : this.multimediaDetails) {
            filter.add(details.replaceAll(resNameUpper+": ", resName+": "));
        }
        return filter;
    }

    public String getDetails() {
        if (this.command.equals(HardSysCommands.INXI)) {
            return jsonCreatorRFC8259(detailsFromLinuxCommandInxi(), hardsysCheck(resName));
        } else if (this.command.equals(HardSysCommands.HWINFO)) {
            return jsonCreatorRFC8259(detailsFromLinuxCommandHwinfo(), hardsysCheck(resName));
        } else if (this.command.equals(HardSysCommands.LSHW)) {
            return jsonCreatorRFC8259(detailsFromLinuxCommandLshw(), hardsysCheck(resName));
        } else if (this.command.equals(HardSysCommands.LSCPU)) {
            return jsonCreatorRFC8259(detailsFromLinuxCommandLscpu(), hardsysCheck(resName));
        } else if (this.command.equals(HardSysCommands.LSPCI)) {
            return jsonCreatorRFC8259(detailsFromLinuxCommandLscpu2(), hardsysCheck(resName));
        } else if (this.command.equals(HardSysCommands.DMIDECODE)) {
            return jsonCreatorRFC8259(detailsFromLinuxCommandDmidecode(), hardsysCheck(resName));
        }
        throw new RuntimeException("Invalid command for "+ hardsysCheck(resName) +": " + this.command);
    }

}

