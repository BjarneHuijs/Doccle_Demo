package demo.model;

import java.util.HashMap;
import java.util.Map;

public class Users {

    private Map<String, User> users;

    public Users() {
        users = new HashMap<String, User>();
    }

    public Users(Map<String, User> users) {
        this.users = users;
    }

    public void AddUser(String mail, String type){
        users.put(mail, new User(mail, type));
    }

    public Map<String, User> getUsers() {
        return users;
    }

    private void setUsers(Map<String, User> users) {
        this.users = users;
    }

    public User getUser(String id){
        return users.get(id);
    }

}
