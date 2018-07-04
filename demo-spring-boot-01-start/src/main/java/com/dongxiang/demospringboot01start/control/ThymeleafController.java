package com.dongxiang.demospringboot01start.control;

import com.dongxiang.demospringboot01start.entities.AuthorDetail;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * author:dongxiang
 * data:2018/7/2 15:20
 * email:dongxiang_android_sdk2@aliyun.com
 * description:
 * function: 
 * using: 
 * note:
 *  <li>@RestController 等价于 @Controller + @ResponseBody</li>
 *  <li>@GetMapping 等价于 @RequestMappingt(... method = RequestMethod.GET)</li>
 *  <li>@RestController 等价于 @Controller + @ResponseBody</li>
 */
@Controller
@RequestMapping(value = {"/thymeleaf"} ,method = RequestMethod.GET)
public class ThymeleafController {


    @RequestMapping(value = {"index.html"},method = RequestMethod.GET)
    public ModelAndView index0(){
        ModelAndView view=new ModelAndView();
        /** 设置跳转的视图 默认映射到 src/main/resources/templates/{viewName}.html*/
        view.setViewName("index");

        /** 设置属性key-value*/
        view.addObject("title","我的第一个页面");
        view.addObject("desc","欢迎进去Thymeleaf模板");

        /** 设置属性--对象 */
            AuthorDetail author=new AuthorDetail();
            author.setAge(18);
            author.setName("dongxiang");
            author.setEmail("dongxiang_android_sdk2@aliyu.com");
        view.addObject(author);
        return view;
    }

    @RequestMapping(method = RequestMethod.GET,value = {"index2.html"})
    public String index2(HttpServletRequest request, HttpServletResponse response){
        //TODO 与上面的写法不同，但是结果一致。
        // 设置属性
        request.setAttribute("title","my first web sheet");
        request.setAttribute("desc"," welcome, thymeleaf 模板");

        AuthorDetail detail=new AuthorDetail();
        detail.setName("dongxiang");
        detail.setAge(18);
        detail.setEmail("dongxiang_android_sdk2@aliyun.com");
        request.setAttribute("authorDetail",detail);

     // 返回的 index 默认映射到 src/main/resources/templates/xxxx.html
        return "index";
    }




}
