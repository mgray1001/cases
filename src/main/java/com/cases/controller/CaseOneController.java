package com.cases.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

//@RestController
public class CaseOneController {

    //@RequestMapping("/")
    public String index() {
        return "Cases Controller";
    }

}
