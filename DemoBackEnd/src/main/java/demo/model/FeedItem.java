package demo.model;

public class FeedItem {
    private String title;
    private String shortText;
    private String content;

    public FeedItem(String title, String shortText, String contents){
        setContent(contents);
        setShortText(shortText);
        setTitle(title);
    }

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
