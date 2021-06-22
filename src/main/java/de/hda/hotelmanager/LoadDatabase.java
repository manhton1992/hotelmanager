package de.hda.hotelmanager;

import de.hda.hotelmanager.entities.Room;
import de.hda.hotelmanager.entities.Room.RoomSize;
import de.hda.hotelmanager.repositories.RoomRespository;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(RoomRespository respository){
    return args -> {
      log.info("Preloading " + respository.save(new Room(RoomSize.DOUBLE, true, new Date())));
      log.info("Preloading " + respository.save(new Room(RoomSize.SINGLE, true, new Date())));
      log.info("Preloading " + respository.save(new Room(RoomSize.SUITE, false, new Date())));
    };
  }
}
