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
    private final Set<Question> questionsBook = new HashSet<>();

    @Override
    public Question add(String question, String answer) {
        if (question == null||answer == null) {
            throw new NullQuestionIsNotAllowedException("Question can't be null");
        }
        Question newQuestion = new Question(question, answer);
        if (questionsBook.add(newQuestion)) {
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
        if (questionsBook.add(question)) {
            return question;
        } else {
            throw new QuestionAlreadyExistsException("Question already exists in the questionsBook");
        }
    }

    @Override
    public Question remove(Question question) {
        if (questionsBook.remove(question)) {
            return question;
        } else {
            throw new QuestionIsNotInTheBookException("Question doesn't exists in the questionsBook");
        }
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questionsBook);
    }

    @Override
    public Question getRandomQuestion() {
        if (questionsBook.isEmpty()) {
            throw new NoQuestionsException("There is no questions");
        }
        Random a = new Random();
        return (Question) questionsBook.toArray()[a.nextInt(questionsBook.size())];
    }
}
