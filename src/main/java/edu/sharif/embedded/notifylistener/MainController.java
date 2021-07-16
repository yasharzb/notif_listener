package edu.sharif.embedded.notifylistener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@Slf4j
public class MainController {
    @Autowired
    private MainService mainService;

    @PostMapping("/pic")
    public ResponseEntity<Boolean> receivePic(@RequestParam("pic_file") MultipartFile file) {
        log.info("File name: {}", file.getName());
        try {
            Boolean result = mainService.storeFile(file);
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/start")
    public void startUpload(@RequestParam(name = "file_name") String fileName) {
        log.info("Starting upload of file {}", fileName);
    }
}
