package br.com.fernando.realmeet.integration;

import static org.junit.jupiter.api.Assertions.*;
import static br.com.fernando.realmeet.utils.TestConstants.DEFAULT_ROOM_ID;
import static br.com.fernando.realmeet.utils.TestDataCreator.*;
import br.com.fernando.realmeet.api.facade.RoomApi;
import br.com.fernando.realmeet.core.BaseIntegrationTest;
import br.com.fernando.realmeet.domain.repository.RoomRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.HttpClientErrorException;

class RoomApiIntegrationTest extends BaseIntegrationTest {

    @Autowired
    private RoomApi api;

    @Autowired
    private RoomRepository roomRepository;


    @Override
    protected void setupEach() throws Exception {
        setLocalHostBasePath(api.getApiClient(), "/v1");
    }

    @Test
    void testGetRoom() {

        var room = newRoomBuilder().build();
        roomRepository.saveAndFlush(room);

        assertNotNull(room.getId());
        assertTrue(room.isActive());

        var dto = api.getRoom(DEFAULT_ROOM_ID);
        Assertions.assertEquals(room.getName(), dto.getName());
        Assertions.assertEquals(room.getSeats(), dto.getSeats());
        Assertions.assertEquals(room.getId(), dto.getId());

    }

    @Test
    void testGetRoomInactive() {
        var room = newRoomBuilder().active(false).build();
        roomRepository.saveAndFlush(room);
        assertFalse(room.isActive());
        assertThrows(HttpClientErrorException.NotFound.class , () -> api.getRoom(room.getId()));

    }

    @Test
    void testGetRoomDoesNotExists() {
        assertThrows(HttpClientErrorException.NotFound.class , () -> api.getRoom(DEFAULT_ROOM_ID));

    }

}
