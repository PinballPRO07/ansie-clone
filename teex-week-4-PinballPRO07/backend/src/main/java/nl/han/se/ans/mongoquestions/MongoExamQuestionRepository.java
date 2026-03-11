package nl.han.se.ans.mongoquestions;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MongoExamQuestionRepository extends MongoRepository<MongoExamQuestion, String> {
    List<MongoExamQuestion> findByType(String type);
    List<MongoExamQuestion> findByPublished(boolean published);
    List<MongoExamQuestion> findByTitleContaining(String title);
}