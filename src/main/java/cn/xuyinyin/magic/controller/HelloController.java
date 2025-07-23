package cn.xuyinyin.magic.controller;

import cn.xuyinyin.magic.service.HelloService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello Controller
 *
 * @author xjw
 */
@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class HelloController {

    private final HelloService helloService;

    @GetMapping("/hello")
    public String sayHello() {
        log.info("Hello endpoint accessed");
        return helloService.getGreetingMessage();
    }
}