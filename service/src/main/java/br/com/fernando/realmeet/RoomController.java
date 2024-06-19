package br.com.fernando.realmeet;


import br.com.fernando.realmeet.api.facade.RoomsApi;
import br.com.fernando.realmeet.api.model.Room;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RoomController implements RoomsApi {

    @Override
    public ResponseEntity<Room> listRooms(@Valid Long id) {
        return RoomsApi.super.listRooms(id);
    }


}
