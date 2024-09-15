package com.huntercodexs.hardsys;

import com.huntercodexs.hardsys.core.HardSysCli;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class HardSysCliTest {

    @Test
    public void cliOutputInxiTest() {
        HardSysCli cliOutput = new HardSysCli();
        cliOutput.hardsysCli(
                "inxi",
                80,
                "HARDSYS[INXI] CLI TABLE - https://huntercodexs.com");
    }

    @Test
    public void cliOutputHwinfoTest() {
        HardSysCli cliOutput = new HardSysCli();
        cliOutput.hardsysCli(
                "hwinfo",
                80,
                "HARDSYS[HWINFO] CLI TABLE - https://huntercodexs.com");
    }

    @Test
    public void cliOutputLshwTest() {
        HardSysCli cliOutput = new HardSysCli();
        cliOutput.hardsysCli(
                "lshw",
                80,
                "HARDSYS[LSHW] CLI TABLE - https://huntercodexs.com");
    }

}