package br.com.fernando.realmeet.unit;

import static br.com.fernando.realmeet.utils.TestConstants.DEFAULT_ROOM_ID;
import static br.com.fernando.realmeet.utils.TestDataCreator.newRoomBuilder;
import br.com.fernando.realmeet.mapper.RoomMapper;
import br.com.fernando.realmeet.utils.MapperUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class RoomMapperUnitTeste {

    private RoomMapper victm;

    @BeforeEach
    void setupEach() {
        victm = MapperUtils.roomMapper();
    }

    @Test
    void testeFromEntityToDto() {
        var room = newRoomBuilder().id(DEFAULT_ROOM_ID).build();
        var dto = victm.fromEntityToDto(room);

        Assertions.assertEquals(room.getName(), dto.getName());
        Assertions.assertEquals(room.getSeats(), dto.getSeats());
        Assertions.assertEquals(room.getId(), dto.getId());
    }

}
