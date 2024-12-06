package examinerservice.service;

import examinerservice.domain.Question;
import examinerservice.exception.NoQuestionsException;
import examinerservice.exception.NullQuestionIsNotAllowedException;
import examinerservice.exception.QuestionAlreadyExistsException;
import examinerservice.exception.QuestionIsNotInTheBookException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class JavaQuestionService implements QuestionService {
    public final Set<Question> questions = new HashSet<>();

    @Override
    public Question add(String question, String answer) {
        if (question == null||answer == null) {
            throw new NullQuestionIsNotAllowedException("Question can't be null");
        }
        Question newQuestion = new Question(question, answer);
        if (questions.add(newQuestion)) {
            return newQuestion;
        } else {
            throw new QuestionAlreadyExistsException("Question already exists in the questionsBook");
        }
    }

    @Override
    public Question add(Question question) {
        if (question == null) {
            throw new NullQuestionIsNotAllowedException("Question is null");
        }
        if (questions.add(question)) {
            return question;
        } else {
            throw new QuestionAlreadyExistsException("Question already exists in the questionsBook");
        }
    }

    @Override
    public Question remove(Question question) {
        if (questions.remove(question)) {
            return question;
        } else {
            throw new QuestionIsNotInTheBookException("Question doesn't exists in the questionsBook");
        }
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }

    @Override
    public Question getRandomQuestion() {
        if (questions.isEmpty()) {
            throw new NoQuestionsException("There is no questions");
        }
        return (Question) questions.toArray()[new Random().nextInt(questions.size())];
    }
}
