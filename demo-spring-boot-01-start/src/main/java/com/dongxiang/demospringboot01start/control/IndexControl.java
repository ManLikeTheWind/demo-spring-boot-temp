package com.dongxiang.demospringboot01start.control;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexControl {
    @RequestMapping(value = {"/index"},method = RequestMethod.GET)
    @ResponseBody
    public Object index(HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> map=new HashMap<>();
        map.put("name","dongxiang");
        map.put("age",18);
        map.put("date",new Date());
        map.put("fridend",new String[]{"tommy","jack","franky"});
        return map;
    }


}
