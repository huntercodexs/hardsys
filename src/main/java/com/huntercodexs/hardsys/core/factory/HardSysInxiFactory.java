package com.huntercodexs.hardsys.core.factory;

import com.huntercodexs.hardsys.core.HardSysBase;
import com.huntercodexs.hardsys.dto.*;
import com.huntercodexs.hardsys.dto.HardSysAudioDto.HardSysAudio;
import com.huntercodexs.hardsys.dto.HardSysBatteryDto.HardSysBattery;
import com.huntercodexs.hardsys.dto.HardSysDrivesDto.HardSysDrives;
import com.huntercodexs.hardsys.dto.HardSysGraphicsDto.HardSysGraphics;
import com.huntercodexs.hardsys.dto.HardSysMachineDto.HardSysMachine;
import com.huntercodexs.hardsys.dto.HardSysMemoryDto.HardSysMemory;
import com.huntercodexs.hardsys.dto.HardSysNetworkDto.HardSysNetwork;
import com.huntercodexs.hardsys.dto.HardSysPartitionDto.HardSysPartition;
import com.huntercodexs.hardsys.dto.HardSysProcessorDto.HardSysProcessor;
import com.huntercodexs.hardsys.dto.HardSysRunningDto.HardSysRunning;
import com.huntercodexs.hardsys.dto.HardSysSensorsDto.HardSysSensors;
import com.huntercodexs.hardsys.dto.HardSysSlotsDto.HardSysSlots;
import com.huntercodexs.hardsys.dto.HardSysSystemDto.HardSysSystem;
import com.huntercodexs.hardsys.dto.HardSysUsbDto.HardSysUsb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.huntercodexs.hardsys.dependency.HardSysBasicService.*;

public class HardSysInxiFactory extends HardSysBase {

    public HardSysInxiFactory(HashMap<String, List<String>> resources, HashMap<String, Object> transport) {
        this.resources = resources;
        this.transport = transport;
    }

    private List<List<String>> fixFields() {
        List<List<String>> cleanup = new ArrayList<>();

        List<String> toClean1 = new ArrayList<>();
        toClean1.add("bus ID");
        toClean1.add("busId");
        cleanup.add(toClean1);

        List<String> toClean2 = new ArrayList<>();
        toClean2.add("direct render");
        toClean2.add("directRender");
        cleanup.add(toClean2);

        List<String> toClean3 = new ArrayList<>();
        toClean3.add("OpenGL");
        toClean3.add("OpenGL: unknown");
        cleanup.add(toClean3);

        List<String> toClean4 = new ArrayList<>();
        toClean4.add("Sound Server");
        toClean4.add("soundServer");
        cleanup.add(toClean4);
        cleanup.add(toClean3);

        List<String> toClean5 = new ArrayList<>();
        toClean5.add("Local Storage");
        toClean5.add("localStorage");
        cleanup.add(toClean5);

        List<String> toClean6 = new ArrayList<>();
        toClean6.add("Message");
        toClean6.add("message");
        cleanup.add(toClean6);

        List<String> toClean7 = new ArrayList<>();
        toClean7.add("Partition");
        toClean7.add("partition");
        cleanup.add(toClean7);

        List<String> toClean8 = new ArrayList<>();
        toClean8.add("System Temperatures");
        toClean8.add("systemTemp");
        cleanup.add(toClean8);

        List<String> toClean9 = new ArrayList<>();
        toClean9.add("Fan Speeds \\(RPM\\)");
        toClean9.add("fanSpeed");
        cleanup.add(toClean9);

        return cleanup;
    }

