package de.hda.hotelmanager.services;

import de.hda.hotelmanager.entities.Room;
import de.hda.hotelmanager.entities.RoomDTO;
import de.hda.hotelmanager.repositories.RoomRespository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class RoomServiceImpl implements RoomService {

  @Autowired
  private RoomRespository roomRespository;

  @Override
  public List<RoomDTO> getAllRooms() {
    List<Room> rooms = roomRespository.findAll();
    return rooms.stream().map(r -> r.toRoomDTO()).collect(Collectors.toList());
  }

  public RoomServiceImpl() {
    super();
  }

  @Override
  public RoomDTO getRoom(Long id) {
    Room room = roomRespository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    return room.toRoomDTO();
  }

  @Override
  public RoomDTO replaceRoom(Room room, Long id) {
    Room replaceRoom = roomRespository.findById(id).map(updRoom -> {
      updRoom.setMinibar(room.isMinibar());
      updRoom.setSize(room.getSize());
      return roomRespository.save(updRoom);
    }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    return replaceRoom.toRoomDTO();
  }

  @Override
  public RoomDTO deleteRoom(Long id) {
    Room room = roomRespository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    roomRespository.deleteById(id);
    return room.toRoomDTO();
  }
}
