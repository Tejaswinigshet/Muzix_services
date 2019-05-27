package com.stackroute.muzixservices.config;
import com.stackroute.muzixservices.domain.Track;
import com.stackroute.muzixservices.repository.TrackRepository;
//import org.graalvm.compiler.lir.CompositeValue;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

//import java.util.logging.Logger;
@Component
public class CommandLineRunnerStartup implements CommandLineRunner {

    public static final Logger logs = LoggerFactory.getLogger(CommandLineRunnerStartup.class);
    private TrackRepository trackRepository;

    @Autowired
    public CommandLineRunnerStartup(TrackRepository trackRepository){
        this.trackRepository=trackRepository;
    }

    @Override
    public void run(String... args) throws Exception{
        logs.info("Inserting data on start");

        Track trackOne = new Track(1,"ondu munjane ","Singer : Sonu Nigam");
        trackRepository.save(trackOne);
        Track trackTwo = new Track(2,"Ondu malebillu","Singer : Arman Mallik");
        trackRepository.save(trackTwo);

        logs.info("data successfully inserted");
    }
}