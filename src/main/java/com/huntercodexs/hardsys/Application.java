package com.huntercodexs.hardsys;

import com.huntercodexs.hardsys.core.HardSysCli;

public class Application {

	public static void main(String[] args) {
        if (args.length >= 2) {
            String title = "HARDSYS CLI TABLE - https://huntercodexs.com";

            if (args.length >= 3 && !args[2].isEmpty()) {
                title = args[2];
            }

            HardSysCli cliOutput = new HardSysCli();
            cliOutput.hardsysCli(args[0], Integer.parseInt(args[1]), title);
        }
    }
}
