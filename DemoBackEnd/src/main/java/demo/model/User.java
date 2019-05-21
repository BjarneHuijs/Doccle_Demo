package demo.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String email;
    private String userType;
    private List<User> connections;

    public User(String mail, String type){
        setEmail(mail);
        setUserType(type);
        connections = new ArrayList<>();
    }

    public String getEmail() {
        return email;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    public String getUserType() {
        return userType;
    }

    private void setUserType(String userType) {
        this.userType = userType;
    }

    public List<User> getConnections() {
        return connections;
    }

    private void setConnections(List<User> connections) {
        this.connections = connections;
    }

    public void addConnection(User otherUser){
        if(otherUser == null || otherUser == this){
            throw new IllegalArgumentException("You can not be connected to nothing or to yourself");
        }
        this.connections.add(otherUser);
    }
}
