package demo.model;

import java.util.ArrayList;
import java.util.List;

public class Chat {

    private String id;
    private User u1;
    private User u2;
    private List<Message> messages;

    public Chat(User user1, User user2) {
        this.id = user2.getEmail();
        this.messages = new ArrayList<>();
        setU1(user1);
        setU2(user2);
        //u2.addConnection(u1);
    }

    public String getId() {
        return this.id;
    }

    public User getU1() {
        return u1;
    }

    public void setU1(User u1) {
        this.u1 = u1;
    }

    public User getU2() {
        return u2;
    }

    public void setU2(User u2) {
        this.u2 = u2;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Message> sendMessage(String from, String content) {
        messages.add(new Message(from, content));
        if(content.equals("Hallo") || content.equals("Hey")) {
            messages.add(new Message(u2.getEmail(), "Hallo, wat kan ik voor je doen?"));
        }
        if(content.equals("Kan je me de rekenening van ons telenet abonnement doorsturen?") ||
                content.equals("Wil je me de telenetrekening doorsturen?") ||
                content.equals("Wil je me de rekening doorsturen alstublieft?")) {
            messages.add(new Message(u2.getEmail(), "Zeker, ik stuur deze direct door! Je zou hem binnen een minuutje op je documenten moeten kunnen zien."));
        }
        return getMessages();
    }
}
