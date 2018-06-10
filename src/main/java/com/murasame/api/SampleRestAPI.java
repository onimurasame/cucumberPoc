package com.murasame.api;

import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleRestAPI {

    @RequestMapping(path = "/test", method = RequestMethod.GET)
    public String aSampleRestMethod(@RequestParam(value = "name", defaultValue = "John Doe") String name) {
        return name;
    }

}
