package com.lwstudy.springcore.spel;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.net.MalformedURLException;

/**
 * @Author: LiuWang
 * @Created: 2018/8/23 21:34
 */
public class SpringResourceApplication {

    /**
     * 文件系统加载方式，给需要加载的文件加上前缀
     * file:D:\db.properties    file:/home/lw/db.properties
     * http://www.zhangsan.com/files/db.properties
     * classpath:com/lwstudy/db.properties  classpath:db.properties
     *
     * @param filename
     * @return
     */
    public static Resource loadResource(String filename) {
        if (filename == null || filename.length() == 0) {
            return null;
        }
        if (filename.startsWith("file")) {
            return new FileSystemResource(filename.substring("file:".length()));
        }
        if (filename.startsWith("classpath")) {
            return new ClassPathResource(filename.substring("classpath:".length()));
        }
        if (filename.startsWith("http")) {
            try {
                return new UrlResource(filename);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void main(String[] args) {
//        Resource resource = loadResource("file:D:\\db.properties");
//        Resource resource = loadResource("classpath:db.properties");
        Resource resource = loadResource("http://www.zhangsan.com/files/db.properties");
        System.out.println(resource);
    }

}
