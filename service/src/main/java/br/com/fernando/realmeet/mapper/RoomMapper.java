package br.com.fernando.realmeet.mapper;


import br.com.fernando.realmeet.api.model.RoomDTO;
import br.com.fernando.realmeet.domain.entity.Room;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class RoomMapper {

    public abstract RoomDTO fromEntityToDto(Room room);
}
