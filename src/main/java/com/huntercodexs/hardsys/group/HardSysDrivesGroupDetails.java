package com.huntercodexs.hardsys.group;

import com.huntercodexs.hardsys.command.HardSysCommands;
import com.huntercodexs.hardsys.core.HardSysBase;
import com.huntercodexs.hardsys.processing.HardSysCdRomDetails;
import com.huntercodexs.hardsys.processing.HardSysDiskDetails;
import com.huntercodexs.hardsys.processing.HardSysPartitionDetails;
import com.huntercodexs.hardsys.processing.HardSysStorageDetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.huntercodexs.hardsys.dependency.HardSysParserService.jsonCreatorRFC8259;
import static com.huntercodexs.hardsys.dependency.HardSysParserService.jsonMergerRFC8259;

public class HardSysDrivesGroupDetails extends HardSysBase {

    private final String resourceName = "drivesGroup";
    private final List<String> drivesDetails;
    private final HardSysCommands command;

    public HardSysDrivesGroupDetails(List<String> devices, HardSysCommands command) {
        this.command = command;
        this.drivesDetails = devices;
    }

    private List<String> detailsFromLinuxCommandInxi(String device) {
        List<String> listFilter = new ArrayList<>();
        for (String details : this.drivesDetails) {
            if (!details.contains("type: "+device)) continue;
            details = details.replaceAll("type: " + device +" ?", "");
            listFilter.add(details);
        }
        return listFilter;
    }

    private List<String> detailsFromLinuxCommandHwinfo(String device, boolean replace) {
        List<String> listFilter = new ArrayList<>();
        for (String details : this.drivesDetails) {
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
        for (String details : this.drivesDetails) {
            if (!details.contains("type: "+device)) continue;
            details = details.replaceAll("type: " + device +" ?", "");
            listFilter.add(details);
        }
        return listFilter;
    }

    private List<String> detailsFromLinuxCommandLscpu() {
        List<String> filter = new ArrayList<>();
        for (String details : this.drivesDetails) {
            filter.add(details.replaceAll("DRIVES GROUP: ", resourceName+": "));
        }
        return filter;
    }

    private List<String> detailsFromLinuxCommandLsPci() {
        List<String> filter = new ArrayList<>();
        for (String details : this.drivesDetails) {
            filter.add(details.replaceAll("DRIVES GROUP: ", resourceName+": "));
        }
        return filter;
    }

    private List<String> detailsFromLinuxCommandLsUsb() {
        List<String> filter = new ArrayList<>();
        for (String details : this.drivesDetails) {
            filter.add(details.replaceAll("DRIVES GROUP: ", resourceName+": "));
        }
        return filter;
    }

    private List<String> detailsFromLinuxCommandDmidecode() {
        List<String> filter = new ArrayList<>();
        for (String details : this.drivesDetails) {
            filter.add(details.replaceAll("DRIVES GROUP: ", resourceName+": "));
        }
        return filter;
    }

    private List<String> detailsFromWindowsCommandSystemInfo() {
        List<String> filter = new ArrayList<>();
        for (String details : this.drivesDetails) {
            filter.add(details.replaceAll("DRIVES GROUP: ", resourceName+": "));
        }
        return filter;
    }

    private String groupsByInxiCommand() {

        String disk = new HardSysDiskDetails(
                detailsFromLinuxCommandInxi(hardsysCheck("disk")),
                this.command).getDetails();

        String partition = new HardSysPartitionDetails(
                detailsFromLinuxCommandInxi(hardsysCheck("partition")),
                this.command).getDetails();

        return jsonMergerRFC8259(Arrays.asList(disk, partition), hardsysCheck(resourceName));

    }

    private String groupsByHwinfoCommand() {

        String disk = new HardSysDiskDetails(
                detailsFromLinuxCommandHwinfo(hardsysCheck("disk"), false),
                this.command).getDetails();

        String partition = new HardSysPartitionDetails(
                detailsFromLinuxCommandHwinfo(hardsysCheck("partition"), false),
                this.command).getDetails();

        String storage = new HardSysStorageDetails(
                detailsFromLinuxCommandHwinfo(hardsysCheck("storage"), true),
                this.command).getDetails();

        String cdrom = new HardSysCdRomDetails(
                detailsFromLinuxCommandHwinfo(hardsysCheck("cdrom"), true),
                this.command).getDetails();

        return jsonMergerRFC8259(Arrays.asList(disk, partition, storage, cdrom), hardsysCheck(resourceName));

    }

    private String groupsByLshwCommand() {

        String disk = new HardSysDiskDetails(
                detailsFromLinuxCommandLshw(hardsysCheck("disk")),
                this.command).getDetails();

        String partition = new HardSysPartitionDetails(
                detailsFromLinuxCommandLshw(hardsysCheck("partition")),
                this.command).getDetails();

        String storage = new HardSysStorageDetails(
                detailsFromLinuxCommandLshw(hardsysCheck("storage")),
                this.command).getDetails();

        return jsonMergerRFC8259(Arrays.asList(disk, partition, storage), hardsysCheck(resourceName));

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