    private void systemFactory(List<String> items) {

        HardSysSystemDto systemDto = new HardSysSystemDto();
        systemDto.setQty("1");

        HardSysSystem system = new HardSysSystem();

        system.setName(items.get(0).replaceAll("osName:", "").trim());
        system.setArch(items.get(1).replaceAll("osArch:", "").trim());
        system.setVersion(items.get(2).replaceAll("osVersion:", "").trim());
        system.setFileSeparator(items.get(3).replaceAll("fileSeparator:", "").trim());
        system.setPathSeparator(items.get(4).replaceAll("pathSeparator:", "").trim());
        system.setLineSeparator(items.get(5).replaceAll("lineSeparator:", "").trim());
        system.setUsername(items.get(6).replaceAll("userName:", "").trim());
        system.setHome(items.get(7).replaceAll("userHome:", "").trim());
        system.setUserdir(items.get(8).replaceAll("userDir:", "").trim());
        system.setJavaVersion(items.get(9).replaceAll("javaVersion:", "").trim());
        system.setJavaVendor(items.get(10).replaceAll("javaVendor:", "").trim());
        system.setJavaVendorUrl(items.get(11).replaceAll("javaVendorUrl:", "").trim());
        system.setJavaHome(items.get(12).replaceAll("javaHome:", "").trim());
        system.setJavaSpecVersion(items.get(13).replaceAll("javaSpecVersion:", "").trim());
        system.setJavaSpecVendor(items.get(14).replaceAll("javaSpecVendor:", "").trim());
        system.setJavaSpecName(items.get(15).replaceAll("javaSpecName:", "").trim());
        system.setJavaClassVersion(items.get(16).replaceAll("javaClassVersion:", "").trim());
        system.setJavaClassPath(items.get(17).replaceAll("javaClassPath:", "").trim());
        system.setJavaLibPath(items.get(18).replaceAll("javaLibPath:", "").trim());
        system.setJavaTmpDir(items.get(19).replaceAll("javaTmpDir:", "").trim());
        system.setJavaCompiler(items.get(20).replaceAll("javaCompiler:", "").trim());
        system.setJavaExtDir(items.get(21).replaceAll("javaExtDir:", "").trim());
        system.setJavaVmSpecVersion(items.get(22).replaceAll("javaVmSpecVersion:", "").trim());
        system.setJavaVmSpecVendor(items.get(23).replaceAll("javaVmSpecVendor:", "").trim());
        system.setJavaVmSpecName(items.get(24).replaceAll("javaVmSpecName:", "").trim());
        system.setJavaVmVersion(items.get(25).replaceAll("javaVmVersion:", "").trim());
        system.setJavaVmVendor(items.get(26).replaceAll("javaVmVendor:", "").trim());
        system.setJavaVmName(items.get(27).replaceAll("javaVmName:", "").trim());
        system.setDistro(items.get(28).replaceAll("osDistro:", "").trim());
        system.setDate(items.get(29).replaceAll("osDate:", "").trim());
        system.setVendor(items.get(30).replaceAll("osVendor:", "").trim());
        system.setKernel(items.get(31).replaceAll("osKernel:", "").trim());
        system.setDescription(items.get(32).replaceAll("osDescription:", "").trim());

        systemDto.addSystem(system);

        this.transport.put(hardsysCheck("system"), systemDto);

    }

    private void machineFactory(List<String> items) {

        HardSysMachineDto machineDto = new HardSysMachineDto();
        machineDto.setQty("1");

        HardSysMachine machine = new HardSysMachine();

        machine.setType(alphaFieldPattern(items.get(0), "Type", null));
        machine.setName(alphaFieldPattern(items.get(0), "System", null));
        machine.setProduct(alphaFieldPattern(items.get(0), "product", " "));
        machine.setVersion(alphaFieldPattern(items.get(0), "v", null));
        machine.setSerial(alphaFieldPattern(items.get(0), "serial", "><"));

        machine.setVendor(stringExtractor(
                items.get(0).toUpperCase(),
                "",
                vendorsPattern,
                "$1",
                1));

        machine.setFamily(stringExtractor(
                items.get(0).toUpperCase(),
                "",
                productFamilyPattern,
                "$1",
                1));

        machine.setMobo(alphaFieldPattern(items.get(0), "Mobo", null));
        machine.setModel(alphaFieldPattern(items.get(0), "model", null));
        machine.setUefi(alphaFieldPattern(items.get(0), "UEFI", null));

        machine.setDate(alphaFieldPattern(items.get(0), "date", "/"));

        machine.setDescription(machine.getType()+" "+machine.getName()+" "+machine.getProduct());

        machineDto.addMachine(machine);

        this.transport.put(hardsysCheck("machine"), machineDto);

    }

