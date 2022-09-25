package pl.andrzejmidura.fivehanddrawpoker.entity;

import javax.persistence.*;

@Entity
@Table(name = "game_history")
public class GameHistory {
    @Id
    @Column(name = "game_history_id")
    private int gameHistoryId;

    @Column(name = "profit")
    private int profit;

    @Column(name = "best_hand")
    private String bestHand;

    private String username;

    private int game_id;

    public GameHistory() {
    }

    public GameHistory(int gameHistoryId, int profit, String bestHand) {
        this.gameHistoryId = gameHistoryId;
        this.profit = profit;
        this.bestHand = bestHand;
    }

    public int getGameHistoryId() {
        return gameHistoryId;
    }

    public void setGameHistoryId(int gameHistoryId) {
        this.gameHistoryId = gameHistoryId;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    public String getBestHand() {
        return bestHand;
    }

    public void setBestHand(String bestHand) {
        this.bestHand = bestHand;
    }

    @Override
    public String toString() {
        return "GameHistory{" +
                "gameHistoryId=" + gameHistoryId +
                ", profit=" + profit +
                ", bestHand='" + bestHand + '\'' +
                '}';
    }
}
