package io.redstudioragnarok.ELB;

import io.redstudioragnarok.ELB.log.ELBLog;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class EcoLaborBot {

    public static int laborPerCycle = 3000;
    public static int laborNeeded = 18000;

    public static void main(String[] args) throws InterruptedException {
        ELBLog.info("Hello World!");

        controller.initController();

        for (int i = 0; i < 3; i ++){
            Toolkit.getDefaultToolkit().beep();
            TimeUnit.MILLISECONDS.sleep(1250);
        }

        ELBLog.success("ELB has successfully started!");

        int cycle = laborNeeded / laborPerCycle;

        controller.putLabor(cycle);
    }
}
