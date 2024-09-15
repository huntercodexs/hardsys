package com.huntercodexs.hardsys.group;

import com.huntercodexs.hardsys.command.HardSysCommands;
import com.huntercodexs.hardsys.core.HardSysBase;
import com.huntercodexs.hardsys.processing.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.huntercodexs.hardsys.dependency.HardSysParserService.jsonCreatorRFC8259;
import static com.huntercodexs.hardsys.dependency.HardSysParserService.jsonMergerRFC8259;

public class HardSysComponentsGroupDetails extends HardSysBase {

    private final String resourceName = "componentsGroup";
    private final List<String> devicesDetails;
    private final HardSysCommands command;

    public HardSysComponentsGroupDetails(List<String> devices, HardSysCommands command) {
        this.command = command;
        this.devicesDetails = devices;
    }

    private List<String> detailsFromLinuxCommandInxi(String device) {
        List<String> listFilter = new ArrayList<>();
        for (String details : this.devicesDetails) {
            if (!details.contains("type: "+device)) continue;
            details = details.replaceAll("type: " + device +" ?", "");
            listFilter.add(details);
        }
        return listFilter;
    }

    private List<String> detailsFromLinuxCommandHwinfo(String device, boolean replace) {
        List<String> listFilter = new ArrayList<>();
        for (String details : this.devicesDetails) {
            if (!details.contains("type: "+device)) continue;
            if (replace) {
                details = details.replaceAll("type: " + device + " ?", "");
                details = details.replaceAll("source: ?", "");
            }
            listFilter.add(details);
        }
        return listFilter;
    }

    private List<String> detailsFromLinuxCommandLshw(String device) {
        List<String> listFilter = new ArrayList<>();
        for (String details : this.devicesDetails) {
            if (!details.contains("type: "+device)) continue;
            details = details.replaceAll("type: " + device +" ?", "");
            listFilter.add(details);
        }
        return listFilter;
    }

    private List<String> detailsFromLinuxCommandLscpu() {
        List<String> filter = new ArrayList<>();
        for (String details : this.devicesDetails) {
            filter.add(details.replaceAll("COMPONENTS GROUP: ", resourceName+": "));
        }
        return filter;
    }

    private List<String> detailsFromLinuxCommandLsPci() {
        List<String> filter = new ArrayList<>();
        for (String details : this.devicesDetails) {
            filter.add(details.replaceAll("COMPONENTS GROUP: ", resourceName+": "));
        }
        return filter;
    }

    private List<String> detailsFromLinuxCommandLsUsb() {
        List<String> filter = new ArrayList<>();
        for (String details : this.devicesDetails) {
            filter.add(details.replaceAll("COMPONENTS GROUP: ", resourceName+": "));
        }
        return filter;
    }

    private List<String> detailsFromLinuxCommandDmidecode() {
        List<String> filter = new ArrayList<>();
        for (String details : this.devicesDetails) {
            filter.add(details.replaceAll("COMPONENTS GROUP: ", resourceName+": "));
        }
        return filter;
    }

    private List<String> detailsFromWindowsCommandSystemInfo() {
        List<String> filter = new ArrayList<>();
        for (String details : this.devicesDetails) {
            filter.add(details.replaceAll("COMPONENTS GROUP: ", resourceName+": "));
        }
        return filter;
    }

    private String groupsByInxiCommand() {

        String processor = new HardSysProcessorDetails(
                detailsFromLinuxCommandInxi(hardsysCheck("processor")),
                this.command).getDetails();

        String memory = new HardSysMemoryDetails(
                detailsFromLinuxCommandInxi(hardsysCheck("memory")),
                this.command).getDetails();

        String audio = new HardSysAudioDetails(
                detailsFromLinuxCommandInxi(hardsysCheck("audio")),
                this.command).getDetails();

        String battery = new HardSysBatteryDetails(
                detailsFromLinuxCommandInxi(hardsysCheck("battery")),
                this.command).getDetails();

        String sensors = new HardSysSensorsDetails(
                detailsFromLinuxCommandInxi(hardsysCheck("sensors")),
                this.command).getDetails();

        return jsonMergerRFC8259(Arrays.asList(processor, memory, audio, battery, sensors), hardsysCheck(resourceName));
    }

    private String groupsByHwinfoCommand() {

        String processor = new HardSysProcessorDetails(
                detailsFromLinuxCommandHwinfo(hardsysCheck("processor"), true),
                this.command).getDetails();

        String memory = new HardSysMemoryDetails(
                detailsFromLinuxCommandHwinfo(hardsysCheck("memory"), true),
                this.command).getDetails();

        String audio = new HardSysAudioDetails(
                detailsFromLinuxCommandHwinfo(hardsysCheck("audio"), true),
                this.command).getDetails();

        String battery = new HardSysBatteryDetails(
                detailsFromLinuxCommandHwinfo(hardsysCheck("battery"), true),
                this.command).getDetails();

        return jsonMergerRFC8259(Arrays.asList(processor, memory, audio, battery), hardsysCheck(resourceName));

    }

    private String groupsByLshwCommand() {

        String processor = new HardSysProcessorDetails(
                detailsFromLinuxCommandLshw(hardsysCheck("processor")),
                this.command).getDetails();

        String memory = new HardSysMemoryDetails(
                detailsFromLinuxCommandLshw(hardsysCheck("memory")),
                this.command).getDetails();

        String audio = new HardSysAudioDetails(
                detailsFromLinuxCommandLshw(hardsysCheck("multimedia")),
                this.command).getDetails();

        return jsonMergerRFC8259(Arrays.asList(processor, memory, audio), hardsysCheck(resourceName));

    }

    private String groupsByLsCpuCommand() {
        return jsonCreatorRFC8259(detailsFromLinuxCommandLscpu(), hardsysCheck(resourceName));
    }

    private String groupsByLsPciCommand() {
        return jsonCreatorRFC8259(detailsFromLinuxCommandLsPci(), hardsysCheck(resourceName));
    }

    private String groupsByLsUsbCommand() {
        return jsonCreatorRFC8259(detailsFromLinuxCommandLsUsb(), hardsysCheck(resourceName));
    }

    private String groupsByDmidecodeCommand() {
        return jsonCreatorRFC8259(detailsFromLinuxCommandDmidecode(), hardsysCheck(resourceName));
    }

    private String groupsBySystemInfoCommand() {
        return jsonCreatorRFC8259(detailsFromWindowsCommandSystemInfo(), hardsysCheck(resourceName));
    }

    public String getDetails() {

        if (this.command.equals(HardSysCommands.INXI)) {
            return groupsByInxiCommand();

        } else if (this.command.equals(HardSysCommands.HWINFO)) {
            return groupsByHwinfoCommand();

        } else if (this.command.equals(HardSysCommands.LSHW)) {
            return groupsByLshwCommand();

        } else if (this.command.equals(HardSysCommands.LSCPU)) {
            return groupsByLsCpuCommand();

        } else if (this.command.equals(HardSysCommands.LSPCI)) {
            return groupsByLsPciCommand();

        } else if (this.command.equals(HardSysCommands.LSUSB)) {
            return groupsByLsUsbCommand();

        } else if (this.command.equals(HardSysCommands.DMIDECODE)) {
            return groupsByDmidecodeCommand();

        } else if (this.command.equals(HardSysCommands.SYSTEMINFO)) {
            return groupsBySystemInfoCommand();

        }

        throw new RuntimeException("Invalid command for "+ hardsysCheck(resourceName) +": " + this.command);
    }
}

