package br.com.fernando.realmeet.controller;


import static java.util.concurrent.CompletableFuture.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import br.com.fernando.realmeet.api.facade.RoomsApi;
import br.com.fernando.realmeet.api.model.RoomDTO;
import br.com.fernando.realmeet.service.RoomService;
import br.com.fernando.realmeet.util.ResponseEntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RoomController implements RoomsApi {

    @Autowired
    private RoomService roomService;

    @Autowired
    private Executor controlerExecutor;


    @Override
    public CompletableFuture<ResponseEntity<RoomDTO>> getRoom(Long id) {

        return supplyAsync(() -> roomService.getRoom(id) , controlerExecutor)
                .thenApply(ResponseEntityUtils::ok);
    }
}