    private void batteryFactory(List<String> items) {

        HardSysBatteryDto batteryDto = new HardSysBatteryDto();
        batteryDto.setQty("1");

        HardSysBattery battery = new HardSysBattery();

        battery.setId(alphaFieldPattern(items.get(0), "ID-1", null));
        battery.setCharge(alphaFieldPattern(items.get(0), "charge", " "));
        battery.setCondition(alphaFieldPattern(items.get(0), "condition", "/"));
        battery.setName(alphaFieldPattern(items.get(0), "model", " "));
        battery.setType(alphaFieldPattern(items.get(0), "model", " "));
        battery.setStatus(alphaFieldPattern(items.get(0), "status", null));

        batteryDto.addBattery(battery);

        this.transport.put(hardsysCheck("battery"), batteryDto);
    }

    private void memoryFactory(List<String> items) {

        HardSysMemoryDto memoryDto = new HardSysMemoryDto();
        memoryDto.setQty("unknown");

        HardSysMemory memory = new HardSysMemory();

        memory.setTotal(alphaFieldPattern(items.get(0), "total", " "));
        memory.setUsed(alphaFieldPattern(items.get(0), "used", " "));
        memory.setDescription(alphaFieldPattern(items.get(0), "permissions", " "));
        memory.setType("RAM");

        memoryDto.addMemory(memory);

        this.transport.put(hardsysCheck("memory"), memoryDto);

    }

    private void slotsFactory(List<String> items) {

        HardSysSlotsDto slotsDto = new HardSysSlotsDto();
        slotsDto.setQty("unknown");

        HardSysSlots slots = new HardSysSlots();

        slots.setDescription(alphaFieldPattern(items.get(0), "Permissions", " "));

        slotsDto.addSlot(slots);

        this.transport.put(hardsysCheck("slots"), slotsDto);
    }

    private void processorFactory(List<String> items) {

        HardSysProcessorDto processorDto = new HardSysProcessorDto();
        processorDto.setCores(String.valueOf(stringCounter(items.get(0), "[1-9]: ([0-9]{3,4})")));
        processorDto.setName(alphaFieldPattern(items.get(0), "model", " "));

        HardSysProcessor processor = new HardSysProcessor();

        processor.setTopology(alphaFieldPattern(items.get(0), "Topology", " "));
        processor.setModel(alphaFieldPattern(items.get(0), "model", " "));
        processor.setBits(alphaFieldPattern(items.get(0), "bits", null));
        processor.setType(alphaFieldPattern(items.get(0), "type", " "));
        processor.setArch(alphaFieldPattern(items.get(0), "arch", " "));
        processor.setCache(alphaFieldPattern(items.get(0), "cache", " "));
        processor.setFlags(alphaFieldPattern(items.get(0), "flags", " "));
        processor.setBogomips(alphaFieldPattern(items.get(0), "bogomips", " "));
        processor.setSpeed(alphaFieldPattern(items.get(0), "Speed", " "));

        processor.setMinSpeed(
                alphaFieldPattern(
                        items.get(0), "min/max", " ")
                        .replaceAll("Core speeds", ""));

        processor.setMaxSpeed(
                alphaFieldPattern(
                        items.get(0), "min/max", " ")
                        .replaceAll("Core speeds", ""));

        processor.setCharacteristics(
                "Core Speeds - "+stringExtractor(
                items.get(0).toUpperCase(),
                "",
                "([1-9]: [0-9]{3,4} [1-9]: [0-9]{3,4} [1-9]: [0-9]{3,4} [1-9]: [0-9]{3,4} [1-9]: [0-9]{3,4} [1-9]: [0-9]{3,4} [1-9]: [0-9]{3,4} [1-9]: [0-9]{3,4})",
                "$1",
                1).replaceAll(" ", ": "));

        processor.setFamily(stringExtractor(
                items.get(0).toUpperCase(),
                "",
                processorFamilyPattern,
                "$1",
                1));

        processorDto.addProcessor(processor);

        this.transport.put(hardsysCheck("processor"), processorDto);


    }

