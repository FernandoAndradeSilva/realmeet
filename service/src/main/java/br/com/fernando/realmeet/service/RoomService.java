package br.com.fernando.realmeet.service;

import java.util.Objects;
import br.com.fernando.realmeet.api.model.RoomDTO;
import br.com.fernando.realmeet.domain.entity.Room;
import br.com.fernando.realmeet.domain.repository.RoomRepository;
import br.com.fernando.realmeet.exception.RoomNotFoundException;
import br.com.fernando.realmeet.mapper.RoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private RoomMapper roomMapper;

    public RoomDTO getRoom(Long id) {
        Objects.requireNonNull(id);
        Room room = roomRepository.findById(id).orElseThrow(() -> new RoomNotFoundException("Room not found: " + id));
        return roomMapper.fromEntityToDto(room);
    }



}
