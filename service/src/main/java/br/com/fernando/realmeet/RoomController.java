package br.com.fernando.realmeet;

import static java.util.concurrent.CompletableFuture.supplyAsync;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import br.com.fernando.realmeet.api.facade.RoomsApi;
import br.com.fernando.realmeet.api.model.Room;
import java.util.concurrent.CompletableFuture;

@RestController
public class RoomController implements RoomsApi {

    @Override
    public CompletableFuture<ResponseEntity<Room>> listRooms(@Valid Long id) {
        return supplyAsync(() -> ResponseEntity.ok( new Room().id(1L).name("Room #1")));
    }
}
