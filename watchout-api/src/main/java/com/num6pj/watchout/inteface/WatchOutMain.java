package com.num6pj.watchout.inteface;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WatchOutMain {

    @GetMapping("/")
    public String helloProject(){
        return "Let's Go!! ";
    }
}
