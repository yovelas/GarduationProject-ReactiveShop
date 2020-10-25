package com.yovelas.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;


@RestController
@RequestMapping("/file")
@CrossOrigin
public class FileController {

    private String basepath="file/";

    @RequestMapping("/download/{file}")
    ResponseEntity downloadFile(HttpServletResponse resp,@PathVariable("file") String file) throws IOException {
        System.out.println(file);
        Path filestorage = Paths.get("src/main/resources/file/").resolve(file);
        UrlResource urlResource = new UrlResource(filestorage.toUri());
        ResponseEntity<UrlResource> body = ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+file+"").body(urlResource);
        return body;
    }

    @CrossOrigin
    @RequestMapping(value = "/upload")
    String upload(@RequestParam("file") MultipartFile file) throws IOException {
        String name = file.getName();
//        System.out.println(name);
        String filename = file.getResource().getFilename();
//        System.out.println(filename);
        String url = System.currentTimeMillis()+"-"+filename;
        new FileOutputStream(new File(basepath+url)).write(file.getBytes());
        return url;
    }
}
