package com.cases.controller;

import com.cases.model.Case;
import com.cases.repository.ICaseRepository;
import com.cases.repository.impl.mongo.CaseMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by mario on 7/2/14.
 */
@RestController()
public class CaseController {

    @Autowired
    CaseMongoRepository caseRepository;

    @RequestMapping("/cases")
    public List<Case> getAllCases(@RequestParam(value="start",required=false,defaultValue="0") String start,
                                  @RequestParam(value="end",required=false, defaultValue="10") String end) {
       return caseRepository.findAll();
               //getAllOpenCases(Integer.parseInt(start), Integer.parseInt(end));
    }

    @RequestMapping(value="/addcase", method= RequestMethod.PUT)
    public void putCase(@RequestBody Case c) {
        caseRepository.save( c);
    }



}
