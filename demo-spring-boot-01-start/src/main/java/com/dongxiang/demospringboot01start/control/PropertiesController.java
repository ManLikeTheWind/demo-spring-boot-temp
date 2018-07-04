package com.dongxiang.demospringboot01start.control;

import com.dongxiang.demospringboot01start.properties.My1Properties;
import com.dongxiang.demospringboot01start.properties.My2Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = {"/properties"})
public class PropertiesController {

    private static final Logger mlogger=LoggerFactory.getLogger(PropertiesController.class);

    private  My1Properties mMy1Properties;
    private final My2Properties mMy2Properties;

    @Autowired
    public PropertiesController(My1Properties my1Properties, My2Properties my2Properties) {
        mMy1Properties = my1Properties;
        mMy2Properties = my2Properties;
    }

    @RequestMapping(value = {"/my1"},method = RequestMethod.GET)
    public Object my1Properties(HttpServletRequest request , HttpServletResponse response){
        System.out.println("PropertiesController.my1Properties[request, response]: ");
        mlogger.info(mMy1Properties.toString());
        System.out.println("PropertiesController.my1Properties[request, response]: aft");
        return mMy1Properties;
    }

    @RequestMapping(value = "/my2",method = RequestMethod.GET)
    public Object my2Properties(HttpServletRequest request , HttpServletResponse response){
        System.out.println("PropertiesController.my1Properties[request, response]: ");
        mlogger.info(mMy2Properties.toString());
        System.out.println("PropertiesController.my1Properties[request, response]: aft");
        return mMy2Properties.toString();
    }




}
