package edu.sharif.embedded.notifylistener;

import dorkbox.notify.Notify;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class MainService {
    @Value(value = "${image-browser}")
    private String imageBrowser;

    @PostConstruct
    public void init() {
        NotificationUtil.setImageBrowser(imageBrowser);
    }

    public boolean storeFile(MultipartFile file) {
        Path target = Path.of(file.getOriginalFilename());
        try {
            Files.copy(file.getInputStream(), target, StandardCopyOption.REPLACE_EXISTING);
            log.info("File {} is saved", file.getOriginalFilename());
            String fileName = file.getOriginalFilename();
            String time = fileName.substring(fileName.lastIndexOf("-") + 1, fileName.indexOf("."));
            NotificationUtil.showNotification(target.toString(), time);
            return true;
        } catch (IOException e) {
            log.error("Failed to save file");
            return false;
        }
    }
}
