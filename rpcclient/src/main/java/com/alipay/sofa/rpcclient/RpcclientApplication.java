package com.alipay.sofa.rpcclient;

import com.alipay.sofa.facade.SampleModel;
import com.alipay.sofa.facade.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@SpringBootApplication
@Controller
@ImportResource("classpath*:spring/*.xml")
public class RpcclientApplication {
    @Autowired
    private SampleService sampleService;

    public static void main(String[] args) {
        SpringApplication.run(RpcclientApplication.class, args);
    }

    @ResponseBody
    @RequestMapping("/hello")
    public SampleModel hello() {
        return sampleService.hello();
    }
}
