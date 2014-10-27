package com.cases.controller;

import com.cases.model.mongo.ChatLine;
import com.cases.model.mongo.ParticipantUser;
import com.cases.repository.ICaseRepository;
import com.cases.repository.impl.mongo.CaseMongoRepository;
import com.cases.repository.impl.mongo.ParticipantMongoRepository;
import com.cases.repository.impl.mongo.UserProfileMongoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.nashorn.internal.ir.debug.JSONWriter;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * Created by mario on 7/2/14.
 */
@Controller()
public class CaseController {
          Logger logger = LoggerFactory.getLogger(CaseController.class);

    @Autowired
    CaseMongoRepository caseRepository;

    @Autowired
    MongoTemplate template;

    @Autowired
    ParticipantMongoRepository  participantRepository;

    @Autowired
    UserProfileMongoRepository  userProfileRepo;

    @Value("${uploads.basedir}")
    String basePath;

    public static final String DIR_SEP = "/";

    @RequestMapping(value= "/forum/chatToCase", method=RequestMethod.POST)
    public @ResponseBody
    String chatToCase(@RequestParam("partId") String partId, @RequestParam("text") String text) {
          caseRepository.chatToCase( partId, text);
          return "OK";
    }

    @RequestMapping(value= "/forum/findByCase", method=RequestMethod.GET)
    public @ResponseBody
    List<ChatLine> findChatsByCase(@RequestParam("caseId") String caseId) {
        return caseRepository.findChatsByCase( caseId);
    }

    @RequestMapping(value = "/upload", method=RequestMethod.GET)
    public @ResponseBody    String  provideUploadInfo() {
        return "Post Images and other multimedia here";
    }

    @RequestMapping(value = "/myfiles/{file_name}", method = RequestMethod.GET)
    public void getFile(
            @PathVariable("file_name") String fileName,
            HttpServletResponse response) {
        try {
            System.out.println(fileName);
            // get your file as InputStream
            FileInputStream fi = new FileInputStream(new File(basePath + DIR_SEP +fileName ));
            InputStream is = fi;
            // copy it to response's OutputStream

           IOUtils.copy(is, response.getOutputStream());
            response.flushBuffer();
        } catch (IOException ex) {
            System.out.println("Error writing file to output stream. Filename was '{}'" +   fileName + ex);
            throw new RuntimeException("IOError writing file to output stream");
        }

    }


    @RequestMapping(value="/test", method=RequestMethod.GET)
    public @ResponseBody String handleTest() throws Exception {

        ParticipantUser p = template.findOne(new BasicQuery("{ \"participantCase.$id\" : { \"$oid\":\"543c9bd13004a6c471c5dfd0\"} }"), ParticipantUser.class);
        if(p!=null) {
            logger.info(p.getId());
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(p);
        }
        return "OK";
    }

    @RequestMapping(value = "/upload", method=RequestMethod.POST)
    public @ResponseBody String handleFileUpload(@RequestParam("name") String name,
                                       @RequestParam("userId") String userId,
                                       @RequestParam("caseId") String caseId,
                                       @RequestParam("file") MultipartFile file) {

        ObjectId oc = new ObjectId(caseId);
        ObjectId ou = new ObjectId(userId);
        ParticipantUser pUser = participantRepository.findByParticipantCaseCaseIdAndUserProfileUserId(oc, ou);
        if(pUser==null)
            return "This User didnt exist for the case specified.";


        if(!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();

                String dirPath;
                BufferedOutputStream stream;

                String folder ;
                if(caseId != null)
                    // upload as user picture
                    folder =  caseId;
                    // or it belongs to a case
                else
                    folder = userId;

                dirPath = basePath+ DIR_SEP + folder;

                String  imageURL = String.format("/files/%s/%s", folder, name)   ;

                File dir = new File(dirPath);
                if (!dir.exists())
                    dir.mkdirs();
                stream = new
                        BufferedOutputStream(new FileOutputStream(new File(dirPath + DIR_SEP + name)));
                stream.write(bytes);
                stream.flush();
                stream.close();


                caseRepository.chatToCase(pUser.getId(), imageURL );
                return imageURL; // "You successfully uploaded " + name ;
                                                     // /files/typeId/filename
            } catch(Exception e) {
                e.printStackTrace();
                return " Upload failed ";

            }
        }  else {
            return "File was empty" ;
        }
    }



}
