package nl.han.se.ans.questions;

public enum QuestionType {
    MC("mc"),
    OPEN("open");

    private String text;

    QuestionType(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public static QuestionType fromString(String text) {
        for (QuestionType questionType : QuestionType.values()) {
            if (questionType.text.equalsIgnoreCase(text)) {
                return questionType;
            }
        }
        return null;
    }
}
