package examinerservice.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static examinerservice.CONSTANTS.EXPECTED_QUESTION_LIST;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private QuestionService javaQuestionServiceMock;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    void getQuestions() {
        when(javaQuestionServiceMock.getAll()).thenReturn(EXPECTED_QUESTION_LIST);

        assertTrue(EXPECTED_QUESTION_LIST.containsAll(examinerService.getQuestions(EXPECTED_QUESTION_LIST.size())));
        assertTrue(examinerService.getQuestions(EXPECTED_QUESTION_LIST.size()).containsAll(EXPECTED_QUESTION_LIST));

        assertTrue(EXPECTED_QUESTION_LIST.containsAll(examinerService.getQuestions(EXPECTED_QUESTION_LIST.size() - 1)));

        assertTrue(EXPECTED_QUESTION_LIST.containsAll(examinerService.getQuestions((EXPECTED_QUESTION_LIST.size() - 1) / 2)));

        assertTrue(EXPECTED_QUESTION_LIST.containsAll(examinerService.getQuestions(1)));
    }
}
