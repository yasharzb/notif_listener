package edu.sharif.embedded.notifylistener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NotifyListenerApplication {
    public static void main(String[] args) {
        NotificationUtil.showNotification();
        SpringApplication.run(NotifyListenerApplication.class, args);
    }

}
