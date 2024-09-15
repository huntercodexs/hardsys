package com.huntercodexs.hardsys.group;

import com.huntercodexs.hardsys.command.HardSysCommands;
import com.huntercodexs.hardsys.core.HardSysBase;
import com.huntercodexs.hardsys.core.HardSysResources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.huntercodexs.hardsys.dependency.HardSysParserService.jsonMergerRFC8259;

/**
 * @implNote This class only process for JSON format results
 * */
public class HardSysAllGroupDetails extends HardSysBase {

    private final String resourceName = "all";
    private final HardSysCommands command;
    private final HardSysResources allResources;

    public HardSysAllGroupDetails(HardSysResources allResources, HardSysCommands command) {
        this.command = command;
        this.allResources = allResources;
    }

    private List<String> detailsFromLinuxCommandInxi() {
        return Arrays.asList(
                this.allResources.getSystem().getDetails(),
                this.allResources.getMachine().getDetails(),
                this.allResources.getBattery().getDetails(),
                this.allResources.getMemory().getDetails(),
                this.allResources.getSlots().getDetails(),
                this.allResources.getProcessor().getDetails(),
                this.allResources.getGraphics().getDetails(),
                this.allResources.getAudio().getDetails(),
                this.allResources.getNetwork().getDetails(),
                this.allResources.getDrives().getDetails(),
                this.allResources.getPartition().getDetails(),
                this.allResources.getUsb().getDetails(),
                this.allResources.getSensors().getDetails(),
                this.allResources.getRunning().getDetails(),
                this.allResources.getPrinter().getDetails());
    }

    private List<String> detailsFromLinuxCommandHwinfo() {
        return Arrays.asList(
            this.allResources.getSystem().getDetails(),
            this.allResources.getProcessor().getDetails(),
            this.allResources.getKeyboard().getDetails(),
            this.allResources.getMouse().getDetails(),
            this.allResources.getMonitor().getDetails(),
            this.allResources.getGraphics().getDetails(),
            this.allResources.getAudio().getDetails(),
            this.allResources.getStorage().getDetails(),
            this.allResources.getNetwork().getDetails(),
            this.allResources.getNicInterface().getDetails(),
            this.allResources.getDisk().getDetails(),
            this.allResources.getPartition().getDetails(),
            this.allResources.getCdRom().getDetails(),
            this.allResources.getUsb().getDetails(),
            this.allResources.getBios().getDetails(),
            this.allResources.getBridge().getDetails(),
            this.allResources.getHub().getDetails(),
            this.allResources.getMemory().getDetails(),
            this.allResources.getBluetooth().getDetails(),
            this.allResources.getUnknown().getDetails(),
            this.allResources.getMultimedia().getDetails(),
            this.allResources.getPrinter().getDetails());
    }

    private List<String> detailsFromLinuxCommandLshw() {
        return Arrays.asList(
                this.allResources.getBridge().getDetails(),
                this.allResources.getController().getDetails(),
                this.allResources.getDisk().getDetails(),
                this.allResources.getGraphics().getDetails(),
                this.allResources.getUnknown().getDetails(),
                this.allResources.getMouse().getDetails(),
                this.allResources.getKeyboard().getDetails(),
                this.allResources.getMemory().getDetails(),
                this.allResources.getMultimedia().getDetails(),
                this.allResources.getNetwork().getDetails(),
                this.allResources.getProcessor().getDetails(),
                this.allResources.getStorage().getDetails(),
                this.allResources.getMachine().getDetails()
        );
    }

    private List<String> detailsFromLinuxCommandLscpu() {
        List<String> filter = new ArrayList<>();
        return filter;
    }

    private List<String> detailsFromLinuxCommandLsPci() {
        List<String> filter = new ArrayList<>();
        return filter;
    }

    private List<String> detailsFromLinuxCommandLsUsb() {
        List<String> filter = new ArrayList<>();
        return filter;
    }

    private List<String> detailsFromLinuxCommandDmidecode() {
        List<String> filter = new ArrayList<>();
        return filter;
    }

    public String getDetails() {
        if (this.command.equals(HardSysCommands.INXI)) {
            return jsonMergerRFC8259(detailsFromLinuxCommandInxi(), hardsysCheck(resourceName));
        } else if (this.command.equals(HardSysCommands.HWINFO)) {
            return jsonMergerRFC8259(detailsFromLinuxCommandHwinfo(), hardsysCheck(resourceName));
        } else if (this.command.equals(HardSysCommands.LSHW)) {
            return jsonMergerRFC8259(detailsFromLinuxCommandLshw(), hardsysCheck(resourceName));
        } else if (this.command.equals(HardSysCommands.LSCPU)) {
            return jsonMergerRFC8259(detailsFromLinuxCommandLscpu(), hardsysCheck(resourceName));
        } else if (this.command.equals(HardSysCommands.LSPCI)) {
            return jsonMergerRFC8259(detailsFromLinuxCommandLsPci(), hardsysCheck(resourceName));
        } else if (this.command.equals(HardSysCommands.LSUSB)) {
            return jsonMergerRFC8259(detailsFromLinuxCommandLsUsb(), hardsysCheck(resourceName));
        } else if (this.command.equals(HardSysCommands.DMIDECODE)) {
            return jsonMergerRFC8259(detailsFromLinuxCommandDmidecode(), hardsysCheck(resourceName));
        }
        throw new RuntimeException("Invalid command for "+ hardsysCheck(resourceName) +": " + this.command);
    }
}

