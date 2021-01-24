package com.chstore.ca.employee.jpa;

import java.util.List;
import java.util.stream.Collectors;

public class RoomMapper {

    public static List<Item> getItemList(RoomDTO roomDTO, Room room) {
        return roomDTO.getItemList()
                .stream()
                .map(itemDTO -> getItem(room, itemDTO))
                .collect(Collectors.toList());
    }

    public static Item getItem(final Room room,
                               final ItemDTO itemDTO) {
        final Item item = new Item();
        item.setName(itemDTO.getName());
        item.setRoom(room);
        return item;
    }
}
