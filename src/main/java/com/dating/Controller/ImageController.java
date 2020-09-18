package com.dating.Controller;

import com.dating.pojo.UserInfo;
import com.dating.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@Controller
public class ImageController {

    @Autowired
    private  UserService userService;



    // 执行上传
    @RequestMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file, Model model) {
        // 获取上传文件名
        Subject subject = SecurityUtils.getSubject();
        UserInfo userInfo = (UserInfo) subject.getSession().getAttribute("userInfo");
        String photo = file.getOriginalFilename();
        File path = null;
        try {
             path = new File(ResourceUtils.getURL("classpath:").getPath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if(path== null || !path.exists()) {
        path = new File("");
    }

    String pathStr = path.getAbsolutePath();
        pathStr=pathStr.replace("target\\classes", "src\\main\\resources\\static\\images\\myaccount");

        try {
            // 写入文件
            file.transferTo(new File(pathStr + File.separator + photo));
            // 更新数据库照片信息
            userInfo.setPhoto(photo);
//            当前会话更新
            subject.getSession().setAttribute("userInfo", userInfo);
//            更新数据库
            userService.updateUserInfo(userInfo);
            System.out.println("更新成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "myaccount";


//        String filename = file.getOriginalFilename();
        // 定义上传文件保存路径
//        String path = filePath+"rotPhoto/";
//        // 新建文件
//        File filepath = new File(path, filename);
//        // 判断路径是否存在，如果不存在就创建一个
//        if (!filepath.getParentFile().exists()) {
//            filepath.getParentFile().mkdirs();
//        }
//
    }
}