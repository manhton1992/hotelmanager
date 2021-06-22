package de.hda.hotelmanager.entities;

import de.hda.hotelmanager.entities.Room.RoomSize;

public class RoomDTO {

  private Long id;
  private RoomSize size;
  private boolean minibar;

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

  public RoomDTO(Long id, RoomSize size, boolean minibar) {
    this.id = id;
    this.size = size;
    this.minibar = minibar;
  }

  @Override
  public String toString() {
    return "RoomDTO{" +
        "id=" + id +
        ", size='" + size + '\'' +
        ", minibar=" + minibar +
        '}';
  }
}
