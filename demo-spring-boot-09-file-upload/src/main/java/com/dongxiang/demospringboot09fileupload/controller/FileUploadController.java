package com.dongxiang.demospringboot09fileupload.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.Base64Utils;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = {"/uploads"})
public class FileUploadController {
     private static final Logger mLogger = LoggerFactory.getLogger(FileUploadController.class);

     @GetMapping
     public String index(){
         return "index";
     }


     @ResponseBody
     @PostMapping(value = {"/upload1"})
    public Map<String,String > upload1(@RequestParam("file")MultipartFile file) throws IOException {

         mLogger.info(Thread.currentThread()+"[file type]--[{}]==[file name]--[{}]==[file size]--[{}]",
                 file.getContentType(),file.getOriginalFilename(),file.getSize() );

         //TODO 将文件写入到指定目录（具体开发中可能是将文件写入到云存储/或指定目录:
        // TODO     通过Nginx进行 gzip 压缩和反向代理，此处只是为了演示故将地址写成本地电脑指定目录）)
         File fileDir=new File("F:\\app\\chapter16\\");
         if (!fileDir.exists()){
             fileDir.mkdirs();
         }
         File chidFile=new File(fileDir, file.getOriginalFilename());

        file.transferTo(chidFile);
        Map<String ,String> result=new HashMap<>(16);
        result.put("content-type", file.getContentType());
        result.put("file-name", file.getOriginalFilename());
        result.put("file-size", file.getSize()+"");
        return result;
    }

    @ResponseBody
    @PostMapping("/upload2")
    public List<Map<String,String  >> upload2(@RequestParam("file") MultipartFile[] files) throws IOException {
         if (files==null||files.length<1) return null;
         List<Map<String ,String>>results=new ArrayList<>();

        for (MultipartFile file :
                files) {
            //TODO spring mvc 提供的写入方式
            file.transferTo(new File("F:\\app\\chapter16\\"+file.getOriginalFilename()));
            Map<String ,String>map=new HashMap<>(16);
            map.put("content-type", file.getContentType());
            map.put("file-name", file.getOriginalFilename());
            map.put("file-size", file.getSize()+"");
            results.add(map);
        }
        return results;
    }

    @ResponseBody
    @PostMapping("/upload3")
    public void upload3(String base64) throws IOException {
         //TODO BASE64 方式的格式 和字名字 需要自己控制（如 png 图片编码后，前缀是 data:image/png;base64,)
         final File tempFile=new File("F:\\app\\chapter16\\test.jpg");

         //TODO 防止有的传了 data:image/png;base64,  有的没传的情况
         String []d=base64.split("base64,");
         final byte[]bytes=Base64Utils.decodeFromString(d.length>1?d[1]:d[0]);
        FileCopyUtils.copy(bytes, tempFile);
    }



}
