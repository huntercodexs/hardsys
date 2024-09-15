package com.huntercodexs.hardsys.core;

import com.huntercodexs.hardsys.command.HardSysCommands;
import com.huntercodexs.hardsys.dto.HardSysResourcesDto;
import com.huntercodexs.hardsys.group.*;
import com.huntercodexs.hardsys.processing.*;

import java.util.HashMap;
import java.util.List;

public class HardSysResources extends HardSysBase implements HardSysInterface {

    private boolean jsonOn = false;
    private HardSysSystemDetails systemDetails;
    private HardSysMachineDetails machineDetails;
    private HardSysBatteryDetails batteryDetails;
    private HardSysMemoryDetails memoryDetails;
    private HardSysSlotsDetails slotsDetails;
    private HardSysProcessorDetails processorDetails;
    private HardSysGraphicsDetails graphicsDetails;
    private HardSysAudioDetails audioDetails;
    private HardSysNetworkDetails networkDetails;
    private HardSysDriversDetails driversDetails;
    private HardSysPartitionDetails partitionDetails;
    private HardSysCdRomDetails cdRomDetails;
    private HardSysUsbDetails usbDetails;
    private HardSysSensorsDetails sensorsDetails;
    private HardSysRunningDetails runningDetails;
    private HardSysMonitorDetails monitorDetails;
    private HardSysBiosDetails biosDetails;
    private HardSysBaseboardDetails baseboardDetails;
    private HardSysControllerDetails controllerDetails;
    private HardSysChassisDetails chassisDetails;
    private HardSysCacheDetails cacheDetails;
    private HardSysConnectorDetails connectorDetails;
    private HardSysKeyboardDetails keyboardDetails;
    private HardSysMouseDetails mouseDetails;
    private HardSysHubDetails hubDetails;
    private HardSysSwitchDetails switchDetails;
    private HardSysModemDetails modemDetails;
    private HardSysDiskDetails diskDetails;
    private HardSysDrivesDetails drivesDetails;
    private HardSysBluetoothDetails bluetoothDetails;
    private HardSysVideoDetails videoDetails;
    private HardSysStorageDetails storageDetails;
    private HardSysBridgeDetails bridgeDetails;
    private HardSysNicInterfaceDetails nicInterfaceDetails;
    private HardSysUnknownDetails unknownDetails;
    private HardSysMultimediaDetails multimediaDetails;
    private HardSysPrinterDetails printerDetails;
    private HardSysDevicesGroupDetails devicesGroupDetails;
    private HardSysNetworkGroupDetails networksGroupDetails;
    private HardSysDrivesGroupDetails drivesGroupDetails;
    private HardSysComponentsGroupDetails componentsGroupDetails;
    private HardSysBoardsGroupDetails boardsGroupDetails;
    private HardSysHardwareGroupDetails hardwareGroupDetails;
    private HardSysAllGroupDetails allGroupDetails;

    /**
     * @implNote Use for JSON cases
     * */
    public HardSysResources(
            HardSysCommands command,
            HashMap<String, List<String>> resources
    ) {
        this.jsonOn = true;
        this.command = command;
        this.resources = resources;
        this.jsonBuilder();
    }

    /**
     * @implNote Use for DTO cases
     * */
    public HardSysResources(
            HashMap<String, Object> transport,
            HardSysCommands command
    ) {
        this.jsonOn = false;
        this.command = command;
        this.transport = transport;
    }

