package pl.andrzejmidura.fivehanddrawpoker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.andrzejmidura.fivehanddrawpoker.entity.Game;

import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {
}
