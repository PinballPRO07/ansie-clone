package nl.han.se.ans.mcquestions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JdbcMCExamQuestionRepository implements MCExamQuestionRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static final RowMapper<MCExamQuestion> mcExamQuestionRowMapper = BeanPropertyRowMapper.newInstance(MCExamQuestion.class);
    public static final RowMapper<MCExamOption> mcExamOptionRowMapper = BeanPropertyRowMapper.newInstance(MCExamOption.class);
    public List<MCExamQuestion> findAll() {
        return jdbcTemplate.query("SELECT * from mcexamquestions, mcexamoptions where mcexamquestions.id = mcexamoptions.mcexamquestionid", rs -> {
            return getMcExamQuestions(rs);
        });
    }

    @Override
    public MCExamQuestion findById(long id) {
        List<MCExamQuestion> examQuestions = jdbcTemplate.query("SELECT * from mcexamquestions, mcexamoptions where mcexamquestions.id=? AND mcexamquestions.id = mcexamoptions.mcexamquestionid", rs -> {
            return getMcExamQuestions(rs);
        }, id);
        if (!examQuestions.isEmpty()) return examQuestions.get(0);
        else return null;
    }

    private static List<MCExamQuestion> getMcExamQuestions(ResultSet rs) throws SQLException {
        List<MCExamQuestion> examQuestions = new ArrayList<>();
        Long mcExamQuestionId = null;
        MCExamQuestion currentQuestion = null;
        int questionIdx = 0;
        int optionIdx = 0;
        while (rs.next()) {
            if (currentQuestion == null || !mcExamQuestionId.equals(rs.getLong("mcexamquestionid"))) {
                mcExamQuestionId = rs.getLong("mcexamquestionid");
                currentQuestion = mcExamQuestionRowMapper.mapRow(rs, questionIdx++);
                currentQuestion.setId(mcExamQuestionId);
                optionIdx = 0;
                examQuestions.add(currentQuestion);
            }
            currentQuestion.getOptions().add(mcExamOptionRowMapper.mapRow(rs, optionIdx++));
        }
        return examQuestions;
    }
}
