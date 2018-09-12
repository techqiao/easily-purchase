package com.epc.common.util;

import org.apache.commons.net.ftp.FTPClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

/**
 * <p>Description : DateTimeUtil
 * <p>Date : 2018-09-09 20:45
 * <p>@Author : wjq
 */
public class FTPUtil {

    private static final Logger logger = LoggerFactory.getLogger(FTPUtil.class);
    /**
     * ftp服务器的地址
     */
    private static String ftpIp = "";
    /**
     * ftp服务器的用户名
     */
    private static String ftpUser = "";
    /**
     * ftp服务器的密码
     */
    private static String ftpPass = "";

    public FTPUtil(String ip, int port, String user, String pwd) {
        this.ip = ip;
        this.port = port;
        this.user = user;
        this.pwd = pwd;
    }

    /**
     * 上传多文件
     *
     * @param fileList
     * @return
     * @throws IOException
     */
    public static boolean uploadFile(List<File> fileList) throws IOException {
        FTPUtil ftpUtil = new FTPUtil(ftpIp, 21, ftpUser, ftpPass);
        logger.info("开始连接ftp服务器");
        boolean result = ftpUtil.uploadFile("img", fileList);
        logger.info("开始连接ftp服务器,结束上传,上传结果:{}");
        return result;
    }


    /**
     * 上传多文件
     *
     * @param remotePath 远程路径，文件夹
     * @param fileList   文件集合
     * @return
     * @throws IOException
     */
    private boolean uploadFile(String remotePath, List<File> fileList) throws IOException {
        boolean uploaded = true;
        FileInputStream fis = null;
        //连接FTP服务器
        if (connectServer(this.ip, this.port, this.user, this.pwd)) {
            try {
                //更改ftp会话的当前目录，切换文件夹
                ftpClient.changeWorkingDirectory(remotePath);
                //缓冲区
                ftpClient.setBufferSize(1024);
                ftpClient.setControlEncoding("UTF-8");
                //二进制文件类型，防止乱码
                ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
                //打开本地的被动模式
                ftpClient.enterLocalPassiveMode();
                for (File fileItem : fileList) {
                    fis = new FileInputStream(fileItem);
                    //存储文件,输入流，通过输入流开始存储文件
                    ftpClient.storeFile(fileItem.getName(), fis);
                }

            } catch (IOException e) {
                logger.error("上传文件异常", e);
                uploaded = false;
                e.printStackTrace();
            } finally {
                //释放资源
                fis.close();
                ftpClient.disconnect();
            }
        }
        return uploaded;
    }


    /**
     * 连接ftp服务器
     *
     * @param ip
     * @param port
     * @param user
     * @param pwd
     * @return
     */
    private boolean connectServer(String ip, int port, String user, String pwd) {
        boolean isSuccess = false;
        ftpClient = new FTPClient();
        try {
            ftpClient.connect(ip);
            isSuccess = ftpClient.login(user, pwd);
        } catch (IOException e) {
            logger.error("连接FTP服务器异常", e);
        }
        return isSuccess;
    }


    private String ip;
    private int port;
    private String user;
    private String pwd;
    /**
     * ftp连接工具
     */
    private FTPClient ftpClient;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public FTPClient getFtpClient() {
        return ftpClient;
    }

    public void setFtpClient(FTPClient ftpClient) {
        this.ftpClient = ftpClient;
    }
}
