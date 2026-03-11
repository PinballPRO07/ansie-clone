package nl.han.se.ans.questions;

import nl.han.se.ans.mcquestions.MCExamQuestionRepository;
import nl.han.se.ans.openquestions.OpenExamQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class QuestionController {
    @Autowired
    OpenExamQuestionRepository openExamQuestionRepository;

    @Autowired
    MCExamQuestionRepository mcExamQuestionRepository;

    @GetMapping("/examQuestions/any")
    public ResponseEntity<List<ExamQuestion>> getAllExamQuestions() {
        List<ExamQuestion> examQuestions = new ArrayList<>();
        openExamQuestionRepository.findAll().forEach(examQuestions::add);
        mcExamQuestionRepository.findAll().forEach(examQuestions::add);

        if (examQuestions.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(examQuestions, HttpStatus.OK);
    }

    @GetMapping("/examQuestions/any/{id}")
    public ResponseEntity<ExamQuestion> getExamQuestionsById(@PathVariable("id") long id) {
        ExamQuestion mcExamQuestion = mcExamQuestionRepository.findById(id);
        if (mcExamQuestion != null) {
            return new ResponseEntity<>(mcExamQuestion, HttpStatus.OK);
        }
        ExamQuestion openExamQuestion = openExamQuestionRepository.findById(id);
        if (openExamQuestion != null) {
            return new ResponseEntity<>(openExamQuestion, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
