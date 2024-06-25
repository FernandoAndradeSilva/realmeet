package br.com.fernando.realmeet.unit;

import static org.mockito.Mockito.when;
import static br.com.fernando.realmeet.utils.MapperUtils.roomMapper;
import static br.com.fernando.realmeet.utils.TestConstants.DEFAULT_ROOM_ID;
import java.util.Optional;
import br.com.fernando.realmeet.core.BaseUnitTest;
import br.com.fernando.realmeet.domain.repository.RoomRepository;
import br.com.fernando.realmeet.exception.RoomNotFoundException;
import br.com.fernando.realmeet.service.RoomService;
import br.com.fernando.realmeet.utils.TestDataCreator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class RoomServiceUnitTest extends BaseUnitTest {

    @Mock
    private RoomService victm;

    @Mock
    private RoomRepository roomRepository;

    @BeforeEach
    void setupEach() {
        victm = new RoomService(roomRepository , roomMapper());
    }

    @Test
    void testeGetRoomSucess() {

        var room = TestDataCreator.newRoomBuilder().id(DEFAULT_ROOM_ID).build();
        when(roomRepository.findByIdAndActive(DEFAULT_ROOM_ID , true)).thenReturn(Optional.of(room));

        var dto = victm.getRoom(DEFAULT_ROOM_ID);
        Assertions.assertEquals(room.getName(), dto.getName());
        Assertions.assertEquals(room.getSeats(), dto.getSeats());
        Assertions.assertEquals(room.getId(), dto.getId());
    }

    @Test
    void testeGetRoomNotFound() {
        when(roomRepository.findByIdAndActive(DEFAULT_ROOM_ID , true)).thenReturn(Optional.empty());
        Assertions.assertThrows(RoomNotFoundException.class, () -> victm.getRoom(DEFAULT_ROOM_ID ));
    }


}
