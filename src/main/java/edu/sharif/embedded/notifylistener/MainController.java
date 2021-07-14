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

@RestController
@Slf4j
public class MainController {
    @Autowired
    private MainService mainService;

    @PostMapping("/pic")
    public ResponseEntity<Void> receivePic(@RequestParam("pic_file") MultipartFile file) {
        log.info("File name: {}", file.getName());
        if (mainService.storeFile(file))
            return ResponseEntity.status(HttpStatus.OK).build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @GetMapping("/start")
    public void startUpload(@RequestParam(name = "file_name") String fileName) {
        log.info("Starting upload of file {}", fileName);
    }
}
