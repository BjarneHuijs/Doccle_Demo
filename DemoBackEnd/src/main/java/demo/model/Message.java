package demo.model;

public class Message {
    private String sender;
    private String content;

    public Message(String from, String content) {
        this.content = content;
        this.sender = from;
    }

    public String getSender() {
        return sender;
    }

    public String getContent() {
        return content;
    }
}
