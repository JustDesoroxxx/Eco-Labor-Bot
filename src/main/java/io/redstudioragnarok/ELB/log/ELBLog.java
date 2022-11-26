package io.redstudioragnarok.ELB.log;

public class ELBLog {

    public static void info (String text) {
        System.out.println((char)27 + "[38m" + text);
    }

    public static void success (String text) {
        System.out.println((char)27 + "[32m" + text);
    }

    public static void error (String text) {
        System.out.println((char)27 + "[31m" + text);
    }
}
