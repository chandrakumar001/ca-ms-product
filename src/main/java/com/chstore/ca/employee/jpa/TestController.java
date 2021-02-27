package com.chstore.ca.employee.jpa;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static com.chstore.ca.employee.jpa.RoomMapper.getItem;
import static com.chstore.ca.employee.jpa.RoomMapper.getItemList;

@RestController
@AllArgsConstructor
public class TestController {

    @NonNull
    private TestService testService;

    @PostMapping("/test")
    public void postData(@RequestBody RoomDTO roomDTO) {
        testService.postData(roomDTO);
    }

    @GetMapping("/test")
    public void testData() {
        testService.get();
    }
}

@Service
@Transactional
class TestService {
    @Autowired
    TestRepository testRepository;

    @Autowired
    TestItemRepository testItemRepository;

    public void get() {
        List<String> items = testRepository.findAll()
                .stream()
                .map(Room::getItems)
                .flatMap(Collection::stream)
                .map(Item::getName)
                .collect(Collectors.toList());
        System.out.println("Items--" + items);

//        List<String> rooms = testItemRepository.findAll()
//                .stream()
//                .map(Item::getRoom)
//                .map(Room::getRoomName)
//                .collect(Collectors.toList());
//
//        System.out.println("Rooms--" + items);

    }

    public void postData(final RoomDTO roomDTO) {

        final Room room = getRoom(roomDTO);
        testRepository.save(room);
    }

    private Room getRoom(final RoomDTO roomDTO) {

        Room room = new Room();
        final List<Item> items = getItemList(roomDTO, room);
        room.setItems(items);
        room.setRoomName(roomDTO.getRoomName());
        return room;
    }
}

@Repository
interface TestRepository extends JpaRepository<Room, Long> {

    @Query("SELECT r FROM Room r LEFT JOIN FETCH r.items")
    List<Room> findAll();
}

@Repository
interface TestItemRepository extends JpaRepository<Item, Long>, RevisionRepository<Item, Long, Integer> {

    @Query("SELECT i FROM Item i LEFT JOIN FETCH i.room")
    List<Item> findAll();
}
/*
 *   <P>Without FETCH</P>
 *    1220500 nanoseconds spent acquiring 1 JDBC connections;
 *    0 nanoseconds spent releasing 0 JDBC connections;
 *    10587300 nanoseconds spent preparing 4 JDBC statements;
 *    12128000 nanoseconds spent executing 4 JDBC statements;
 *
 *   <P>With FETCH</p>
 *  2021-01-24 17:01:42.093  INFO [ app-name=ca-product, X-BusinessTx-ID=a62a91af-ffaa-498a-8ec0-3bcffb7f53c8, X-Request-ID=79c8c2a7-0c53-467b-acec-4e18cb916878 ] ::: [888-exec-1] i.StatisticalLoggingSessionEventListener  : Session Metrics {
 *   468200 nanoseconds spent acquiring 1 JDBC connections;
 *   0 nanoseconds spent releasing 0 JDBC connections;
 *   14400300 nanoseconds spent preparing 2 JDBC statements;
 *   14961300 nanoseconds spent executing 2 JDBC statements;
 *   0 nanoseconds spent executing 0 JDBC batches;
 *   0 nanoseconds spent performing 0 L2C puts;
 *   0 nanoseconds spent performing 0 L2C hits;
 *   0 nanoseconds spent performing 0 L2C misses;
 *   5841400 nanoseconds spent executing 1 flushes (flushing a total of 8 entities and 2 collections);
 *  31754600 nanoseconds spent executing 2 partial-flushes (flushing a total of 8 entities and 8 collections)
 *   }
 *
 *   10587300(first) -14400300(Second)==-38,13,000
 *
 */