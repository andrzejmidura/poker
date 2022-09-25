package pl.andrzejmidura.fivehanddrawpoker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.andrzejmidura.fivehanddrawpoker.entity.GameHistory;

import java.util.List;

@Repository
public interface GameHistoryRepository extends JpaRepository<GameHistory, Integer> {
}
