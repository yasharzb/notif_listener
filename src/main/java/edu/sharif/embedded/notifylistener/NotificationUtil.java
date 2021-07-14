package edu.sharif.embedded.notifylistener;

import dorkbox.notify.Notify;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public final class NotificationUtil {
    private static String imageBrowser;

    public static void showNotification(String filePath, String time) {
        Notify.create()
                .title("Detector")
                .text("GUILTY passenger caught at " + time)
                .darkStyle()
                .onAction(notify -> {
                    ProcessBuilder processBuilder = new ProcessBuilder(imageBrowser, filePath);
                    try {
                        processBuilder.start();
                    } catch (IOException e) {
                        log.error("Couldn't open image file");
                    }
                })
                .show();

    }

    public static void showNotification() {
        Notify.create()
                .title("Detector")
                .text("Started")
                .darkStyle()
                .show();
    }

    public static void setImageBrowser(String imageBrowser) {
        NotificationUtil.imageBrowser = imageBrowser;
    }
}