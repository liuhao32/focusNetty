package org.moon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YCKJ3275
 */
@SpringBootApplication(scanBasePackages = "org.moon")
@MapperScan("org.moon.data.mapper")
@Configuration
@RestController
public class NettyApplication {

    /**
     * 启动main方法
     * @param args 参数
     */
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(NettyApplication.class);
        application.run(args);
    }
}
