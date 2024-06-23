package br.com.fernando.realmeet.utils;

import br.com.fernando.realmeet.mapper.RoomMapper;
import org.mapstruct.factory.Mappers;

public final class MapperUtils {

    private MapperUtils() {}

    public static RoomMapper roomMapper() {
     return Mappers.getMapper(RoomMapper.class);
    }
}
