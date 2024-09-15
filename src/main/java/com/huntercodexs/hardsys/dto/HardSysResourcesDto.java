package com.huntercodexs.hardsys.dto;

public class HardSysResourcesDto {

    /*
     * Do not change this fields, it used for JSON results
     * */
    private String all;
    private String boardsGroup;
    private String drivesGroup;
    private String devicesGroup;
    private String networksGroup;
    private String hardwareGroup;
    private String componentsGroup;

    //Available Information: Hardware x System
    private HardSysSystemDto system;
    private HardSysMachineDto machine;
    private HardSysBatteryDto battery;
    private HardSysMemoryDto memory;
    private HardSysSlotsDto slots;
    private HardSysProcessorDto processor;
    private HardSysGraphicsDto graphics;
    private HardSysAudioDto audio;
    private HardSysNetworkDto network;
    private HardSysDriversDto drivers;
    private HardSysPartitionDto partition;
    private HardSysCdRomDto cdrom;
    private HardSysUsbDto usb;
    private HardSysSensorsDto sensors;
    private HardSysRunningDto running;
    private HardSysMonitorDto monitor;
    private HardSysBiosDto bios;
    private HardSysBaseboardDto baseboard;
    private HardSysControllerDto controller;
    private HardSysChassisDto chassis;
    private HardSysCacheDto cache;
    private HardSysConnectorDto connector;
    private HardSysKeyboardDto keyboard;
    private HardSysMouseDto mouse;
    private HardSysHubDto hub;
    private HardSysSwitchDto switcher;
    private HardSysModemDto modem;
    private HardSysDiskDto disk;
    private HardSysDrivesDto drives;
    private HardSysBluetoothDto bluetooth;
    private HardSysVideoDto video;
    private HardSysStorageDto storage;
    private HardSysBridgeDto bridge;
    private HardSysNicInterfaceDto nicInterface;
    private HardSysUnknownDto unknown;
    private HardSysMultimediaDto multimedia;
    private HardSysPrinterDto printer;

    public HardSysSystemDto getSystem() {
        return system;
    }

    public void setSystem(Object system) {
        this.system = (HardSysSystemDto)system;
    }

    public HardSysMachineDto getMachine() {
        return machine;
    }

    public void setMachine(Object machine) {
        this.machine = (HardSysMachineDto)machine;
    }

    public HardSysBatteryDto getBattery() {
        return battery;
    }

    public void setBattery(Object battery) {
        this.battery = (HardSysBatteryDto)battery;
    }

    public HardSysMemoryDto getMemory() {
        return memory;
    }

    public void setMemory(Object memory) {
        this.memory = (HardSysMemoryDto)memory;
    }

    public HardSysSlotsDto getSlots() {
        return slots;
    }

    public void setSlots(Object slots) {
        this.slots = (HardSysSlotsDto)slots;
    }

    public HardSysProcessorDto getProcessor() {
        return processor;
    }

    public void setProcessor(Object processor) {
        this.processor = (HardSysProcessorDto) processor;
    }

    public HardSysGraphicsDto getGraphics() {
        return graphics;
    }

    public void setGraphics(Object graphics) {
        this.graphics = (HardSysGraphicsDto)graphics;
    }

    public HardSysAudioDto getAudio() {
        return audio;
    }

    public void setAudio(Object audio) {
        this.audio = (HardSysAudioDto)audio;
    }

    public HardSysNetworkDto getNetwork() {
        return network;
    }

    public void setNetwork(Object network) {
        this.network = (HardSysNetworkDto)network;
    }

    public HardSysDriversDto getDrivers() {
        return drivers;
    }

    public void setDrivers(Object drivers) {
        this.drivers = (HardSysDriversDto)drivers;
    }

    public HardSysPartitionDto getPartition() {
        return partition;
    }

    public void setPartition(Object partition) {
        this.partition = (HardSysPartitionDto)partition;
    }

    public HardSysCdRomDto getCdRom() {
        return cdrom;
    }

    public void setCdRom(Object cdrom) {
        this.cdrom = (HardSysCdRomDto) cdrom;
    }

    public HardSysUsbDto getUsb() {
        return usb;
    }

    public void setUsb(Object usb) {
        this.usb = (HardSysUsbDto)usb;
    }

    public HardSysSensorsDto getSensors() {
        return sensors;
    }

    public void setSensors(Object sensors) {
        this.sensors = (HardSysSensorsDto)sensors;
    }

    public HardSysRunningDto getRunning() {
        return running;
    }

    public void setRunning(Object running) {
        this.running = (HardSysRunningDto)running;
    }

    public HardSysMonitorDto getMonitor() {
        return monitor;
    }

    public void setMonitor(Object monitor) {
        this.monitor = (HardSysMonitorDto)monitor;
    }

    public HardSysBiosDto getBios() {
        return bios;
    }

    public void setBios(Object bios) {
        this.bios = (HardSysBiosDto)bios;
    }

    public HardSysBaseboardDto getBaseboard() {
        return baseboard;
    }

    public void setBaseboard(Object baseboard) {
        this.baseboard = (HardSysBaseboardDto)baseboard;
    }

    public HardSysControllerDto getController() {
        return controller;
    }

