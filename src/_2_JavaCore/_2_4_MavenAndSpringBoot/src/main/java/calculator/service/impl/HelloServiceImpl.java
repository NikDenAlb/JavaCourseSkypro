package calculator.service.impl;

import calculator.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {
    public String hello() {
        return "Hello";
    }

    public String helloAnswer(String name) {
        return "Hello " + name;
    }
}
