package com.huntercodexs.hardsys.command;

public enum HardSysCommands {

    AUTO("auto"),
    INXI("inxi -Fxz " +
            "--slots " +
            "--memory " +
            "--cpu " +
            "--disk-full " +
            "--graphics " +
            "--machine " +
            "--network " +
            "--sensors " +
            "--system " +
            "--usb " +
            "--info " +
            "--color"),
    HWINFO("hwinfo --short"),
    LSHW("lshw -short"),
    LSCPU("lscpu"),
    LSPCI("lspci"), //check the command: lspci -k
    LSUSB("lsusb"),
    DMIDECODE("dmidecode"),
    //For windows
    SYSTEMINFO("systeminfo");

    private final String cmd;

    HardSysCommands(String cmd) {
        this.cmd = cmd;
    }

    private String getCmd() {
        return cmd;
    }

    public static String sysCmd(HardSysCommands cmd) {
        return cmd.getCmd();
    }

}
