package nl.han.se.ans.openquestions;

import nl.han.se.ans.openquestions.OpenExamQuestionRepository;
import nl.han.se.ans.openquestions.OpenExamQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class OpenExamQuestionController {
    @Autowired
    OpenExamQuestionRepository openExamQuestionRepository;

    @GetMapping("/examQuestions/open")
    public ResponseEntity<List<OpenExamQuestion>> getAllOpenExamQuestions(@RequestParam(required = false) String title) {
        List<OpenExamQuestion> openExamQuestions = new ArrayList<>();

        if (title == null)
            openExamQuestionRepository.findAll().forEach(openExamQuestions::add);
        else
            openExamQuestionRepository.findByTitleContaining(title).forEach(openExamQuestions::add);

        if (openExamQuestions.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(openExamQuestions, HttpStatus.OK);

    }
    
    @GetMapping("/examQuestions/open/{id}")
    public ResponseEntity<OpenExamQuestion> getOpenExamQuestionById(@PathVariable("id") long id) {
        OpenExamQuestion openExamQuestion = openExamQuestionRepository.findById(id);

        if (openExamQuestion != null) {
            return new ResponseEntity<>(openExamQuestion, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/examQuestions/open")
    public ResponseEntity<String> createOpenExamQuestion(@RequestBody OpenExamQuestion openExamQuestion) {
        openExamQuestionRepository.save(new OpenExamQuestion(openExamQuestion.getTitle(), openExamQuestion.getDescription(), false));
        return new ResponseEntity<>("ExamQuestion was created successfully.", HttpStatus.CREATED);

    }

    @PutMapping("/examQuestions/open/{id}")
    public ResponseEntity<String> updateOpenExamQuestion(@PathVariable("id") long id, @RequestBody OpenExamQuestion openExamQuestion) {
        OpenExamQuestion _Open_examQuestion = openExamQuestionRepository.findById(id);

        if (_Open_examQuestion != null) {
            _Open_examQuestion.setId(id);
            _Open_examQuestion.setTitle(openExamQuestion.getTitle());
            _Open_examQuestion.setDescription(openExamQuestion.getDescription());
            _Open_examQuestion.setPublished(openExamQuestion.isPublished());

            openExamQuestionRepository.update(_Open_examQuestion);
            return new ResponseEntity<>("ExamQuestion was updated successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Cannot find ExamQuestion with id=" + id, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/examQuestions/open/{id}")
    public ResponseEntity<String> deleteOpenExamQuestion(@PathVariable("id") long id) {
        int result = openExamQuestionRepository.deleteById(id);
        if (result == 0) {
            return new ResponseEntity<>("Cannot find ExamQuestion with id=" + id, HttpStatus.OK);
        }
        return new ResponseEntity<>("ExamQuestion was deleted successfully.", HttpStatus.OK);

    }

    @DeleteMapping("/examQuestions/open")
    public ResponseEntity<String> deleteAllOpenExamQuestions() {
        int numRows = openExamQuestionRepository.deleteAll();
        return new ResponseEntity<>("Deleted " + numRows + " ExamQuestion(s) successfully.", HttpStatus.OK);


    }

    @GetMapping("/examQuestions/open/published")
    public ResponseEntity<List<OpenExamQuestion>> findOpenExamQuestionsByPublished() {
        List<OpenExamQuestion> openExamQuestions = openExamQuestionRepository.findByPublished(true);

        if (openExamQuestions.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(openExamQuestions, HttpStatus.OK);
    }
}
