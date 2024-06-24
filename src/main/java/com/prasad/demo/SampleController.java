package com.prasad.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Slf4j
@RestController
public class SampleController {

    @GetMapping("/healthcheck")
    ResponseEntity<String> healthcheck() throws InterruptedException {
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        log.info("Inside osample-tracking-api --> healthcheck");
        String responseText = "Sample tracking API healthcheck @ " + timeStamp + " - All OK";
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.TEXT_PLAIN).body(responseText.toString());
    }

    @GetMapping("/createsample")
    ResponseEntity<String> createSample() throws InterruptedException {
        log.info("Inside sample-tracking-api --> createSample");
        Random rand = new Random();
        int sampleId;
        sampleId = rand.nextInt(100000);
        log.info("Created sampleID : "+sampleId);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.TEXT_PLAIN).body("Sample created : "+String.valueOf(sampleId));
    }

    @GetMapping("/listsamples")
    ResponseEntity<String> listsamples() throws InterruptedException {
        log.info("Inside sample-tracking-api --> listsamples");
        String sampleId = "62293, 292038, 282093, 19203";
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.TEXT_PLAIN).body("Samples retrieved : "+String.valueOf(sampleId));
    }


}
