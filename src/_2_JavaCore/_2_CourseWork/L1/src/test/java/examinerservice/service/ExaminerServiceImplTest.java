package examinerservice.service;

import examinerservice.domain.Question;
import examinerservice.exception.AtLeastOneQuestionException;
import examinerservice.exception.NotEnoughQuestionsException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.List;

import static examinerservice.QuestionConstants.EXAM_QUESTION_LIST;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private QuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    private final List<Question> questions = EXAM_QUESTION_LIST;

    @Test
    void testGetQuestionsReturnsSetOfQuestions() {
        when(questionService.getAll()).thenReturn(questions);
        when(questionService.getRandomQuestion()).thenReturn(questions.get(0), questions.get(1));

        Collection<Question> result = examinerService.getQuestions(2);

        assertEquals(2, result.size());
        assertTrue(result.contains(questions.get(0)));
        assertTrue(result.contains(questions.get(1)));
    }

    @Test
    void testGetQuestionsThrowsNotEnoughQuestionsException() {
        when(questionService.getAll()).thenReturn(questions);

        NotEnoughQuestionsException thrown = assertThrows(NotEnoughQuestionsException.class, () -> examinerService.getQuestions(5));

        assertEquals("You asked too many questions", thrown.getMessage());
    }

    @Test
    void testGetQuestionsThrowsAtLeastOneQuestionException() {
        when(questionService.getAll()).thenReturn(questions);

        AtLeastOneQuestionException thrown = assertThrows(AtLeastOneQuestionException.class, () -> examinerService.getQuestions(0));

        assertEquals("You need to ask at least one question", thrown.getMessage());
    }

    @Test
    void testGetQuestionsReturnsAllQuestionsWhenAmountEqualsAll() {
        when(questionService.getAll()).thenReturn(questions);

        Collection<Question> result = examinerService.getQuestions(3);

        assertEquals(3, result.size());
        assertTrue(result.containsAll(questions));
    }
}
