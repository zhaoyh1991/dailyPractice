package com.zyh.daily.MyDistributeFileSystem;

import java.net.InetAddress;

/**
 * Created by zhaoyh on 2017/6/16.
 */
public class BlockInfo {
    private int blockId;//文件块编码
    private String fileName;//文件名称
    private String location;//文件位置
    private InetAddress inetAddress;//文件所在机器

    public int getBlockId() {
        return blockId;
    }

    public void setBlockId(int blockId) {
        this.blockId = blockId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public InetAddress getInetAddress() {
        return inetAddress;
    }

    public void setInetAddress(InetAddress inetAddress) {
        this.inetAddress = inetAddress;
    }
}
