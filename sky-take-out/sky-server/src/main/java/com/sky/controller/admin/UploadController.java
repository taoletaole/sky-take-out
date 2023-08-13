//package com.sky.controller.admin;
//
//import com.sky.constant.MessageConstant;
//import com.sky.entity.Dish;
//import com.sky.result.Result;
//import com.sky.service.DishService;
//import io.netty.handler.codec.base64.Base64Encoder;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.UUID;
//
//@Slf4j
//@RequestMapping("admin/common")
//@RestController
//@Api(tags="通用接口")
//public class UploadController {
//    /**
//     * 文件上传
//     * @param file
//     * @return
//     * @throws IOException
//     */
//    @PostMapping("/upload")
//    @ApiOperation("文件上传")
//    public Result<String> upload(MultipartFile file) {
//        log.info("文件上传：{}",file);
//        try {
//            //获取原始文件名字 .jpg
//            String originalFilename = file.getOriginalFilename();
//
//            //构造唯一文件名（不能重复） uuid（通用唯一识别码）
//            int index = originalFilename.lastIndexOf(".");
//            String extname = originalFilename.substring(index);
//            String newFileName = UUID.randomUUID().toString() + extname;
//            log.info("新的文件名：{}", newFileName);
//            //将接收到的文件存储到服务器的磁盘目录中E:\images
//            file.transferTo(new File("E:\\images\\" + newFileName));
//            String filePath = "E:\\images\\";
//            return Result.success(filePath);
//        }catch (Exception e){
//            log.error("文件上传失败:{}",e);
//        }
//        return Result.error(MessageConstant.UPLOAD_FAILED);
//    }
//
//}
