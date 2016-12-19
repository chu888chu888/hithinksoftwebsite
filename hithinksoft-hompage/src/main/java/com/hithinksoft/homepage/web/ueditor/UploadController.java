package com.hithinksoft.homepage.web.ueditor;

import com.hithinksoft.homepage.ueditor.ActionEnter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/ueditor")
public class UploadController {

    @RequestMapping("/config")
    public void config(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html");
        String rootPath=request.getServletContext().getRealPath("/");
        try {
            String exec = new ActionEnter(request, rootPath).exec();
            PrintWriter writer = response.getWriter();
            writer.write(exec);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加单个图片回显.
     */

    @RequestMapping(value = "/image")
    public void addCategory(HttpServletRequest request,
                            HttpServletResponse actioncontext) {
        String re;
        String sub = null;
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile imgFile1 = multipartRequest.getFile("file");// 获取上次文件名
        List<String> fileTypes = new ArrayList<>();
        fileTypes.add("jpg");
        fileTypes.add("jpeg");
        fileTypes.add("bmp");
        fileTypes.add("gif");
        fileTypes.add("ioc");
        fileTypes.add("png");
        if (!(imgFile1.getOriginalFilename() == null || "".equals(imgFile1
                .getOriginalFilename()))) {
            String uploadfile = request.getServletContext().getRealPath(
                    "imgfile");
            File file1 = this.getFile(imgFile1, uploadfile, fileTypes);
            re = file1.toString();
            sub = re.substring(re.lastIndexOf("\\") + 1);
        }
        actioncontext.setContentType("text/html");
        PrintWriter out;
        try {
            out = actioncontext.getWriter();
            out.println("/imgfile/" + sub);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private File getFile(MultipartFile imgFile, String brandName, List fileTypes) {
        String fileName = imgFile.getOriginalFilename();
        // 获取上传文件类型的扩展名,先得到.的位置，再截取从.的下一个位置到文件的最后，最后得到扩展名
        String ext = fileName.substring(fileName.lastIndexOf(".") + 1,
                fileName.length());
        ext = ext.toLowerCase();

        File file = null;
        if (fileTypes.contains(ext)) { // 如果扩展名属于允许上传的类型，则创建文件
            file = this.createFolder(brandName, fileName);
            try {
                imgFile.transferTo(file); // 保存上传的文件
            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    private File createFolder(String brandName, String fileName) {
        File file;
        File firstFolder = new File(brandName);
        String suffix = fileName.substring(fileName.lastIndexOf('.'));
        String prefix = System.currentTimeMillis() + "";
        String newfileName = prefix + suffix;
        // 如果一级文件夹存在，则检测二级文件夹
        if (firstFolder.exists()) file = new File(brandName + "\\" + newfileName);
        else { // 如果一级不存在，则创建一级文件夹
            firstFolder.mkdir();
            file = new File(brandName + "\\" + newfileName);
        }
        return file;
    }
}