    private void jsonBuilder() {
        //See the HARDSYS to get more details
        this.systemDetails = new HardSysSystemDetails(this.resources.get(hardsysCheck("system")), this.command);
        this.machineDetails = new HardSysMachineDetails(this.resources.get(hardsysCheck("machine")), this.command);
        this.batteryDetails = new HardSysBatteryDetails(this.resources.get(hardsysCheck("battery")), this.command);
        this.memoryDetails = new HardSysMemoryDetails(this.resources.get(hardsysCheck("memory")), this.command);
        this.slotsDetails = new HardSysSlotsDetails(this.resources.get(hardsysCheck("slots")), this.command);
        this.processorDetails = new HardSysProcessorDetails(this.resources.get(hardsysCheck("processor")), this.command);
        this.graphicsDetails = new HardSysGraphicsDetails(this.resources.get(hardsysCheck("graphics")), this.command);
        this.audioDetails = new HardSysAudioDetails(this.resources.get(hardsysCheck("audio")), this.command);
        this.networkDetails = new HardSysNetworkDetails(this.resources.get(hardsysCheck("network")), this.command);
        this.driversDetails = new HardSysDriversDetails(this.resources.get(hardsysCheck("drivers")), this.command);
        this.partitionDetails = new HardSysPartitionDetails(this.resources.get(hardsysCheck("partition")), this.command);
        this.cdRomDetails = new HardSysCdRomDetails(this.resources.get(hardsysCheck("cdrom")), this.command);
        this.usbDetails = new HardSysUsbDetails(this.resources.get(hardsysCheck("usb")), this.command);
        this.sensorsDetails = new HardSysSensorsDetails(this.resources.get(hardsysCheck("sensors")), this.command);
        this.runningDetails = new HardSysRunningDetails(this.resources.get(hardsysCheck("running")), this.command);
        this.monitorDetails = new HardSysMonitorDetails(this.resources.get(hardsysCheck("monitor")), this.command);
        this.biosDetails = new HardSysBiosDetails(this.resources.get(hardsysCheck("bios")), this.command);
        this.baseboardDetails = new HardSysBaseboardDetails(this.resources.get(hardsysCheck("baseboard")), this.command);
        this.controllerDetails = new HardSysControllerDetails(this.resources.get(hardsysCheck("controller")), this.command);
        this.chassisDetails = new HardSysChassisDetails(this.resources.get(hardsysCheck("chassis")), this.command);
        this.cacheDetails = new HardSysCacheDetails(this.resources.get(hardsysCheck("cache")), this.command);
        this.connectorDetails = new HardSysConnectorDetails(this.resources.get(hardsysCheck("connector")), this.command);
        this.keyboardDetails = new HardSysKeyboardDetails(this.resources.get(hardsysCheck("keyboard")), this.command);
        this.mouseDetails = new HardSysMouseDetails(this.resources.get(hardsysCheck("mouse")), this.command);
        this.hubDetails = new HardSysHubDetails(this.resources.get(hardsysCheck("hub")), this.command);
        this.switchDetails = new HardSysSwitchDetails(this.resources.get(hardsysCheck("switcher")), this.command);
        this.modemDetails = new HardSysModemDetails(this.resources.get(hardsysCheck("modem")), this.command);
        this.diskDetails = new HardSysDiskDetails(this.resources.get(hardsysCheck("disk")), this.command);
        this.drivesDetails = new HardSysDrivesDetails(this.resources.get(hardsysCheck("drives")), this.command);
        this.bluetoothDetails = new HardSysBluetoothDetails(this.resources.get(hardsysCheck("bluetooth")), this.command);
        this.videoDetails = new HardSysVideoDetails(this.resources.get(hardsysCheck("video")), this.command);
        this.storageDetails = new HardSysStorageDetails(this.resources.get(hardsysCheck("storage")), this.command);
        this.bridgeDetails = new HardSysBridgeDetails(this.resources.get(hardsysCheck("bridge")), this.command);
        this.nicInterfaceDetails = new HardSysNicInterfaceDetails(this.resources.get(hardsysCheck("nicInterface")), this.command);
        this.unknownDetails = new HardSysUnknownDetails(this.resources.get(hardsysCheck("unknown")), this.command);
        this.multimediaDetails = new HardSysMultimediaDetails(this.resources.get(hardsysCheck("multimedia")), this.command);
        this.printerDetails = new HardSysPrinterDetails(this.resources.get(hardsysCheck("printer")), this.command);
        this.devicesGroupDetails = new HardSysDevicesGroupDetails(this.resources.get(hardsysCheck("devicesGroup")), this.command);
        this.networksGroupDetails = new HardSysNetworkGroupDetails(this.resources.get(hardsysCheck("networksGroup")), this.command);
        this.drivesGroupDetails = new HardSysDrivesGroupDetails(this.resources.get(hardsysCheck("drivesGroup")), this.command);
        this.componentsGroupDetails = new HardSysComponentsGroupDetails(this.resources.get(hardsysCheck("componentsGroup")), this.command);
        this.boardsGroupDetails = new HardSysBoardsGroupDetails(this.resources.get(hardsysCheck("boardsGroup")), this.command);
        this.hardwareGroupDetails = new HardSysHardwareGroupDetails(this.resources.get(hardsysCheck("hardwareGroup")), this.command);
        this.allGroupDetails = new HardSysAllGroupDetails(this, this.command);
    }

