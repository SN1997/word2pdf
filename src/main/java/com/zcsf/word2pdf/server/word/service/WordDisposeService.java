package com.zcsf.word2pdf.server.word.service;

import com.zcsf.word2pdf.common.WordDisposeDTO;
import com.zcsf.word2pdf.feign.FileApiService;
import com.zjyc.zcsf.api.manage.dto.third.file.FileDTO;
import com.zjyc.zcsf.common.protocol.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import javax.annotation.Resource;

/**
 * @Author ZXC
 * @Date 2021/1/20 17:03
 * @description
 */
@Service
public class WordDisposeService {

    private static Logger log = LoggerFactory.getLogger(WordDisposeService.class);

    @Resource
    private FileApiService fileApiService;

//    public Response disposeWord(WordDisposeDTO wordDisposeDTO){
    public Response disposeWord(String fileToken){
        //获取文件下载文件写入本次磁盘
        byte[] bytes = null;
//        FileDTO file  = wordDisposeDTO.getFileDTO();
//        Response<FileDTO> fileVOResponse = fileApiService.downloadFile(file.getFileToken());
        Response<FileDTO> fileVOResponse = fileApiService.downloadFile(fileToken);
        if (fileVOResponse.isOk()){
            FileDTO downFileVo = fileVOResponse.getBody();
            bytes = Base64Utils.decodeFromString(downFileVo.getFileEntity());
        }

        return null;
    }
}
