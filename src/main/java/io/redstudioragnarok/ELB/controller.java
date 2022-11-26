package io.redstudioragnarok.ELB;

import io.redstudioragnarok.ELB.log.ELBLog;

import java.awt.*;
import java.awt.event.KeyEvent;

public class controller {

    static Robot robot;

    public static void initController() {
        try {
            robot = new Robot();
            ELBLog.success("Controller initialized");
        } catch (AWTException e) {
            ELBLog.error("Cannot initialize controller");
        }
    }

    public static void move(String direction) {
        switch (direction) {
            case "stop":
                robot.keyRelease(KeyEvent.VK_W);
                robot.keyRelease(KeyEvent.VK_A);
                robot.keyRelease(KeyEvent.VK_D);
                robot.keyRelease(KeyEvent.VK_S);
                break;
            case "forward":
                robot.keyPress(KeyEvent.VK_W);
        }
    }

}
