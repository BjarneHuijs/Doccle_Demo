package demo.model;

import java.util.ArrayList;
import java.util.List;

public class ChatSessions {
    private List<Chat> chatSessions;

    public ChatSessions() {
        chatSessions = new ArrayList<>();
    }

    public List<Chat> getChatSessions() {
        return chatSessions;
    }

    public Chat getChatSession(String id) {
        for(Chat c: chatSessions) {
            if(c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    private void setChatSessions(List<Chat> sessions) {
        this.chatSessions = sessions;
    }

    public void addChatSession(Chat session){
        if(session == null || this.chatSessions.contains(session)){
            throw new IllegalArgumentException("You can not add a non-existing session or an ongoing session");
        }
        this.chatSessions.add(session);
    }
}
