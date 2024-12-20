package calculator.service.impl;

import calculator.exception.CannotDivideByZeroException;
import calculator.service.CalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    public String plus(int num1, int num2) {
        return num1 + "+" + num2 + "=" + (num1 + num2);
    }

    public String minus(int num1, int num2) {
        return num1 + "-" + num2 + "=" + (num1 - num2);
    }

    public String multiply(int num1, int num2) {
        return num1 + "*" + num2 + "=" + (num1 * num2);
    }

    public String divide(int num1, int num2) {
        if (num2 == 0) {
            throw new CannotDivideByZeroException("Cannot divide by zero");
        }
        return num1 + "/" + num2 + "=" + ((double) num1 / num2);
    }
}
