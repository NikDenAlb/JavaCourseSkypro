package calculator.service;

import org.springframework.stereotype.Service;

@Service
public interface HelloService {
    String hello();

    String helloAnswer(String name);
}
