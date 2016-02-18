package at.ac.tgm.hit.dezsyslabor.hampl.rest;

import at.ac.tgm.hit.dezsyslabor.hampl.Utils;
import at.ac.tgm.hit.dezsyslabor.hampl.domain.User;
import at.ac.tgm.hit.dezsyslabor.hampl.service.UserRepository;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Named
@Path("/login")
@Produces({MediaType.APPLICATION_JSON})
public class LoginEndpoint {

    @Inject
    UserRepository userRepository;

    @POST
    public Response post(User user) {
        if (user != null && user.getEmail() != null) {
            User loginUser = this.userRepository.findByEmail(user.getEmail());
            if (user.getPassword() != null && loginUser != null && loginUser.getPassword().equals(user.getPassword())) {
                return Utils.createResponse(Response.Status.OK, "Welcome " + loginUser.getName() + "!");
            }
        }
        return Utils.createResponse(Response.Status.FORBIDDEN, "Email or password is wrong");
    }
}
