package com.fnc.postapi.controller;

import java.util.Map;

import com.fnc.postapi.dto.PostRequest;
import com.fnc.postapi.dto.PostRequest2;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class PostApiController{
    
    //클라이언트에서 post 전성
    //{"account":"mrsiono0","email":"asdfasdf"}
    @PostMapping("/post")
    public void post(@RequestBody Map<String, Object> requestData){
        System.out.println("psot api~~~");
        requestData.forEach((key, value)->{
            System.out.println("key:\t" + key);
            System.out.println("value:\t" + value);

        });
    }

    @PostMapping("/post2")
    public void post2(@RequestBody PostRequest requestData){
        System.out.println(requestData.toString());
    }

    //HTML,CSS ex-ample
    //JS,ex_ample
    //JAVA, exAmple
    @PostMapping("/post3")
    public void post3(@RequestBody PostRequest2 requestData,  @PathVariable int age){
        System.out.println(requestData.toString());
        System.out.println("age:"+age);
    }


}