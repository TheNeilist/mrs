package com.neilist.mrs.controller;

import com.neilist.mrs.service.ZipcodePointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Executors;

@Controller
public class ZipCodeCoordinatesController {

    @Autowired
    private ZipcodePointService zipcodePointService;

    @RequestMapping("/zipcode/import")
    public String zipcodeImportForm() {
        return "zipcode-upload";
    }

    @PostMapping("/zipcode/import")
    public String zipcodeImport(@RequestParam("file") MultipartFile file,
                                RedirectAttributes redirectAttributes) {
        try {
            byte[] bytes = file.getBytes();
            File savedFile = new File("/tmp/mrs/" + file.getOriginalFilename());
            Files.write(Paths.get(savedFile.getPath()), bytes);

            Executors.newCachedThreadPool().execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("importing zip code points in a new thread");
                    zipcodePointService.importZipcodePoints(savedFile);
                }
            });
        } catch (Exception e) {
            System.err.println("caught an exception importing zip code points: ");
            e.printStackTrace();
        }

        return "index";
    }

}
