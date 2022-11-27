package io.redstudioragnarok.ELB;

import io.redstudioragnarok.ELB.log.ELBLog;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class EcoLaborBot extends Application {

    public static int laborPerCycle = 6600;
    public static int laborNeeded = 50000;

    @Override
    public void start(Stage stage) {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        Label l = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        Scene scene = new Scene(new StackPane(l), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws InterruptedException {
        launch();

        for (int i = 0; i < 3; i ++){
            Toolkit.getDefaultToolkit().beep();
            TimeUnit.MILLISECONDS.sleep(1250);
        }

        controller.initController();

        ELBLog.success("ELB has successfully started!");

        int cycle = laborNeeded / laborPerCycle;

        ELBLog.info("With " + laborNeeded + " labor needed and " + laborPerCycle + " labor per cycle there is " + cycle + " cycles to do.");
        cycle *= 2.5;
        ELBLog.info("Double that for safety " + cycle + ".");

        controller.putLabor(cycle);
    }

    public static void startBot() {

    }
}
