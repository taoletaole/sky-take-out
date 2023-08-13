package com.sky.controller.admin;


import com.sky.constant.MessageConstant;
import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

/**
 * 通用接口
 */
@RestController
@RequestMapping("admin/common")
@Api(tags="通用接口")
@Slf4j
public class CommonController {
//    @Autowired
//    private AliOssUtil aliOssUtil;
//    /**
//     * 文件上传
//     * @param file
//     * @return
//     */
//    @PostMapping("/upload")
//    @ApiOperation("文件上传")
//    public Result<String> upload(MultipartFile file){
//        log.info("文件上传：{}",file);
//
//        try {
//            //原始文件名
//            String originalFilename = file.getOriginalFilename();
//            //截取原始文件名的后缀 .png
//            String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
//            //构造新文件名称
//            String objectName=UUID.randomUUID().toString() + extension;
//            //文件的请求路径
//            String filePath=aliOssUtil.upload(file.getBytes(),objectName);
//            return Result.success(filePath);
//        } catch (IOException e) {
//            log.error("文件上传失败：{}",e);
//        }
//
//        return Result.error(MessageConstant.UPLOAD_FAILED);
//    }
/**
 * 文件上传
 * @param file
 * @return
 * @throws java.io.IOException
 */


@PostMapping("/upload")
@ApiOperation("文件上传")
public Result<String> upload(MultipartFile file) {
        log.info("文件上传：{}",file);
        try {
        //获取原始文件名字 .jpg
        String originalFilename = file.getOriginalFilename();

        //构造唯一文件名（不能重复） uuid（通用唯一识别码）
        int index = originalFilename.lastIndexOf(".");
        String extname = originalFilename.substring(index);
        String newFileName = UUID.randomUUID().toString() + extname;
        log.info("新的文件名：{}", newFileName);
        //将接收到的文件存储到服务器的磁盘目录中E:\images
        file.transferTo(new File("E:\\images\\" + newFileName));
        String filePath = "E:\\images\\";
        return Result.success(filePath);
        }catch (Exception e){
        log.error("文件上传失败:{}",e);
        }
        return Result.error(MessageConstant.UPLOAD_FAILED);
        }
}
//}
