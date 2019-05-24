package demo.controller;

import demo.model.Chat;
import demo.model.ChatSessions;
import org.json.JSONException;
import org.json.JSONObject;
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

    @RequestMapping(value = "/chat/{id}", method = RequestMethod.POST)
    public Chat sendMessage(@PathVariable String id, @RequestBody String message) {
        try {
            JSONObject o = new JSONObject(message);
            String sender = o.getString("from");
            String msg = o.getString("message");
            System.out.println(sender + ", " + msg);

            System.out.println(sessions.getChatSession(id));
            sessions.getChatSession(id).sendMessage(sender, msg);
            System.out.println(sessions.getChatSession(id));
            return sessions.getChatSession(id);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
