package pl.andrzejmidura.fivehanddrawpoker.game.utils;

public enum Action {
        // action reserved for ANTE stage
        ANTE,

        // actions reserved for BETTING stage
        BET,
        CHECK,
        FOLD,
        CALL,
        RAISE,
        ALL_IN,

        // actions reserved for DISCARDING stage
        DISCARD,
        KEEP_ALL
}
