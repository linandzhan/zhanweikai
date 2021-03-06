package zhanweikai.com.controller;


import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import zhanweikai.com.common.RestResult;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.*;
import java.util.UUID;

/**
 * 文件上传
 */
@RestController
public class FileController {

    @Resource
    private Environment environment;
    //文件上传路径
    private String attachmentHome;

    @PostConstruct
    public void init() {
        this.attachmentHome = (String) this.environment.getProperty("attachment.home", String.class, "attachment/");
        if (this.attachmentHome != null && !this.attachmentHome.endsWith("/")) {
            this.attachmentHome = this.attachmentHome;
        }
    }

    @PostMapping(value = "api/attachment/upload")
    public RestResult fileUpload(@RequestParam(value = "file") MultipartFile file) {
        if (file.isEmpty()) {
            System.out.println("文件为空空");
        }
        String fileName = file.getOriginalFilename();  // 文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        fileName = UUID.randomUUID() + suffixName; // 新文件名
        File dest = new File(attachmentHome + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        return JsonResult.success("文件上传成功",fileName);
        return RestResult.success("文件上传成功",fileName);
    }

    @PostMapping("api/attachment/delFile")
    public RestResult delFile(@RequestBody String path) {
        String substring = path.substring(0, path.length() - 1);
        String fileName = attachmentHome + substring;
        File file = new File(fileName);
        if(file.exists()) {
            if(file.delete()) {
                return RestResult.success("文件删除成功");
            } else {
                return RestResult.error("文件删除失败");
            }
        }else {
            return RestResult.error("文件不存在");
        }
    }
}
