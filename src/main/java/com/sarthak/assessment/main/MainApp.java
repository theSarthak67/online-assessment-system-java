package com.sarthak.assessment.main;

import com.sarthak.assessment.dao.*;
import com.sarthak.assessment.model.*;
import com.sarthak.assessment.service.EvaluationService;

import java.time.LocalDateTime;
import java.util.*;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        UserDao userDao = new UserDao();
        ExamDao examDao = new ExamDao();
        StudentAnswerDao answerDao = new StudentAnswerDao();
        QuestionDao questionDao = new QuestionDao();
        ExamAttemptDao attemptDao = new ExamAttemptDao();
        EvaluationService evaluationService = new EvaluationService();

        System.out.println("===== ONLINE ASSESSMENT SYSTEM =====");

        // LOGIN
        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Password: ");
        String password = sc.nextLine();

        User student = userDao.login(email, password);

        if (student == null || !"STUDENT".equals(student.getRole())) {
            System.out.println("Invalid login or not a student.");
            sc.close();
            return;
        }

        System.out.println("\nWelcome " + student.getName());

        //SHOW EXAMS
        List<Exam> exams = examDao.getAllExams();
        if (exams.isEmpty()) {
            System.out.println("No exams available.");
            sc.close();
            return;
        }

        System.out.println("\nAvailable Exams:");
        for (Exam e : exams) {
            System.out.println(e.getExamId() + " - " + e.getExamTitle()
                    + " (" + e.getDurationMinutes() + " mins)");
        }

        // SELECT EXAM
        System.out.print("\nEnter Exam ID to start: ");
        int examId = sc.nextInt();

        //START EXAM
        ExamAttempt attempt = new ExamAttempt(
                student.getUserId(),
                examId,
                LocalDateTime.now(),
                "IN_PROGRESS"
        );

        int attemptId = attemptDao.startExam(attempt);
        System.out.println("\nExam Started!\n");

        //LOAD QUESTIONS
        List<Question> questions = questionDao.getQuestionsByExamId(examId);
        Map<Integer, Character> answers = new HashMap<>();

        // 6️⃣ ASK QUESTIONS
        for (Question q : questions) {
            System.out.println("\nQ" + q.getQuestionId() + ": " + q.getQuestionText());
            System.out.println("A. " + q.getOptionA());
            System.out.println("B. " + q.getOptionB());
            System.out.println("C. " + q.getOptionC());
            System.out.println("D. " + q.getOptionD());

            System.out.print("Your answer (A/B/C/D): ");
            char ans = sc.next().toUpperCase().charAt(0);

            answers.put(q.getQuestionId(), ans);

         // determine correctness
         boolean isCorrect = (ans == q.getCorrectOption());

         // save to DB
         StudentAnswer studentAnswer = new StudentAnswer(
                 attemptId,
                 q.getQuestionId(),
                 ans
         );
         studentAnswer.setCorrect(isCorrect);

         answerDao.saveAnswer(studentAnswer);

        }

        // SUBMIT EXAM
        attemptDao.finishExam(attemptId, "COMPLETED");

        // EVALUATE
        evaluationService.evaluateExam(attemptId, examId, answers);

        System.out.println("\nExam submitted successfully!");
        System.out.println("Result generated.");

        sc.close();
    }
}