    private void checkJsonState() {
        if (!this.jsonOn) {
            throw new RuntimeException("Invalid Operation, please use jsonOn = true");
        }
    }

    public HardSysSystemDetails getSystem() {
        checkJsonState();
        return systemDetails;
    }

    public HardSysMachineDetails getMachine() {
        checkJsonState();
        return machineDetails;
    }

    public HardSysBatteryDetails getBattery() {
        checkJsonState();
        return batteryDetails;
    }

    public HardSysMemoryDetails getMemory() {
        checkJsonState();
        return memoryDetails;
    }

    public HardSysSlotsDetails getSlots() {
        checkJsonState();
        return slotsDetails;
    }

    public HardSysProcessorDetails getProcessor() {
        checkJsonState();
        return processorDetails;
    }

    public HardSysGraphicsDetails getGraphics() {
        checkJsonState();
        return graphicsDetails;
    }

    public HardSysAudioDetails getAudio() {
        checkJsonState();
        return audioDetails;
    }

    public HardSysNetworkDetails getNetwork() {
        checkJsonState();
        return networkDetails;
    }

    public HardSysDriversDetails getDrivers() {
        checkJsonState();
        return driversDetails;
    }

    public HardSysPartitionDetails getPartition() {
        checkJsonState();
        return partitionDetails;
    }

    public HardSysCdRomDetails getCdRom() {
        checkJsonState();
        return cdRomDetails;
    }

    public HardSysUsbDetails getUsb() {
        checkJsonState();
        return usbDetails;
    }

    public HardSysSensorsDetails getSensors() {
        checkJsonState();
        return sensorsDetails;
    }

    public HardSysRunningDetails getRunning() {
        checkJsonState();
        return runningDetails;
    }

    public HardSysMonitorDetails getMonitor() {
        checkJsonState();
        return monitorDetails;
    }

    public HardSysBiosDetails getBios() {
        checkJsonState();
        return biosDetails;
    }

    public HardSysBaseboardDetails getBaseboard() {
        checkJsonState();
        return baseboardDetails;
    }

    public HardSysControllerDetails getController() {
        checkJsonState();
        return controllerDetails;
    }

    public HardSysChassisDetails getChassis() {
        checkJsonState();
        return chassisDetails;
    }

    public HardSysCacheDetails getCache() {
        checkJsonState();
        return cacheDetails;
    }

    public HardSysConnectorDetails getConnector() {
        checkJsonState();
        return connectorDetails;
    }

    public HardSysKeyboardDetails getKeyboard() {
        checkJsonState();
        return keyboardDetails;
    }

    public HardSysMouseDetails getMouse() {
        checkJsonState();
        return mouseDetails;
    }

    public HardSysHubDetails getHub() {
        checkJsonState();
        return hubDetails;
    }

    public HardSysSwitchDetails getSwitch() {
        checkJsonState();
        return switchDetails;
    }

    public HardSysModemDetails getModem() {
        checkJsonState();
        return modemDetails;
    }

    public HardSysDiskDetails getDisk() {
        checkJsonState();
        return diskDetails;
    }

    public HardSysDrivesDetails getDrives() {
        checkJsonState();
        return drivesDetails;
    }

    public HardSysBluetoothDetails getBluetooth() {
        checkJsonState();
        return bluetoothDetails;
    }

    public HardSysVideoDetails getVideo() {
        checkJsonState();
        return videoDetails;
    }

