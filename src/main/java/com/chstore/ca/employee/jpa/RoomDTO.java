package com.chstore.ca.employee.jpa;

import lombok.Data;

import java.util.List;

@Data
public class RoomDTO {

    private String roomName;
    private List<ItemDTO> itemList;
}
