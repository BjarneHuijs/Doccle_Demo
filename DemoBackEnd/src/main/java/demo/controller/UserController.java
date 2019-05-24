package demo.controller;

import demo.model.Chat;
import demo.model.ChatSessions;
import demo.model.User;
import demo.model.Users;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class UserController {

    public Users users;
    private ChatController cc;
    public User currentUser;

    public UserController() { users = new Users(); }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getUsers() {
        ArrayList<User> privList = new ArrayList<>();
        for (User u : users.getUsers().values()) {
            if(u.getUserType().equals("private")
                    && !u.getEmail().equals(currentUser.getEmail())
                    && !currentUser.getConnections().contains(u)) { privList.add(u); }
        }
        return privList;
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable String id) {
        return users.getUser(id);
    }

    @RequestMapping(value = "/users/connect", method = RequestMethod.POST)
    public String connectToUser(@RequestBody String user) {
        try {
            JSONObject o = new JSONObject(user);
            String uName = o.getString("connectTo");

            currentUser.addConnection(users.getUser(uName));
            cc.sessions.addChatSession(new Chat(currentUser, users.getUser(uName)));
            System.out.println(cc.getChatSessions().get(1).getU2().getEmail());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "{}";
    }

    public void setCC(ChatController c) {
        this.cc = c;
    }
}
