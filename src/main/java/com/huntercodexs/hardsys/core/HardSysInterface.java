package com.huntercodexs.hardsys.core;

import com.huntercodexs.hardsys.group.*;
import com.huntercodexs.hardsys.processing.*;

public interface HardSysInterface {
    /*Single*/
    HardSysSystemDetails getSystem();
    HardSysMachineDetails getMachine();
    HardSysBatteryDetails getBattery();
    HardSysMemoryDetails getMemory();
    HardSysSlotsDetails getSlots();
    HardSysProcessorDetails getProcessor();
    HardSysGraphicsDetails getGraphics();
    HardSysAudioDetails getAudio();
    HardSysNetworkDetails getNetwork();
    HardSysDriversDetails getDrivers();
    HardSysPartitionDetails getPartition();
    HardSysCdRomDetails getCdRom();
    HardSysUsbDetails getUsb();
    HardSysSensorsDetails getSensors();
    HardSysRunningDetails getRunning();
    HardSysMonitorDetails getMonitor();
    HardSysBiosDetails getBios();
    HardSysBaseboardDetails getBaseboard();
    HardSysControllerDetails getController();
    HardSysChassisDetails getChassis();
    HardSysCacheDetails getCache();
    HardSysConnectorDetails getConnector();
    HardSysKeyboardDetails getKeyboard();
    HardSysMouseDetails getMouse();
    HardSysHubDetails getHub();
    HardSysSwitchDetails getSwitch();
    HardSysModemDetails getModem();
    HardSysDiskDetails getDisk();
    HardSysBluetoothDetails getBluetooth();
    HardSysVideoDetails getVideo();
    HardSysStorageDetails getStorage();
    HardSysBridgeDetails getBridge();
    HardSysNicInterfaceDetails getNicInterface();
    HardSysUnknownDetails getUnknown();
    HardSysMultimediaDetails getMultimedia();
    HardSysPrinterDetails getPrinter();
    /*Groups*/
    HardSysDevicesGroupDetails getDevicesGroup();
    HardSysNetworkGroupDetails getNetworksGroup();
    HardSysDrivesGroupDetails getDrivesGroup();
    HardSysComponentsGroupDetails getComponentsGroup();
    HardSysBoardsGroupDetails getBoardsGroup();
    HardSysHardwareGroupDetails getHardwareGroup();
    /*All Resources - JSON Format*/
    String all();
}
