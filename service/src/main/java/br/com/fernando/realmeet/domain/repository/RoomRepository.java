package br.com.fernando.realmeet.domain.repository;

import java.util.Optional;
import br.com.fernando.realmeet.domain.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {


    Optional<Room> findByIdAndActive(Long id , Boolean active);
}