package cn.xuyinyin.magic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 启动类
 *
 * @author xjw
 */
@RestController
@SpringBootApplication
public class XjwApplication {

    public static void main(String[] args) {
        SpringApplication.run(XjwApplication.class, args);
    }

    @GetMapping("/")
    public String test() {
        return "Hello World";
    }

}
