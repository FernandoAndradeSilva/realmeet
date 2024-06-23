package br.com.fernando.realmeet.utils;

import static br.com.fernando.realmeet.utils.TestConstants.DEFAULT_ROOM_NAME;
import static br.com.fernando.realmeet.utils.TestConstants.DEFAULT_ROOM_SEATS;
import br.com.fernando.realmeet.domain.entity.Room;

public final class TestDataCreator {

    private TestDataCreator() {}

    public static Room.Builder newRoomBuilder() {
        return Room.newBuilder().name(DEFAULT_ROOM_NAME).seats(DEFAULT_ROOM_SEATS);
    }
}
