package com.simple.hyper.system.controller;

import com.simple.hyper.common.base.Response;
import com.simple.hyper.system.service.IUploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * .
 *
 * @author SinceNovember
 * @date 2022/12/27
 */
@Slf4j
@RestController
@RequestMapping("/api/upload")
public class UploadController {

    @Resource
    private IUploadService uploadService;

    @PostMapping("img")
    public Response uploadImg(@RequestParam("file") MultipartFile file) {
        return Response.ok(uploadService.uploadImg(file));
    }
}
