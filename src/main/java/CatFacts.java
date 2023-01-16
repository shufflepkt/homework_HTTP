import com.fasterxml.jackson.annotation.JsonProperty;

public class CatFacts {
    private final String id;
    private final String text;
    private final String type;
    private final String user;
    private final Integer upvotes;

    CatFacts(
            @JsonProperty("id") String id,
            @JsonProperty("text") String text,
            @JsonProperty("type") String type,
            @JsonProperty("user") String user,
            @JsonProperty("upvotes") Integer upvotes
    ) {
        this.id = id;
        this.text = text;
        this.type = type;
        this.user = user;
        this.upvotes = upvotes;
    }

    @Override
    public String toString() {
        return "CatFacts:" +
                "\n id=" + id +
                "\n text=" + text +
                "\n type=" + type +
                "\n user=" + user+
                "\n upvotes=" + upvotes;
    }

    public String getText() {
        return text;
    }

    public Integer getUpvotes() {
        return upvotes;
    }
}