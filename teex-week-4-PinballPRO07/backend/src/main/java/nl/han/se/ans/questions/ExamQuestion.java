package nl.han.se.ans.questions;

public class ExamQuestion {
    private long id;
    private String title;
    private String type;
    private String description;
    private boolean published;

    public ExamQuestion(long id, String title, String description, QuestionType questionType, boolean published) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.published = published;
        this.type = questionType.getText();
    }

    public ExamQuestion() {
    }

    public ExamQuestion(String title, String description, QuestionType questionType, boolean published) {
        this.title = title;
        this.description = description;
        this.published = published;
        this.type = questionType.getText();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

