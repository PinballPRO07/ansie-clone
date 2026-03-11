package nl.han.se.ans.mcquestions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MCExamQuestionController {


    @Autowired
    MCExamQuestionRepository mcExamQuestionRepository;

    @GetMapping("/examQuestions/mc")
    public ResponseEntity<List<MCExamQuestion>> getAllMCExamQuestions(@RequestParam(required = false) String title) {
        List<MCExamQuestion> mcExamQuestions = new ArrayList<>();
        mcExamQuestionRepository.findAll().forEach(mcExamQuestions::add);
        if (mcExamQuestions.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(mcExamQuestions, HttpStatus.OK);
    }

    @GetMapping("/examQuestions/mc/{id}")
    public ResponseEntity<MCExamQuestion> getOpenExamQuestionById(@PathVariable("id") long id) {
        MCExamQuestion mcExamQuestion = mcExamQuestionRepository.findById(id);
        if (mcExamQuestion != null) {
            return new ResponseEntity<>(mcExamQuestion, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
