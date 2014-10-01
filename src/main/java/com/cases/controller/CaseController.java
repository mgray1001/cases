package com.cases.controller;

import com.cases.model.Case;
import com.cases.repository.ICaseRepository;
import com.cases.repository.impl.mongo.CaseMongoRepository;
import com.cases.repository.impl.mongo.UserProfileMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

/**
 * Created by mario on 7/2/14.
 */
@Controller()
public class CaseController {

    @Autowired
    CaseMongoRepository caseRepository;

    @Autowired
    UserProfileMongoRepository  userProfileRepo;

    @RequestMapping(value = "/upload", method=RequestMethod.GET)
    public @ResponseBody    String  provideUPloadInfo() {
        return "Post Images and other multimedia here";
    }

    @RequestMapping(value = "/upload", method=RequestMethod.POST)
    public @ResponseBody String handleFileUpload(@RequestParam("name") String name,
                                       @RequestParam("partUser") String participantUserId,
                                       @RequestParam("file") MultipartFile file) {

        userProfileRepo.findByUserId(participantUserId);
        if(!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream = new
                        BufferedOutputStream(new FileOutputStream(new File(name+"-uploaded")));
                stream.write(bytes);
                stream.flush();
                stream.close();
                return "You successfully uplaoded " + name ;

            } catch(Exception e) {
                return " Upload failed ";
            }
        }  else {
            return "File was empty" ;
        }
    }



}