    public HardSysStorageDetails getStorage() {
        checkJsonState();
        return storageDetails;
    }

    public HardSysBridgeDetails getBridge() {
        checkJsonState();
        return bridgeDetails;
    }

    public HardSysNicInterfaceDetails getNicInterface() {
        checkJsonState();
        return nicInterfaceDetails;
    }

    public HardSysUnknownDetails getUnknown() {
        checkJsonState();
        return unknownDetails;
    }

    public HardSysMultimediaDetails getMultimedia() {
        checkJsonState();
        return multimediaDetails;
    }

    public HardSysPrinterDetails getPrinter() {
        checkJsonState();
        return printerDetails;
    }

    public HardSysDevicesGroupDetails getDevicesGroup() {
        checkJsonState();
        return devicesGroupDetails;
    }

    public HardSysNetworkGroupDetails getNetworksGroup() {
        checkJsonState();
        return networksGroupDetails;
    }

    public HardSysDrivesGroupDetails getDrivesGroup() {
        checkJsonState();
        return this.drivesGroupDetails;
    }

    public HardSysComponentsGroupDetails getComponentsGroup() {
        checkJsonState();
        return this.componentsGroupDetails;
    }

    public HardSysBoardsGroupDetails getBoardsGroup() {
        checkJsonState();
        return this.boardsGroupDetails;
    }

    public HardSysHardwareGroupDetails getHardwareGroup() {
        checkJsonState();
        return this.hardwareGroupDetails;
    }

    /**
     * <h6 style="color: #FFFF00; font-size: 11px">all</h6>
     *
     * <p style="color: #CDCDCD">Get all data from linux command in JSON Format</p>
     *
     * <p>
     *     To active the JSON Format output you need to set the jsonOn as follow:<br />
     *     <pre>
     *         HardSys hardSys = new HardSys({HardSysCommands});
     *         hardSys.json();
     *         hardSys.resources().getAll();
     *     </pre>
     * </p>
     *
     * @return String (JSON Format)
     * @see <a href="https://github.com/huntercodexs/hardsys">HardSys (GitHub)</a>
     * @author huntercodexs (powered by jereelton-devel)
     * */
    public String all() {
        checkJsonState();
        return this.allGroupDetails.getDetails();
    }

    /**
     * <h6 style="color: #FFFF00; font-size: 11px">builder</h6>
     *
     * <p style="color: #CDCDCD">Get all data from linux command in DTO Format</p>
     *
     * <p>
     *     Usage:<br />
     *     <pre>
     *         HardSys hardSys = new HardSys({HardSysCommands});
     *         HardSysMetricsDto result = hardSys.resources().builder();
     *         System.out.println(result);
     *     </pre>
     * </p>
     *
     * @return HardSysMetricsDto (DTO Format)
     * @see <a href="https://github.com/huntercodexs/hardsys">HardSys (GitHub)</a>
     * @author huntercodexs (powered by jereelton-devel)
     * */
    public HardSysResourcesDto builder() {
        if (this.jsonOn) {
            throw new RuntimeException("Invalid Operation, please use jsonOn = false");
        }
        return new HardSysBuilder(this.transport).build();
    }

    /**
     * TODO
     * <h6 style="color: #FFFF00; font-size: 11px">nonNull</h6>
     *
     * <p style="color: #CDCDCD">Get all data from linux command in DTO Format ignoring null values</p>
     *
     * <p>
     *     Usage:<br />
     *     <pre>
     *         HardSys hardSys = new HardSys({HardSysCommands});
     *         HardSysResourcesDto nonNull = hardSys.resources().nonNull();
     *         System.out.println(result);
     *     </pre>
     * </p>
     *
     * @return HardSysMetricsDto (DTO Format)
     * @see <a href="https://github.com/huntercodexs/hardsys">HardSys (GitHub)</a>
     * @author huntercodexs (powered by jereelton-devel)
     * */
    public HardSysResourcesDto nonNull() {
        if (this.jsonOn) {
            throw new RuntimeException("Invalid Operation, please use jsonOn = false");
        }
        return new HardSysBuilder(this.transport).buildNonNull();
    }

}
