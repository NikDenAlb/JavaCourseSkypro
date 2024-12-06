package examinerservice.service;

import examinerservice.domain.Question;
import examinerservice.exception.AtLeastOneQuestionException;
import examinerservice.exception.NotEnoughQuestionsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ExaminerServiceImpl implements ExaminerService {
    private final Random random = new Random();
    private final QuestionService questionService;

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > questionService.getAll().size()) {
            throw new NotEnoughQuestionsException("You asked too many questions");
        } else if (amount < 1) {
            throw new AtLeastOneQuestionException("You need to ask at least one question");
        } else if (amount == questionService.getAll().size()) {
            return questionService.getAll();
        } else {
            Set<Question> out = new HashSet<>();
            do {
                while (!out.add(questionService.getRandomQuestion())) ;
                amount--;
            } while (amount != 0);

            return out;
        }
    }
}
