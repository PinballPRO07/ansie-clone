package nl.han.se.ans.mongoquestions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/examQuestions")
public class MongoExamQuestionController {

    @Autowired
    private MongoExamQuestionRepository repository;

    // GET /api/examQuestions           - all questions
    // GET /api/examQuestions?type=mc   - filtered by type
    @GetMapping
    public ResponseEntity<List<MongoExamQuestion>> getAll(
            @RequestParam(required = false) String type) {

        List<MongoExamQuestion> questions = (type != null)
                ? repository.findByType(type)
                : repository.findAll();

        if (questions.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    // GET /api/examQuestions/published
    @GetMapping("/published")
    public ResponseEntity<List<MongoExamQuestion>> getPublished() {
        List<MongoExamQuestion> questions = repository.findByPublished(true);
        if (questions.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    // GET /api/examQuestions/{id}
    @GetMapping("/{id}")
    public ResponseEntity<MongoExamQuestion> getById(@PathVariable String id) {
        Optional<MongoExamQuestion> question = repository.findById(id);
        return question
                .map(q -> new ResponseEntity<>(q, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // POST /api/examQuestions
    @PostMapping
    public ResponseEntity<MongoExamQuestion> create(@RequestBody MongoExamQuestion question) {
        question.setPublished(false);
        return new ResponseEntity<>(repository.save(question), HttpStatus.CREATED);
    }

    // PUT /api/examQuestions/{id}
    @PutMapping("/{id}")
    public ResponseEntity<MongoExamQuestion> update(
            @PathVariable String id,
            @RequestBody MongoExamQuestion question) {

        if (!repository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        question.setId(id);
        return new ResponseEntity<>(repository.save(question), HttpStatus.OK);
    }

    // DELETE /api/examQuestions/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        if (!repository.existsById(id)) {
            return new ResponseEntity<>("Question not found with id=" + id, HttpStatus.NOT_FOUND);
        }
        repository.deleteById(id);
        return new ResponseEntity<>("Question deleted successfully.", HttpStatus.OK);
    }

    // DELETE /api/examQuestions
    @DeleteMapping
    public ResponseEntity<String> deleteAll() {
        long count = repository.count();
        repository.deleteAll();
        return new ResponseEntity<>("Deleted " + count + " question(s).", HttpStatus.OK);
    }
}