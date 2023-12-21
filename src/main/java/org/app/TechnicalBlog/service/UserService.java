package org.app.TechnicalBlog.service;

import org.app.TechnicalBlog.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public boolean login(User user){
        if (user.getUsername().equals("validuser")){
            return true;
        }
        return false;
    }
}
