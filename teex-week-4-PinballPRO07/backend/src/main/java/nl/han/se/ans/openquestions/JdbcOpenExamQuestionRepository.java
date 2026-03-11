package nl.han.se.ans.openquestions;

import nl.han.se.ans.openquestions.OpenExamQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcOpenExamQuestionRepository implements OpenExamQuestionRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(OpenExamQuestion openExamQuestion) {
        return jdbcTemplate.update("INSERT INTO openexamquestions (title, description, published) VALUES(?,?,?)",
                new Object[] { openExamQuestion.getTitle(), openExamQuestion.getDescription(), openExamQuestion.isPublished() });
    }

    @Override
    public int update(OpenExamQuestion openExamQuestion) {
        return jdbcTemplate.update("UPDATE openexamquestions SET title=?, description=?, published=? WHERE id=?",
                new Object[] { openExamQuestion.getTitle(), openExamQuestion.getDescription(), openExamQuestion.isPublished(), openExamQuestion.getId() });

    }

    @Override
    public OpenExamQuestion findById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM openexamquestions WHERE id=?",
                BeanPropertyRowMapper.newInstance(OpenExamQuestion.class), id);
    }

    @Override
    public int deleteById(Long id) {
        return jdbcTemplate.update("DELETE FROM openexamquestions WHERE id=?", id);
    }

    @Override
    public List<OpenExamQuestion> findAll() {
        return jdbcTemplate.query("SELECT * from openexamquestions", BeanPropertyRowMapper.newInstance(OpenExamQuestion.class));
    }

    @Override
    public List<OpenExamQuestion> findByPublished(boolean published) {
        return jdbcTemplate.query("SELECT * from openexamquestions WHERE published=?",
                BeanPropertyRowMapper.newInstance(OpenExamQuestion.class), published);
    }

    @Override
    public List<OpenExamQuestion> findByTitleContaining(String title) {
        return jdbcTemplate.query("SELECT * from openexamquestions WHERE title LIKE '%" + title + "%'", BeanPropertyRowMapper.newInstance(OpenExamQuestion.class));
    }

    @Override
    public int deleteAll() {
        return jdbcTemplate.update("DELETE from openexamquestions");
    }
}
