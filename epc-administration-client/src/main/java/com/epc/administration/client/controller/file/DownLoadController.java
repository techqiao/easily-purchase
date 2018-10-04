package com.epc.administration.client.controller.file;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.*;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * <p>Description : 运营商服务
 * <p>Date : 2018-09-11  22:31
 * <p>@author : wjq
 */
@Api(value = "文件下载" ,tags = "文件下载")
@RestController
@RequestMapping("/download")
public class DownLoadController {
    public static final String ROOT = "D:\\HttpFiles\\";

    @ApiOperation(value = "文件下载",tags = "文件下载")
    @PostMapping(value ="getDownload" )
    public void getDownload(@RequestParam("filePath") String filePath, HttpServletRequest request, HttpServletResponse response) {

        String fullPath = ROOT + filePath;
        File downloadFile = new File(fullPath);

        ServletContext context = request.getServletContext();

        String mimeType = context.getMimeType(fullPath);
        if (mimeType == null) {
            mimeType = "application/octet-stream";
            System.out.println("context getMimeType is null");
        }
        System.out.println("MIME type: " + mimeType);

        response.setContentType(mimeType);
        response.setContentLength((int) downloadFile.length());

        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"",
                downloadFile.getName());
        response.setHeader(headerKey, headerValue);

        try {
            InputStream myStream = new FileInputStream(fullPath);
            IOUtils.copy(myStream, response.getOutputStream());
            response.flushBuffer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
