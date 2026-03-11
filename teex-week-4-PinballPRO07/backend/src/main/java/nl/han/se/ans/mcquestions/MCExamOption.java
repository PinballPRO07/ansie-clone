package nl.han.se.ans.mcquestions;

public class MCExamOption {
    private long id;
    private String option;
    private boolean correct;

    public MCExamOption(long id, String option, boolean correct) {
        this.id = id;
        this.option = option;
        this.correct = correct;
    }

    public MCExamOption() {
    }

    public MCExamOption(String option, boolean correct) {
        this.option = option;
        this.correct = correct;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
}