    private void graphicsFactory(List<String> items) {

        List<String> listFixed = listNormalize(items, "Device-", fixFields());

        HardSysGraphicsDto graphicsDto = new HardSysGraphicsDto();
        graphicsDto.setQty(String.valueOf(listFixed.size()));

        int index = 1;
        for (String item : listFixed) {
            HardSysGraphics graphics = new HardSysGraphics();

            graphics.setName(alphaFieldPattern(item, "Device-"+index, " "));
            graphics.setVendor(alphaFieldPattern(item, "vendor", " "));
            graphics.setDriver(alphaFieldPattern(item, "driver", ""));
            graphics.setVersion(alphaFieldPattern(item, "v", ""));
            graphics.setId(alphaFieldPattern(item, "busId", ":"));
            graphics.setDisplay(alphaFieldPattern(item, "Display", " "));
            graphics.setServer(alphaFieldPattern(item, "server", " "));
            graphics.setFailed(alphaFieldPattern(item, "FAILED", " "));
            graphics.setUnloaded(alphaFieldPattern(item, "unloaded", ","));
            graphics.setResolution(alphaFieldPattern(item, "resolution", ",~ "));
            graphics.setRenderer(alphaFieldPattern(item, "renderer", " "));

            graphicsDto.addGraphic(graphics);
            index += 1;
        }

        this.transport.put(hardsysCheck("graphics"), graphicsDto);

    }

    private void audioFactory(List<String> items) {

        List<String> listFixed = listNormalize(items, "Device-", fixFields());

        HardSysAudioDto audioDto = new HardSysAudioDto();
        audioDto.setQty(String.valueOf(listFixed.size()));

        int index = 1;
        for (String item : listFixed) {
            HardSysAudio audio = new HardSysAudio();

            audio.setName(alphaFieldPattern(item, "Device-"+index, " "));
            audio.setVendor(alphaFieldPattern(item, "vendor", " "));
            audio.setDriver(alphaFieldPattern(item, "driver", ""));
            audio.setVersion(alphaFieldPattern(item, "v", ""));
            audio.setId(alphaFieldPattern(item, "busId", ":"));
            audio.setSource(alphaFieldPattern(item, "soundServer", " "));

            audioDto.addAudio(audio);
            index += 1;
        }

        this.transport.put(hardsysCheck("audio"), audioDto);

    }

    private void networkFactory(List<String> items) {

        List<String> listFixed = listNormalize(items, "Device-|IF-ID-", fixFields());

        HardSysNetworkDto networkDto = new HardSysNetworkDto();
        networkDto.setQty(String.valueOf(listFixed.size()));

        int index = 1;
        boolean deviceChanged = false;

        for (String item : listFixed) {

            HardSysNetwork network = new HardSysNetwork();

            /*
             * Reset index device: In this case when there is more one type of devices identification,
             * for example:
             *      Device-1:
             *      Device-2:
             *      Device-3:
             *      IF-ID-1:
             *      IF-ID-2:
             *      Dev-1:
             *      Dev-2:
             * we need to restart the index to get the correctly index from each kind of device, however,
             * if occurs the follow flow
             *      Device-1:
             *      Device-2:
             *      IF-ID-1:
             *      IF-ID-2:
             *      Device-3:
             *      Device-4:
             *      ...
             * it will become a problem because the index of original/start device was lost and we can not
             * follow in this way, so pay attention in that issue.
             *
             * Put here the conditions to reset the index of each device.
            */
            if (item.contains("IF-ID-") || !deviceChanged) {
                index = 1;
                deviceChanged = true;
            }

            network.setName(alphaFieldPattern(item, "Device-"+index, " "));
            network.setSource(alphaFieldPattern(item, "IF|IF\\-ID\\-"+index, ""));

            network.setType(stringExtractor(
                    item.toUpperCase(),
                    "",
                    networkTypePattern,
                    "$1",
                    index));

            network.setVendor(alphaFieldPattern(item, "vendor", " "));
            network.setDriver(alphaFieldPattern(item, "driver", ""));
            network.setVersion(alphaFieldPattern(item, "v", ""));
            network.setId(alphaFieldPattern(item, "busId", ":"));
            network.setPorts(alphaFieldPattern(item, "ports", ""));
            network.setStatus(alphaFieldPattern(item, "state", ""));
            network.setSpeed(alphaFieldPattern(item, "speed", " "));
            network.setMac(alphaFieldPattern(item, "mac", "><"));

            networkDto.addNetwork(network);
            index += 1;
        }

        this.transport.put(hardsysCheck("network"), networkDto);

    }

