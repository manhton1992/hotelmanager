package de.hda.hotelmanager.services;

import de.hda.hotelmanager.entities.Room;
import de.hda.hotelmanager.entities.RoomDTO;
import java.util.List;

public interface RoomService {
  List<RoomDTO> getAllRooms();
  RoomDTO getRoom(Long id);
  RoomDTO replaceRoom(Room room, Long id);
  RoomDTO deleteRoom(Long id);
}
