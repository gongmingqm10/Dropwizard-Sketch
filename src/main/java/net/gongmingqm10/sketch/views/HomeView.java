package net.gongmingqm10.sketch.views;

import net.gongmingqm10.sketch.models.User;

public class HomeView extends BaseView {
    private User user;

    public HomeView(User user) {
        super("home.mustache");
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
