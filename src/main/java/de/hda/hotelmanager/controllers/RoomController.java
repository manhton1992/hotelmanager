package de.hda.hotelmanager.controllers;

import de.hda.hotelmanager.entities.Room;
import de.hda.hotelmanager.entities.RoomDTO;
import de.hda.hotelmanager.repositories.RoomRespository;
import de.hda.hotelmanager.services.RoomService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/rooms")
public class RoomController {

  @Autowired
  private RoomRespository roomRespository;

  @Autowired
  private RoomService roomService;

  @PostMapping
  public ResponseEntity<Room> addNewCategory(@RequestBody Room room) {
    if (room.getCreated() == null){
      room.setCreated(new Date());
    }
    roomRespository.save(room);
    return new ResponseEntity<>(room, HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<RoomDTO>> getAlLRoom() {
    return new ResponseEntity<>(roomService.getAllRooms(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<RoomDTO> getRoom(@PathVariable Long id) {
    return new ResponseEntity<>(roomService.getRoom(id), HttpStatus.OK);
  }

  @PutMapping("/{id}")
  public ResponseEntity<RoomDTO> replaceRoom(@RequestBody Room room, @PathVariable Long id) {
    return new ResponseEntity<>(roomService.replaceRoom(room,id), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<RoomDTO> deleteRoom(@PathVariable Long id) {
    return new ResponseEntity<>(roomService.deleteRoom(id), HttpStatus.OK);
  }
}
