package demo.controller;

import demo.model.User;
import demo.model.Users;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class UserController {

    public Users users;

    public UserController() { users = new Users(); }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getUsers() {
        ArrayList<User> privList = new ArrayList<>();
        for (User u : users.getUsers().values()) {
            if(u.getUserType().equals("private")) privList.add(u);
        }
        //return new ArrayList<>(users.getUsers().values());
        return privList;
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable String id) {
        return users.getUser(id);
    }

}
