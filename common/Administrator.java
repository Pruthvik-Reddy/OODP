package common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Administrator extends User {
    public Administrator(String userID, String firstName, String lastName, String username, String password, String role) {
        super(userID, firstName, lastName, username, password, role);
    }

   
}