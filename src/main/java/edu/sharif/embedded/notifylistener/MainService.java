package edu.sharif.embedded.notifylistener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@Service
@Slf4j
public class MainService {
    public boolean storeFile(MultipartFile file) {
        Path target = Path.of(file.getOriginalFilename());
        try {
            Files.copy(file.getInputStream(), target, StandardCopyOption.REPLACE_EXISTING);
            log.info("File {} is saved", file.getOriginalFilename());
            return true;
        } catch (IOException e) {
            log.error("Failed to save file");
            return false;
        }
    }
}
