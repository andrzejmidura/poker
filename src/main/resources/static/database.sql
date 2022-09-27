DROP TABLE users CASCADE;
DROP TABLE game_history CASCADE;
DROP TABLE games CASCADE;

CREATE TABLE users(
	username	        VARCHAR(40)		NOT NULL,
	email		        VARCHAR(40)		NOT NULL,
	password	        VARCHAR(120)	NOT NULL,
	credits		        INTEGER			NOT NULL,
    account_non_locked  VARCHAR(40)     NOT NULL
);

CREATE TABLE game_history(
	game_history_id 	SERIAL			NOT NULL,
	username            VARCHAR(40)     NOT NULL,
	game_id             INTEGER         NOT NULL,
	profit				INTEGER			NOT NULL,
	best_hand			VARCHAR(40)		NOT NULL
);

CREATE TABLE games(
    game_id		SERIAL	NOT NULL,
    date 		DATE	NOT NULL
);

ALTER TABLE users ADD CONSTRAINT user_pk PRIMARY KEY (username);
ALTER TABLE games ADD CONSTRAINT game_pk PRIMARY KEY (game_id);
ALTER TABLE game_history ADD CONSTRAINT game_history_pk PRIMARY KEY (game_history_id);

ALTER TABLE game_history ADD CONSTRAINT game_history_fk_users FOREIGN KEY (username) REFERENCES users;
ALTER TABLE game_history ADD CONSTRAINT game_history_fk_games FOREIGN KEY (game_id) REFERENCES games;
