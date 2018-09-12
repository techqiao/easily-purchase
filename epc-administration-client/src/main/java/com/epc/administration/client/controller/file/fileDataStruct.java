package com.epc.administration.client.controller.file;


/**
 * <p>Description : 运营商服务
 * <p>Date : 2018-09-11  22:40
 * <p>@author : wjq
 */
public class fileDataStruct {

    /**
     * 原始文件名
     */
    private String originalFileName;

    /**
     * 在服务器中的文件名
     */
    private String serverFileName;

    /**
     * 服务器中的文件路径
     */
    private String serverFilePath;

    public fileDataStruct() {
    }

    public fileDataStruct(String originalFileName, String serverFileName, String serverFilePath) {
        this.originalFileName = originalFileName;
        this.serverFileName = serverFileName;
        this.serverFilePath = serverFilePath;
    }

    public String getOriginalFileName() {
        return originalFileName;
    }

    public fileDataStruct setOriginalFileName(String originalFileName) {
        this.originalFileName = originalFileName;
        return this;
    }

    public String getServerFileName() {
        return serverFileName;
    }

    public fileDataStruct setServerFileName(String serverFileName) {
        this.serverFileName = serverFileName;
        return this;
    }

    public String getServerFilePath() {
        return serverFilePath;
    }

    public fileDataStruct setServerFilePath(String serverFilePath) {
        this.serverFilePath = serverFilePath;
        return this;
    }
}
