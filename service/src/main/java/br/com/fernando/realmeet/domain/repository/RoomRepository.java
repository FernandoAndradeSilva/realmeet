package br.com.fernando.realmeet.domain.repository;

import br.com.fernando.realmeet.domain.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}