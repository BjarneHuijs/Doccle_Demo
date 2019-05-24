package demo.controller;

import demo.model.Chat;
import demo.model.ChatSessions;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ChatController {
    public ChatSessions sessions;

    public ChatController() {
        sessions = new ChatSessions();
    }

    @RequestMapping(value = "/chat", method = RequestMethod.GET)
    public List<Chat> getChatSessions() {
        return sessions.getChatSessions();
    }

    @RequestMapping(value = "/chat/{id}", method = RequestMethod.GET)
    public Chat getChat(@PathVariable String id){
        return sessions.getChatSession(id);
    }
}
