package examinerservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class NotEnoughQuestionsException extends IllegalArgumentException {
    public NotEnoughQuestionsException(String message) {
        super(message);
    }
}
