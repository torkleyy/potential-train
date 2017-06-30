package question;

public class Answer {
    /**
     * The ID of this Answer
     */
    private int id;
    /**
     * The String of this Answer
     */
    private String desc;

    Answer(String desc, int id) {
        this.desc = desc;
        this.id = id;
    }

    /**
     * Returns the ID of this answer
     * @return This answer's id
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the String representation of this answer
     * @return This answer's description
     */
    @Override
    public String toString() {
        return desc;
    }
}
