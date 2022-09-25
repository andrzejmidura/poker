package pl.andrzejmidura.fivehanddrawpoker.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "games")
public class Game {
    @Id
    @Column(name = "game_id")
    private int gameId;

    @Column(name = "date")
    private Date date;

    @OneToMany
    @JoinColumn(name = "game_id")
    private Set<GameHistory> gameHistorySet;

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int game_id) {
        this.gameId = game_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Game{" +
                "gameId=" + gameId +
                ", date=" + date +
                ", gameHistorySet=" + gameHistorySet +
                '}';
    }
}
