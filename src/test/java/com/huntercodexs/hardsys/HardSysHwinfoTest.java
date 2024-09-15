package com.huntercodexs.hardsys;

import com.huntercodexs.hardsys.core.HardSys;
import com.huntercodexs.hardsys.dto.HardSysResourcesDto;
import com.huntercodexs.hardsys.group.*;
import com.huntercodexs.hardsys.processing.*;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static com.huntercodexs.hardsys.command.HardSysCommands.HWINFO;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class HardSysHwinfoTest {

    @Test
    public void generalSystemInfoByHwinfoCommand_SINGLE_Test() {

        HardSys hardSys = new HardSys(HWINFO);
        hardSys.json();

        //SYSTEM
        HardSysSystemDetails system = hardSys.resources().getSystem();
        System.out.println(system.getDetails());
        //--MACHINE
        HardSysMachineDetails machine = hardSys.resources().getMachine();
        System.out.println(machine.getDetails());
        //--BATTERY
        HardSysBatteryDetails battery = hardSys.resources().getBattery();
        System.out.println(battery.getDetails());
        //--MEMORY
        HardSysMemoryDetails memory = hardSys.resources().getMemory();
        System.out.println(memory.getDetails());
        //--SLOTS
        HardSysSlotsDetails slots = hardSys.resources().getSlots();
        System.out.println(slots.getDetails());
        //--PROCESSOR
        HardSysProcessorDetails processor = hardSys.resources().getProcessor();
        System.out.println(processor.getDetails());
        //--GRAPHICS
        HardSysGraphicsDetails graphics = hardSys.resources().getGraphics();
        System.out.println(graphics.getDetails());
        //--AUDIO
        HardSysAudioDetails audio = hardSys.resources().getAudio();
        System.out.println(audio.getDetails());
        //--NETWORK
        HardSysNetworkDetails network = hardSys.resources().getNetwork();
        System.out.println(network.getDetails());
        //--DRIVERS
        HardSysDriversDetails drivers = hardSys.resources().getDrivers();
        System.out.println(drivers.getDetails());
        //--PARTITION
        HardSysPartitionDetails partition = hardSys.resources().getPartition();
        System.out.println(partition.getDetails());
        //--USB
        HardSysUsbDetails usb = hardSys.resources().getUsb();
        System.out.println(usb.getDetails());
        //--SENSORS
        HardSysSensorsDetails sensors = hardSys.resources().getSensors();
        System.out.println(sensors.getDetails());
        //--RUNNING
        HardSysRunningDetails running = hardSys.resources().getRunning();
        System.out.println(running.getDetails());
        //--MONITOR
        HardSysMonitorDetails monitor = hardSys.resources().getMonitor();
        System.out.println(monitor.getDetails());
        //--BIOS
        HardSysBiosDetails bios = hardSys.resources().getBios();
        System.out.println(bios.getDetails());
        //--BASEBOARD
        HardSysBaseboardDetails baseboard = hardSys.resources().getBaseboard();
        System.out.println(baseboard.getDetails());
        //--CHASSIS
        HardSysChassisDetails chassis = hardSys.resources().getChassis();
        System.out.println(chassis.getDetails());
        //--CACHE
        HardSysCacheDetails cache = hardSys.resources().getCache();
        System.out.println(cache.getDetails());
        //--CONNECTOR
        HardSysConnectorDetails connector = hardSys.resources().getConnector();
        System.out.println(connector.getDetails());
        //--KEYBOARD
        HardSysKeyboardDetails keyboard = hardSys.resources().getKeyboard();
        System.out.println(keyboard.getDetails());
        //--MOUSE
        HardSysMouseDetails mouse = hardSys.resources().getMouse();
        System.out.println(mouse.getDetails());
        //--HUB
        HardSysHubDetails hub = hardSys.resources().getHub();
        System.out.println(hub.getDetails());
        //--SWITCH
        HardSysSwitchDetails switcher = hardSys.resources().getSwitch();
        System.out.println(switcher.getDetails());
        //--MODEM
        HardSysModemDetails modem = hardSys.resources().getModem();
        System.out.println(modem.getDetails());
        //--DISK
        HardSysDiskDetails disk = hardSys.resources().getDisk();
        System.out.println(disk.getDetails());
        //--BLUETOOTH
        HardSysBluetoothDetails bluetooth = hardSys.resources().getBluetooth();
        System.out.println(bluetooth.getDetails());
        //--VIDEO
        HardSysVideoDetails video = hardSys.resources().getVideo();
        System.out.println(video.getDetails());
        //--STORAGE
        HardSysStorageDetails storage = hardSys.resources().getStorage();
        System.out.println(storage.getDetails());
        //--BRIDGE
        HardSysBridgeDetails bridge = hardSys.resources().getBridge();
        System.out.println(bridge.getDetails());
        //--NETWORK-INTERFACE
        HardSysNicInterfaceDetails networkInterface = hardSys.resources().getNicInterface();
        System.out.println(networkInterface.getDetails());
        //--UNKNOWN
        HardSysUnknownDetails unknown = hardSys.resources().getUnknown();
        System.out.println(unknown.getDetails());
    }

    @Test
    public void generalSystemInfoByHwinfoCommand_GROUP_Test() {

        HardSys hardSys = new HardSys(HWINFO);
        hardSys.json();

        //--DEVICES (GROUPS)
        HardSysDevicesGroupDetails devicesGroup = hardSys.resources().getDevicesGroup();
        System.out.println(devicesGroup.getDetails());
        //--NETWORK (GROUPS)
        HardSysNetworkGroupDetails networkGroup = hardSys.resources().getNetworksGroup();
        System.out.println(networkGroup.getDetails());
        //--DRIVES (GROUPS)
        HardSysDrivesGroupDetails drives = hardSys.resources().getDrivesGroup();
        System.out.println(drives.getDetails());
        //--COMPONENTS (GROUPS)
        HardSysComponentsGroupDetails components = hardSys.resources().getComponentsGroup();
        System.out.println(components.getDetails());
        //--BOARDS (GROUPS)
        HardSysBoardsGroupDetails boards = hardSys.resources().getBoardsGroup();
        System.out.println(boards.getDetails());
        //--HARDWARE (GROUPS)
        HardSysHardwareGroupDetails hardware = hardSys.resources().getHardwareGroup();
        System.out.println(hardware.getDetails());
    }

    @Test
    public void generalSystemInfoByHwinfoCommand_ALL_JSON_Test() {
        HardSys hardSys = new HardSys(HWINFO);
        hardSys.json();
        System.out.println(hardSys.resources().all());
    }

    @Test
    public void generalSystemInfoByHwinfoCommand_ALL_DTO_Test() {
        HardSys hardSys = new HardSys(HWINFO);

        HardSysResourcesDto result = hardSys.resources().builder();
        System.out.println(result);

        //HardSysResourcesDto nonNull = hardSys.resources().nonNull();
        //System.out.println(nonNull);
    }
}