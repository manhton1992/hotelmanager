package de.hda.hotelmanager.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Room {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  private RoomSize size;

  @NotNull
  private boolean minibar;

  private Date created;

  public Room(){

  }

  public Room(RoomSize size, boolean minibar, Date created) {
    this.size = size;
    this.minibar = minibar;
    this.created = created;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public RoomSize getSize() {
    return size;
  }

  public void setSize(RoomSize size) {
    this.size = size;
  }

  public boolean isMinibar() {
    return minibar;
  }

  public void setMinibar(boolean minibar) {
    this.minibar = minibar;
  }


  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }

  @Override
  public String toString() {
    return "Room{" +
        "id=" + id +
        ", size='" + size + '\'' +
        ", minibar=" + minibar +
        ", created=" + created +
        '}';
  }

  public RoomDTO toRoomDTO(){
    RoomDTO roomDTO = new RoomDTO(this.id, this.size, this.minibar);
    return roomDTO;
  }

  public enum  RoomSize {
    SINGLE,
    DOUBLE,
    SUITE
  }
}
