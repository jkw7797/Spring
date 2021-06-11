package com.fnc.putapi.controller;

import com.fnc.putapi.dto.PutRequeset;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PutApiController {
    //JSON
    // {
    //     "name": "abc",
    //     "age": 20,
    //     "car_list": [
    //         {"name":"BMW", "car_number":"12345"},
    //         {"name":"K7", "car_number":"54321"}
    //     ]
    // }


    @PutMapping("/put")
    public void put(@RequestBody PutRequeset requestData){
        System.out.println(requestData.toString());
    }
}
