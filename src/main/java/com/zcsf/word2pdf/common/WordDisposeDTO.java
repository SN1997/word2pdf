package com.zcsf.word2pdf.common;

import com.zjyc.zcsf.api.manage.dto.third.file.FileDTO;
import com.zjyc.zcsf.common.entity.BaseDTO;

import java.util.Map;

/**
 * @Author ZXC
 * @Date 2021/1/20 17:04
 * @description
 */
public class WordDisposeDTO extends BaseDTO {
    /**
     * 原始文件
     */
    private FileDTO fileDTO;

    /**
     * 文本替换值
     */
    private Map<String,Object> paraMap;

    /**
     * 表格替换值
     */
    private Map<String,Object> tableMap;


    public FileDTO getFileDTO() {
        return fileDTO;
    }

    public void setFileDTO(FileDTO fileDTO) {
        this.fileDTO = fileDTO;
    }

    public Map<String, Object> getParaMap() {
        return paraMap;
    }

    public void setParaMap(Map<String, Object> paraMap) {
        this.paraMap = paraMap;
    }

    public Map<String, Object> getTableMap() {
        return tableMap;
    }

    public void setTableMap(Map<String, Object> tableMap) {
        this.tableMap = tableMap;
    }
}
