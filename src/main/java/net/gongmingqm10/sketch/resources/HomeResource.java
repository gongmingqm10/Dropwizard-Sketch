package net.gongmingqm10.sketch.resources;

import net.gongmingqm10.sketch.models.User;
import net.gongmingqm10.sketch.services.UserService;
import net.gongmingqm10.sketch.views.HomeView;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/")
public class HomeResource {

    private UserService userService;

    public HomeResource(UserService userService) {

        this.userService = userService;
    }

    @GET
    public Response viewHome() {
        User user = userService.queryUser();
        return Response.ok(new HomeView(user)).build();
    }
}
