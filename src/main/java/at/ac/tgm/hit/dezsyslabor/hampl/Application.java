package at.ac.tgm.hit.dezsyslabor.hampl;

import at.ac.tgm.hit.dezsyslabor.hampl.rest.LoginEndpoint;
import at.ac.tgm.hit.dezsyslabor.hampl.rest.RegisterEndpoint;
import at.ac.tgm.hit.dezsyslabor.hampl.rest.UserEndpoint;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.inject.Named;


@SpringBootApplication
public class Application {

    @Named
    public static class JerseyConfig extends ResourceConfig {

        public JerseyConfig() {
            this.register(LoginEndpoint.class);
            this.register(RegisterEndpoint.class);
            this.register(UserEndpoint.class);
            this.register(JacksonFeature.class);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}