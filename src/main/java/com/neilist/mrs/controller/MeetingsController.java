package com.neilist.mrs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MeetingsController {

    @RequestMapping("/meetings")
    public String meetings() {
        return "meetings";
    }

}
