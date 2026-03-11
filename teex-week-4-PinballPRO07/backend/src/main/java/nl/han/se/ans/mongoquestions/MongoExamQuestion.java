package nl.han.se.ans.mongoquestions;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

/**
 * Unified exam question document for MongoDB.
 *
 * This single document model demonstrates WHY MongoDB is ideal for exam questions:
 * - Open questions just need: title, description
 * - MC questions add: options (list of embedded objects)
 * - Ordering questions add: items with correctPosition
 * - Matching questions add: matchPairs with left/right values
 *
 * In a relational DB this would require 5+ tables and complex JOINs.
 * In MongoDB it is one flexible collection — add a new question type
 * without any schema migration or ALTER TABLE.
 */
@Document(collection = "examquestions")
public class MongoExamQuestion {

    @Id
    private String id;

    private String title;
    private String description;
    private String type; // "open", "mc", "ordering", "matching"
    private boolean published;

    // Used by MC questions
    private List<MCOption> options;

    // Used by ordering questions
    private List<OrderItem> items;

    // Used by matching questions
    private List<MatchPair> matchPairs;

    // Flexible metadata (difficulty, topic, etc.) - trivial in MongoDB
    private Map<String, String> metadata;

    // --- Embedded document classes ---

    public static class MCOption {
        private String text;
        private boolean correct;

        public MCOption() {}
        public MCOption(String text, boolean correct) {
            this.text = text;
            this.correct = correct;
        }
        public String getText() { return text; }
        public void setText(String text) { this.text = text; }
        public boolean isCorrect() { return correct; }
        public void setCorrect(boolean correct) { this.correct = correct; }
    }

    public static class OrderItem {
        private String text;
        private int correctPosition;

        public OrderItem() {}
        public OrderItem(String text, int correctPosition) {
            this.text = text;
            this.correctPosition = correctPosition;
        }
        public String getText() { return text; }
        public void setText(String text) { this.text = text; }
        public int getCorrectPosition() { return correctPosition; }
        public void setCorrectPosition(int correctPosition) { this.correctPosition = correctPosition; }
    }

    public static class MatchPair {
        private String left;
        private String right;

        public MatchPair() {}
        public MatchPair(String left, String right) {
            this.left = left;
            this.right = right;
        }
        public String getLeft() { return left; }
        public void setLeft(String left) { this.left = left; }
        public String getRight() { return right; }
        public void setRight(String right) { this.right = right; }
    }

    // --- Getters & Setters ---

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public boolean isPublished() { return published; }
    public void setPublished(boolean published) { this.published = published; }
    public List<MCOption> getOptions() { return options; }
    public void setOptions(List<MCOption> options) { this.options = options; }
    public List<OrderItem> getItems() { return items; }
    public void setItems(List<OrderItem> items) { this.items = items; }
    public List<MatchPair> getMatchPairs() { return matchPairs; }
    public void setMatchPairs(List<MatchPair> matchPairs) { this.matchPairs = matchPairs; }
    public Map<String, String> getMetadata() { return metadata; }
    public void setMetadata(Map<String, String> metadata) { this.metadata = metadata; }
}