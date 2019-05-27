package com.stackroute.muzixservices.config;
import com.stackroute.muzixservices.domain.Track;
import com.stackroute.muzixservices.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.jboss.logging.Logger;
//import java.util.logging.Logger;

@Component
@PropertySource("classpath:application.properties")
public class ApplicationListenerStartup implements ApplicationListener<ContextRefreshedEvent> {
    private static final Logger logs = Logger.getLogger(ApplicationListenerStartup.class);
    private TrackRepository trackRepository;

    @Autowired
    private Environment env;

    @Autowired
    public ApplicationListenerStartup(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        logs.info("Inserting data on start");

        Track track1 = new Track(3, "Modala maleyante", "Singer : sonu  Nigam");
        trackRepository.save(track1);
        Track track2 = new Track(4, "Gaganave Bhagi", "Singer : Shreya Goshal");
        trackRepository.save(track2);
        Track track3 = new Track(Integer.parseInt(env.getProperty("app.trackID")), env.getProperty("app.trackname"), env.getProperty("app.comments"));
        trackRepository.save(track3);

        logs.info("data successfully inserted");
    }
}