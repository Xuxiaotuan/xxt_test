package cn.xuyinyin.magic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 启动类
 *
 * @author xjw
 */
@Slf4j
@RestController
@SpringBootApplication
@EnableJpaRepositories
public class XjwApplication {

    public static void main(String[] args) {
        SpringApplication.run(XjwApplication.class, args);
    }

    @GetMapping("/")
    public String test() {
        log.info("Hello World");
        return "Hello World";
    }

}
