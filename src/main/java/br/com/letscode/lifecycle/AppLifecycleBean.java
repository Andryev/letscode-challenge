package br.com.letscode.lifecycle;

import br.com.letscode.domain.service.MovieService;
import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@ApplicationScoped
public class AppLifecycleBean {

    private static final Logger LOGGER = LoggerFactory.getLogger("AppLifecycleBean");

    @Inject
    MovieService movieService;


    void onStart(@Observes StartupEvent ev) {
        LOGGER.info("The application is starting...{}");
        this.movieService.loadMovie();
    }

    void onStop(@Observes ShutdownEvent ev) {
        LOGGER.info("The application is stopping... {}");
    }

}
