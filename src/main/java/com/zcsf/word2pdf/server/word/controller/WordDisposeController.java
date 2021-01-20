package com.zcsf.word2pdf.server.word.controller;

import com.zcsf.word2pdf.common.WordDisposeDTO;
import com.zcsf.word2pdf.server.word.service.WordDisposeService;
import com.zjyc.zcsf.common.protocol.Response;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotEmpty;

/**
 * @Author ZXC
 * @Date 2021/1/20 17:00
 * @description
 */
@RestController
public class WordDisposeController {

    @Resource
    private WordDisposeService wordDisposeService;

    @GetMapping("/disposeWord")
//    public Response disposeWord(@RequestBody WordDisposeDTO wordDisposeDTO){
    public Response disposeWord(@NotEmpty(message = "授信编号编号为空") String FileToken){
        return wordDisposeService.disposeWord(FileToken);
//        return wordDisposeService.disposeWord(wordDisposeDTO);
    }
}