    public void setController(Object controller) {
        this.controller = (HardSysControllerDto) controller;
    }

    public HardSysChassisDto getChassis() {
        return chassis;
    }

    public void setChassis(Object chassis) {
        this.chassis = (HardSysChassisDto)chassis;
    }

    public HardSysCacheDto getCache() {
        return cache;
    }

    public void setCache(Object cache) {
        this.cache = (HardSysCacheDto)cache;
    }

    public HardSysConnectorDto getConnector() {
        return connector;
    }

    public void setConnector(Object connector) {
        this.connector = (HardSysConnectorDto)connector;
    }

    public HardSysKeyboardDto getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(Object keyboard) {
        this.keyboard = (HardSysKeyboardDto)keyboard;
    }

    public HardSysMouseDto getMouse() {
        return mouse;
    }

    public void setMouse(Object mouse) {
        this.mouse = (HardSysMouseDto)mouse;
    }

    public HardSysHubDto getHub() {
        return hub;
    }

    public void setHub(Object hub) {
        this.hub = (HardSysHubDto)hub;
    }

    public HardSysSwitchDto getSwitcher() {
        return switcher;
    }

    public void setSwitcher(Object switcher) {
        this.switcher = (HardSysSwitchDto)switcher;
    }

    public HardSysModemDto getModem() {
        return modem;
    }

    public void setModem(Object modem) {
        this.modem = (HardSysModemDto)modem;
    }

    public HardSysDiskDto getDisk() {
        return disk;
    }

    public void setDisk(Object disk) {
        this.disk = (HardSysDiskDto)disk;
    }

    public HardSysDrivesDto getDrives() {
        return drives;
    }

    public void setDrives(Object drives) {
        this.drives = (HardSysDrivesDto) drives;
    }

    public HardSysBluetoothDto getBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(Object bluetooth) {
        this.bluetooth = (HardSysBluetoothDto)bluetooth;
    }

    public HardSysVideoDto getVideo() {
        return video;
    }

    public void setVideo(Object video) {
        this.video = (HardSysVideoDto)video;
    }

    public HardSysStorageDto getStorage() {
        return storage;
    }

    public void setStorage(Object storage) {
        this.storage = (HardSysStorageDto)storage;
    }

    public HardSysBridgeDto getBridge() {
        return bridge;
    }

    public void setBridge(Object bridge) {
        this.bridge = (HardSysBridgeDto)bridge;
    }

    public HardSysNicInterfaceDto getNicInterface() {
        return nicInterface;
    }

    public void setNicInterface(Object nicInterface) {
        this.nicInterface = (HardSysNicInterfaceDto) nicInterface;
    }

    public HardSysUnknownDto getUnknown() {
        return unknown;
    }

    public void setUnknown(Object unknown) {
        this.unknown = (HardSysUnknownDto)unknown;
    }

    public HardSysMultimediaDto getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(Object multimedia) {
        this.multimedia = (HardSysMultimediaDto) multimedia;
    }

    public HardSysPrinterDto getPrinter() {
        return printer;
    }

    public void setPrinter(Object printer) {
        this.printer = (HardSysPrinterDto) printer;
    }

    public String toString() {
        return "HardSysResourcesDto[\n" +
                "\tsystem=" + system + ",\n" +
                "\tmachine=" + machine + ",\n" +
                "\tbattery=" + battery + ",\n" +
                "\tmemory=" + memory + ",\n" +
                "\tslots=" + slots + ",\n" +
                "\tprocessor=" + processor + ",\n" +
                "\tgraphics=" + graphics + ",\n" +
                "\taudio=" + audio + ",\n" +
                "\tnetwork=" + network + ",\n" +
                "\tdrivers=" + drivers + ",\n" +
                "\tpartition=" + partition + ",\n" +
                "\tcdrom=" + cdrom + ",\n" +
                "\tusb=" + usb + ",\n" +
                "\tsensors=" + sensors + ",\n" +
                "\trunning=" + running + ",\n" +
                "\tmonitor=" + monitor + ",\n" +
                "\tbios=" + bios + ",\n" +
                "\tbaseboard=" + baseboard + ",\n" +
                "\tcontroller=" + controller + ",\n" +
                "\tchassis=" + chassis + ",\n" +
                "\tcache=" + cache + ",\n" +
                "\tconnector=" + connector + ",\n" +
                "\tkeyboard=" + keyboard + ",\n" +
                "\tmouse=" + mouse + ",\n" +
                "\thub=" + hub + ",\n" +
                "\tswitcher=" + switcher + ",\n" +
                "\tmodem=" + modem + ",\n" +
                "\tdisk=" + disk + ",\n" +
                "\tdrives=" + drives + ",\n" +
                "\tbluetooth=" + bluetooth + ",\n" +
                "\tvideo=" + video + ",\n" +
                "\tstorage=" + storage + ",\n" +
                "\tbridge=" + bridge + ",\n" +
                "\tnicInterface=" + nicInterface + ",\n" +
                "\tunknown=" + unknown + ",\n" +
                "\tmultimedia=" + multimedia + ",\n" +
                "\tprinter=" + printer + "\n" +
                "]";
    }
}
