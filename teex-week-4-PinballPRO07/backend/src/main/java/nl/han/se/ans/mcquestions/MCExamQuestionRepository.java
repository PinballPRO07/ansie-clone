package nl.han.se.ans.mcquestions;

import java.util.List;

public interface MCExamQuestionRepository {
    List<MCExamQuestion> findAll();

    MCExamQuestion findById(long id);
}