    private void drivesFactory(List<String> items) {

        List<String> listFixed = listNormalize(items, "localStorage|message", fixFields());

        HardSysDrivesDto drivesDto = new HardSysDrivesDto();
        drivesDto.setQty(String.valueOf(listFixed.size()));

        int index = 1;
        boolean deviceChanged = false;

        for (String item : listFixed) {

            HardSysDrives drives = new HardSysDrives();

            if (item.contains("localStorage") || item.contains("message") || !deviceChanged) {
                index = 1;
                deviceChanged = true;
            }

            drives.setName(alphaFieldPattern(item, "model", " "));
            drives.setSize(alphaFieldPattern(item, "size", " "));
            drives.setUsed(alphaFieldPattern(item, "used", " "));
            drives.setVendor(alphaFieldPattern(item, "vendor", " "));
            drives.setSource(alphaFieldPattern(item, "ID\\-"+index, ""));
            drives.setDescription(alphaFieldPattern(item, "message", " \\."));

            drives.setType(stringExtractor(
                    item.toUpperCase(),
                    "",
                    drivesTypePattern,
                    "$1",
                    index));

            drivesDto.addDisk(drives);
            index += 1;
        }

        this.transport.put(hardsysCheck("drives"), drivesDto);

    }

    private void partitionFactory(List<String> items) {

        List<String> listFixed = listNormalize(items, "Partition", fixFields());

        HardSysPartitionDto partitionDto = new HardSysPartitionDto();
        partitionDto.setQty(String.valueOf(listFixed.size()));

        int index = 1;
        boolean deviceChanged = false;

        for (String item : listFixed) {

            HardSysPartition partition = new HardSysPartition();

            if (item.contains("ID-") || !deviceChanged) {
                index = 1;
                deviceChanged = true;
            }

            partition.setSource(alphaFieldPattern(item, "ID\\-"+index, ""));
            partition.setSize(alphaFieldPattern(item, "size", " "));
            partition.setUsed(alphaFieldPattern(item, "used", " "));
            partition.setType(alphaFieldPattern(item, "fs", null));
            partition.setDev(alphaFieldPattern(item, "dev", null));

            partitionDto.addPartition(partition);
            index += 1;
        }

        this.transport.put(hardsysCheck("partition"), partitionDto);

    }

    private void usbFactory(List<String> items) {

        List<String> listFixed = listNormalize(items, "Hub|Device-", fixFields());

        HardSysUsbDto usbDto = new HardSysUsbDto();
        usbDto.setQty(String.valueOf(listFixed.size()));

        int index = 1;

        for (String item : listFixed) {

            HardSysUsb usb = new HardSysUsb();

            usb.setId(alphaFieldPattern(item, "Hub|Device-"+index, "-:"));
            usb.setName(alphaFieldPattern(item, "info", " /"));
            usb.setSource(alphaFieldPattern(item, "Hub|Device-"+index, "-:"));
            usb.setDescription(alphaFieldPattern(item, "info", " /"));
            usb.setVersion(alphaFieldPattern(item, "rev", "."));
            usb.setDriver(alphaFieldPattern(item, "driver", ","));
            usb.setPorts(alphaFieldPattern(item, "ports", ""));
            usb.setType(alphaFieldPattern(item, "type", ","));

            usb.setVendor(stringExtractor(
                    item.toUpperCase(), "", vendorsPattern, "$1", index));

            usbDto.addUsb(usb);

            if (item.contains("Device-")) {
                index += 1;
            }

        }

        this.transport.put(hardsysCheck("usb"), usbDto);

    }

