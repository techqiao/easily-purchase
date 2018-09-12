package com.epc.administration.client.controller.file;

import com.alibaba.fastjson.JSON;
import com.epc.common.Result;
import com.epc.common.util.DateTimeUtil;
import com.epc.common.util.FTPUtil;
import com.epc.common.util.RandomNumberGenerator;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * <p>Description : 运营商服务
 * <p>Date : 2018-09-11  22:50
 * <p>@author : wjq
 */
@RestController
@RequestMapping("/upload")
public class UploadController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UploadController.class);

    public static final String ROOT = "E:\\HttpFiles\\";

    @PostMapping("/files")
    public String fileUpload(@RequestParam("file") MultipartFile multipartFile,
                             @RequestParam("dirName") String dirName,
                             @RequestParam("fileName") String fileName) {
        //空参数的判断
        if (dirName == null || fileName == null) {
            return JSON.toJSONString(Result.error("文件夹名或者文件名不能为空"));
        }

        //设置相对目录 文件存储的目录 格式为根目录 + 相对目录 + (文件类型目录 + dir目录)
        String relativePath = dirName + "\\";
        String localPath = ROOT + relativePath;

        //给文件构造名称 格式为 文件名_timestamp_uuid(8位) 逗号分割开
        String original = StringUtils.substringBeforeLast(fileName, ".");
        String suffix = StringUtils.substringAfterLast(fileName, ".");
        //保证唯一性
        String serverFileName =
                original + DateTimeUtil.dateToStr(new Date(), "_yyyyMMddHHmmss_") +
                        RandomNumberGenerator.uuid8Bit() + "." + suffix;

        //日志打印,将文件的相关信息记录在日志中,info级别
        recordFileDetail(fileName, localPath, original, suffix, serverFileName);

        //上传文件,参数分别是文件,文件原始名,文件服务器名,相对路径,绝对路径
        return uploadFile(multipartFile, fileName, serverFileName, relativePath, localPath);
    }


    /**
     * 上传文件
     *
     * @param multipartFile  文件
     * @param fileName       文件原始名
     * @param serverFileName 文件服务器名
     * @param relativePath   相对路径
     * @param localPath      绝对路径
     * @return  格式的json字符串
     */
    private String uploadFile(MultipartFile multipartFile, String fileName, String serverFileName, String relativePath, String localPath) {
        File createdFile = new File(localPath);
        // 判断目标文件所处的目录是否存在,不存在先创建
        if (!createdFile.exists()) {
            //设置写目录的权限
            createdFile.setWritable(true);
            LOGGER.info("目标文件目录不存在,创建文件夹 = {}", createdFile);
            if (!createdFile.mkdirs()) {
                LOGGER.info("创建目标目录文件失败!");
            }
        }

        //上传文件
        //localPath 绝对路径 serverFileName 文件服务器名
        File localFile = new File(localPath, serverFileName);
        try {
            //文件上传到本地
            multipartFile.transferTo(localFile);
            LOGGER.info("upload success ");
            //todo 将文件上传到ftp服务器
            FTPUtil.uploadFile(Lists.newArrayList(localFile));
            //删除
            localFile.delete();

            //构造返回给服务器的结果,分别有文件原始名,服务器文件名,以及在服务器的相对路径，绝对路径
            fileDataStruct dataStruct = new fileDataStruct(fileName, serverFileName, relativePath + serverFileName);
            return JSON.toJSONString(Result.success("文件上传成功", dataStruct));
        } catch (IOException e) {
            LOGGER.error("upload error ");
            e.printStackTrace();
            return JSON.toJSONString(Result.error("写入文件失败,文件上传失败"));
        }
    }

    /**
     * 日志打印
     *
     * @param fileName       文件名(带后缀)
     * @param localPath      绝对路径
     * @param original       文件名(不带后缀)
     * @param suffix         文件类型
     * @param serverFileName 服务器文件名
     */
    private void recordFileDetail(@RequestParam("fileName") String fileName, String localPath, String original, String suffix, String serverFileName) {
        LOGGER.info("localPath = {}", localPath);
        LOGGER.info("original FileName = {}", fileName);
        LOGGER.info("original = {}", original);
        LOGGER.info("suffix = {}", suffix);
        LOGGER.info("serverFileName = {}", serverFileName);
    }

}
