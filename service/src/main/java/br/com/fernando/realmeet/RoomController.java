package br.com.fernando.realmeet;

import br.com.fernando.realmeet.api.facade.RoomsApi;
import br.com.fernando.realmeet.api.model.Room;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

import static java.util.concurrent.CompletableFuture.*;

@RestController
public class RoomController implements RoomsApi {

    @Override
    public CompletableFuture<ResponseEntity<Room>> listRooms(Long id) {
        return supplyAsync(() -> ResponseEntity.ok( new Room().id(1L).name("Room #1")));
    }
}
