package com.zyh.daily.MyDistributeFileSystem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaoyh on 2017/6/16.
 */
public class FileInfo {
    private String fileName;
    private int size;
    private List<BlockInfo> blockInfos=new ArrayList<>();

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<BlockInfo> getBlockInfos() {
        return blockInfos;
    }

    public void setBlockInfos(List<BlockInfo> blockInfos) {
        this.blockInfos = blockInfos;
    }
}
