package cn.xuyinyin.magic.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Example service class
 *
 * @author xjw
 */
@Slf4j
@Service
public class HelloService {

    public String getGreetingMessage() {
        log.info("Getting greeting message");
        return "Welcome to our Spring Boot application!";
    }
}