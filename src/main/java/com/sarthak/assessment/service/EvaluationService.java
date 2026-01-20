package com.sarthak.assessment.service;

import com.sarthak.assessment.dao.QuestionDao;
import com.sarthak.assessment.dao.ResultDao;
import com.sarthak.assessment.model.Question;
import com.sarthak.assessment.model.Result;

import java.util.List;
import java.util.Map;

public class EvaluationService {

    private final QuestionDao questionDao = new QuestionDao();
    private final ResultDao resultDao = new ResultDao();

    // answers: questionId -> selectedOption
    public void evaluateExam(int attemptId, int examId,
                             Map<Integer, Character> answers) {

        List<Question> questions = questionDao.getQuestionsByExamId(examId);

        int totalMarks = 0;
        int scoredMarks = 0;

        for (Question q : questions) {
            totalMarks += q.getMarks();

            char selected = answers.getOrDefault(q.getQuestionId(), 'X');

            if (selected == q.getCorrectOption()) {
                scoredMarks += q.getMarks();
            }
        }

        double percentage = (scoredMarks * 100.0) / totalMarks;
        String passFail = percentage >= 40 ? "PASS" : "FAIL";

        Result result = new Result(attemptId, scoredMarks, percentage, passFail);
        resultDao.saveResult(result);
    }
}
