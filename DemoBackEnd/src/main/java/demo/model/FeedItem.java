package demo.model;

public class FeedItem {
    private int id;
    private String title;
    private String shortText;
    private String content;

    public FeedItem(int id, String title, String shortText, String contents){
        setId(id);
        setContent(contents);
        setShortText(shortText);
        setTitle(title);
    }

    public int getId() { return this.id; }

    private void setId(int id) { this.id = id; }

    public String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    public String getShortText() {
        return shortText;
    }

    private void setShortText(String shortText) {
        this.shortText = shortText;
    }

    public String getContent() {
        return content;
    }

    private void setContent(String content) {
        this.content = content;
    }
}
