package com.zcsf.word2pdf.feign;

import com.zjyc.zcsf.api.manage.api.third.file.FileApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * desc: FileApiService
 *
 * @author hrl
 * @date 2020/5/21 14:42
 **/
@FeignClient("manage-service")
public interface FileApiService extends FileApi {
}
