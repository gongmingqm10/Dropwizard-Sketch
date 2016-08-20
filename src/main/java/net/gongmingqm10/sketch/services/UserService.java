package net.gongmingqm10.sketch.services;

import net.gongmingqm10.sketch.models.User;

public class UserService {

    public User queryUser() {
        return new User("Ming Gong", 25);
    }
}
