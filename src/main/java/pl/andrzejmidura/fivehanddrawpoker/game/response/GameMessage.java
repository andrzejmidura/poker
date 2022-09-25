package pl.andrzejmidura.fivehanddrawpoker.game.response;

import pl.andrzejmidura.fivehanddrawpoker.entity.User;
import pl.andrzejmidura.fivehanddrawpoker.game.utils.Action;
import pl.andrzejmidura.fivehanddrawpoker.game.utils.Card;
import pl.andrzejmidura.fivehanddrawpoker.game.utils.Hand;

import java.util.List;
import java.util.Map;

public class GameMessage {
    private PlayerState playerState;
    private Map<User, Action> otherPlayers;
    private List<Card> cards;
    private List<Action> availableActions;
    private Hand hand;
    private Long credits;
    private Long pot;

    public GameMessage() {
    }

    public PlayerState getResponseType() {
        return playerState;
    }

    public void setResponseType(PlayerState playerState) {
        this.playerState = playerState;
    }

    public Map<User, Action> getOtherPlayers() {
        return otherPlayers;
    }

    public void setOtherPlayers(Map<User, Action> otherPlayers) {
        this.otherPlayers = otherPlayers;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public List<Action> getAvailableActions() {
        return availableActions;
    }

    public void setAvailableActions(List<Action> availableActions) {
        this.availableActions = availableActions;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public Long getCredits() {
        return credits;
    }

    public void setCredits(Long credits) {
        this.credits = credits;
    }

    public Long getPot() {
        return pot;
    }

    public void setPot(Long pot) {
        this.pot = pot;
    }
}