    private void sensorsFactory(List<String> items) {

        List<String> listFixed = listNormalize(items, "systemTemp|fanSpeed", fixFields());

        HardSysSensorsDto sensorsDto = new HardSysSensorsDto();
        sensorsDto.setQty(String.valueOf(listFixed.size()));

        for (String item : listFixed) {

            HardSysSensors sensors = new HardSysSensors();

            sensors.setName(alphaFieldPattern(item, "model", " "));
            sensors.setMobo(alphaFieldPattern(item, "mobo", " "));
            sensors.setTemperature(alphaFieldPattern(item, "cpu", " "));
            sensors.setDescription(item.split(":")[0]);

            sensors.setType(stringExtractor(
                    item.toUpperCase(),
                    "",
                    sensorsTypePattern,
                    "$1",
                    1));

            sensorsDto.addSensor(sensors);

        }

        this.transport.put(hardsysCheck("sensors"), sensorsDto);

    }

    private void runningFactory(List<String> items) {

        List<String> listFixed = listNormalize(items, "Partition", fixFields());

        HardSysRunningDto runningDto = new HardSysRunningDto();

        for (String item : listFixed) {

            HardSysRunning running = new HardSysRunning();

            running.setProcesses(alphaFieldPattern(item, "Processes", null));
            running.setUptime(alphaFieldPattern(item, "Uptime", " "));
            running.setInit(alphaFieldPattern(item, "Init", null));
            running.setRunlevel(alphaFieldPattern(item, "runlevel", null));
            running.setCompilers(alphaFieldPattern(item, "Compilers", null));
            running.setGcc(alphaFieldPattern(item, "gcc", null));
            running.setShell(alphaFieldPattern(item, "Shell", null));
            running.setClient(alphaFieldPattern(item, "Client", null));
            running.setVersion(alphaFieldPattern(item, "v", null));
            running.setInxi(alphaFieldPattern(item, "inxi", null));

            runningDto.addRunning(running);
        }

        this.transport.put(hardsysCheck("running"), runningDto);

    }

    private void printerFactory(List<String> items) {}

    /**
     * @implNote This method will convert the resources from a List object to a DTO object
     * to be used easier and understandably during the processing commute
     * */
    public void factory() {
        List<String> removeList = new ArrayList<>();

        this.resources.forEach((key, list) -> {

            List<String> makeList = new ArrayList<>();

            if (key.contains("Group") || key.contains("all")) {
                removeList.add(key);
            } else {

                for (String item : list) {
                    if (item.isEmpty()) continue;

                    String value = item
                            .replaceAll("\\[", "(")
                            .replaceAll("]", ")")
                            .replaceAll("-{2,}", " description: ");

                    makeList.add(value);
                    this.resources.put(key, makeList);

                }

            }

        });

        for (String remove : removeList) {
            this.resources.remove(remove);
        }

        systemFactory(this.resources.get(hardsysCheck("system")));
        machineFactory(this.resources.get(hardsysCheck("machine")));
        batteryFactory(this.resources.get(hardsysCheck("battery")));
        memoryFactory(this.resources.get(hardsysCheck("memory")));
        slotsFactory(this.resources.get(hardsysCheck("slots")));
        processorFactory(this.resources.get(hardsysCheck("processor")));
        graphicsFactory(this.resources.get(hardsysCheck("graphics")));
        audioFactory(this.resources.get(hardsysCheck("audio")));
        networkFactory(this.resources.get(hardsysCheck("network")));
        drivesFactory(this.resources.get(hardsysCheck("drives")));
        partitionFactory(this.resources.get(hardsysCheck("partition")));
        usbFactory(this.resources.get(hardsysCheck("usb")));
        sensorsFactory(this.resources.get(hardsysCheck("sensors")));
        runningFactory(this.resources.get(hardsysCheck("running")));
        printerFactory(this.resources.get(hardsysCheck("printer")));

    }

}
