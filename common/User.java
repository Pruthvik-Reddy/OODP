package common;

import java.io.Serializable;
import java.util.List;


public class User implements Serializable {
    private String userID;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String role;

    public User(String userID, String firstName, String lastName, String username, String password, String role) {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getusername(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }
    public String getRole(){
        return this.role;
    }
    


}