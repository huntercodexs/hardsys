package com.huntercodexs.hardsys.group;

import com.huntercodexs.hardsys.command.HardSysCommands;
import com.huntercodexs.hardsys.core.HardSysBase;
import com.huntercodexs.hardsys.processing.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.huntercodexs.hardsys.dependency.HardSysParserService.jsonCreatorRFC8259;
import static com.huntercodexs.hardsys.dependency.HardSysParserService.jsonMergerRFC8259;

public class HardSysNetworkGroupDetails extends HardSysBase {

    private final List<String> networkDetails;
    private final HardSysCommands command;
    private final String resourceName = "networksGroup";

    public HardSysNetworkGroupDetails(List<String> network, HardSysCommands command) {
        this.command = command;
        this.networkDetails = network;
    }

    private List<String> detailsFromLinuxCommandInxi(String device) {
        List<String> listFilter = new ArrayList<>();
        for (String details : this.networkDetails) {
            if (!details.contains("type: "+device)) continue;
            details = details.replaceAll("type: " + device +" ?", "");
            listFilter.add(details);
        }
        return listFilter;
    }

    private List<String> detailsFromLinuxCommandHwinfo(String device, boolean replace) {
        List<String> listFilter = new ArrayList<>();
        for (String details : this.networkDetails) {
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
        for (String details : this.networkDetails) {
            if (!details.contains("type: "+device)) continue;
            listFilter.add(details);
        }
        return listFilter;
    }

    private List<String> detailsFromLinuxCommandLscpu() {
        List<String> filter = new ArrayList<>();
        int n = 0;
        for (String details : this.networkDetails) {
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

    private List<String> detailsFromLinuxCommandLsPci() {
        List<String> filter = new ArrayList<>();
        int n = 0;
        for (String details : this.networkDetails) {
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

    private List<String> detailsFromLinuxCommandLsUsb() {
        List<String> filter = new ArrayList<>();
        int n = 0;
        for (String details : this.networkDetails) {
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
        for (String details : this.networkDetails) {
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

    private List<String> detailsFromWindowsCommandSystemInfo() {
        List<String> filter = new ArrayList<>();
        int n = 0;
        for (String details : this.networkDetails) {
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

    private String groupsByInxiCommand() {

        String network = new HardSysNetworkDetails(
                detailsFromLinuxCommandInxi(hardsysCheck("network")),
                this.command).getDetails();

        String nicInterface = new HardSysNicInterfaceDetails(
                detailsFromLinuxCommandInxi(hardsysCheck("nicInterface")),
                this.command).getDetails();

        String bridge = new HardSysBridgeDetails(
                detailsFromLinuxCommandInxi(hardsysCheck("bridge")),
                this.command).getDetails();

        String hub = new HardSysHubDetails(
                detailsFromLinuxCommandInxi(hardsysCheck("hub")),
                this.command).getDetails();

        String switcher = new HardSysSwitchDetails(
                detailsFromLinuxCommandInxi(hardsysCheck("switcher")),
                this.command).getDetails();

        return jsonMergerRFC8259(Arrays.asList(network, nicInterface, bridge, hub, switcher), hardsysCheck(resourceName));

    }

    private String groupsByHwinfoCommand() {

        String network = new HardSysNetworkDetails(
                detailsFromLinuxCommandHwinfo(hardsysCheck("network"), false),
                this.command).getDetails();

        String nicInterface = new HardSysNicInterfaceDetails(
                detailsFromLinuxCommandHwinfo(hardsysCheck("nicInterface"), false),
                this.command).getDetails();

        String bridge = new HardSysBridgeDetails(
                detailsFromLinuxCommandHwinfo(hardsysCheck("bridge"), true),
                this.command).getDetails();

        String hub = new HardSysHubDetails(
                detailsFromLinuxCommandHwinfo(hardsysCheck("hub"), true),
                this.command).getDetails();

        String switcher = new HardSysSwitchDetails(
                detailsFromLinuxCommandHwinfo(hardsysCheck("switcher"), true),
                this.command).getDetails();

        return jsonMergerRFC8259(Arrays.asList(network, nicInterface, bridge, hub, switcher), hardsysCheck(resourceName));
    }

    private String groupsByLshwCommand() {

        String network = new HardSysNetworkDetails(
                detailsFromLinuxCommandLshw(hardsysCheck("network")),
                this.command).getDetails();

        String bridge = new HardSysBridgeDetails(
                detailsFromLinuxCommandLshw(hardsysCheck("bridge")),
                this.command).getDetails();

        return jsonMergerRFC8259(Arrays.asList(network, bridge), hardsysCheck(resourceName));
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
