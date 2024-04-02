package com.propertymarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class TestController {

    @Autowired
    private ResourceLoader resourceLoader;
    @GetMapping("/check-path")
    public String check() throws IOException {
        Path path = Paths.get("src");
        String uploadsDirectory = path.getFileName().toFile().getAbsolutePath();
        uploadsDirectory += "/main/resources/static/uploads";
//        FileOutputStream fileOutputStream = new FileOutputStream(uploadsDirectory + "/test.txt");
//        fileOutputStream.write("apple".getBytes());

        Files.write(Path.of(uploadsDirectory + "/pineapple"), "pineapple".getBytes());
        return uploadsDirectory;
    }

    @GetMapping({"/modelview", "/modelview/"})
    public ModelAndView modelAndView() {
        ModelAndView mnv = new ModelAndView("someview.html");
        mnv.addObject("data", new Object() {
            public final String name = "modelview";
        });
        return mnv;
    }
}
