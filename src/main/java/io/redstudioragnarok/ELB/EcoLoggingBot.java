package io.redstudioragnarok.ELB;

import io.redstudioragnarok.ELB.log.ELBLog;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class EcoLoggingBot {

    public static void main(String[] args) throws InterruptedException {
        ELBLog.info("Hello World!");

        controller.initController();

        for (int i = 0; i < 3; i ++){
            Toolkit.getDefaultToolkit().beep();
            TimeUnit.MILLISECONDS.sleep(1250);
        }

        ELBLog.success("ELB has successfully started!");

        controller.move("forward");
        TimeUnit.SECONDS.sleep(1);
        controller.move("stop");
    }
}
