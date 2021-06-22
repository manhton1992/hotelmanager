package de.hda.hotelmanager.repositories;

import de.hda.hotelmanager.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRespository extends JpaRepository<Room, Long> {

}
