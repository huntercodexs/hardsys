package com.huntercodexs.hardsys.core;

import com.huntercodexs.hardsys.command.HardSysCommands;
import com.huntercodexs.hardsys.core.factory.*;

import java.util.HashMap;
import java.util.List;

public class HardSysFactory extends HardSysBase {

    public HardSysFactory(
            HardSysCommands command,
            HashMap<String, List<String>> resources,
            HashMap<String, Object> transport
    ) {
        this.command = command;
        this.resources = resources;
        this.transport = transport;
    }

    public void make() {
        if (this.command.equals(HardSysCommands.INXI)) {
            new HardSysInxiFactory(this.resources, this.transport).factory();
        } else if (this.command.equals(HardSysCommands.HWINFO)) {
            new HardSysHwinfoFactory(this.resources, this.transport).factory();
        } else if (this.command.equals(HardSysCommands.LSHW)) {
            new HardSysLshwFactory(this.resources, this.transport).factory();
        } else if (this.command.equals(HardSysCommands.LSCPU)) {
            new HardSysLsCpuFactory(this.resources).factory();
        } else if (this.command.equals(HardSysCommands.LSPCI)) {
            new HardSysLsPciFactory(this.resources).factory();
        } else if (this.command.equals(HardSysCommands.LSUSB)) {
            new HardSysLsUsbFactory(this.resources).factory();
        } else if (this.command.equals(HardSysCommands.DMIDECODE)) {
            new HardSysDmidecodeFactory(this.resources).factory();
        } else if (this.command.equals(HardSysCommands.SYSTEMINFO)) {
            new HardSysSystemInfoFactory(this.resources).factory();
        } else {
            throw new RuntimeException("Invalid command to run make resource method: " + this.command);
        }
    }

}
