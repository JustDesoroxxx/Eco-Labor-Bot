package io.redstudioragnarok.ELB;

import io.redstudioragnarok.ELB.log.ELBLog;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class controller {

    static Robot robot;

    static int foodX = 1600;
    static int foodY = 1020;

    static int cycleLeft = 0;

    public static void initController() {
        try {
            robot = new Robot();
            ELBLog.success("Controller initialized");
        } catch (AWTException e) {
            ELBLog.error("Cannot initialize controller");
        }
    }

    public static void putLabor(int cycle) throws InterruptedException {
        robot.keyPress(KeyEvent.VK_ALT);
        TimeUnit.MILLISECONDS.sleep(80);

        cycleLeft = cycle;
        ELBLog.info("Let's do " + cycleLeft + " cycle");

        for (int i = 0; i < 2; i++) {
            robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
            TimeUnit.MILLISECONDS.sleep(20);
            robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
            TimeUnit.MILLISECONDS.sleep(20);
        }

        robot.keyRelease(KeyEvent.VK_ALT);

        if (cycleLeft != 0) {
            eat();
        }
    }

    public static void eat() throws InterruptedException {
        robot.keyPress(KeyEvent.VK_TAB);
        TimeUnit.MILLISECONDS.sleep(80);

        robot.mouseMove(foodX, foodY);

        for (int i = 0; i < 3; i ++) {
            robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
        }

        robot.keyRelease(KeyEvent.VK_TAB);

        cycleLeft --;
        ELBLog.info("There are " + cycleLeft + " cycle left");
        if (cycleLeft > 0) {
            putLabor(cycleLeft);
        }
    }
}
