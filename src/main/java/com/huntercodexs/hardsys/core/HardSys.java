package com.huntercodexs.hardsys.core;

import com.huntercodexs.hardsys.command.*;

import java.util.ArrayList;
import java.util.HashMap;

import static com.huntercodexs.hardsys.command.HardSysCommands.*;

public class HardSys extends HardSysBase {

    public HardSys(HardSysCommands command) {
        this.command = command;
        this.checkOs();
        this.loader();
    }

    private void checkOs() {
        String os = System.getProperty("os.name");
        String msg = "Invalid OS - This command should be used on";

        /*
         * The command will be configured late in the process flow
         * */
        if (this.command.equals(AUTO)) {
            return;
        }

        if (os.contains("Linux") || os.contains("Macintosh")) {

            if (this.command.equals(SYSTEMINFO)) {
                throw new RuntimeException(msg+" DOS/Windows");
            }

        } else if (os.contains("Windows")) {

            if (!this.command.equals(SYSTEMINFO)) {
                throw new RuntimeException(msg+" UNIX/Linux");
            }

        } else {
            throw new RuntimeException("OS not recognized !");
        }
    }

    private void loader() {

        this.resources = new HashMap<>();/*JSON*/
        this.transport = new HashMap<>();/*DTO*/

        for (String res : hardsysFields()) {
            this.resources.put(res, new ArrayList<>());
        }

        /*Global information - for all commands*/
        new HardSysSystem(this.resources).run();

        /*Command information - specific command*/
        if (this.command.equals(HardSysCommands.INXI)) {
            new HardSysInxi(this.resources).run();
        } else if (this.command.equals(HardSysCommands.HWINFO)) {
            new HardSysHwinfo(this.resources).run();
        } else if (this.command.equals(HardSysCommands.LSHW)) {
            new HardSysLshw(this.resources).run();
        } else if (this.command.equals(HardSysCommands.LSCPU)) {
            new HardSysLsCpu(this.resources).run();
        } else if (this.command.equals(HardSysCommands.LSPCI)) {
            new HardSysLsPci(this.resources).run();
        } else if (this.command.equals(HardSysCommands.LSUSB)) {
            new HardSysLsUsb(this.resources).run();
        } else if (this.command.equals(HardSysCommands.DMIDECODE)) {
            new HardSysDmidecode(this.resources).run();
        } else if (this.command.equals(HardSysCommands.SYSTEMINFO)) {
            new HardSysSystemInfo(this.resources).run();
        } else {
            throw new RuntimeException("Wrong sys cmd to retrieve information: " + sysCmd(this.command));
        }
    }

    public void json() {
        this.setJsonOn();
    }

    public HardSysResources resources() {
        if (!this.getJsonOn()) {
            /*for DTO result*/
            new HardSysFactory(this.command, this.resources, this.transport).make();
            return new HardSysResources(this.transport, this.command);
        }
        /*for JSON result*/
        return new HardSysResources(this.command, this.resources);
    }

}
