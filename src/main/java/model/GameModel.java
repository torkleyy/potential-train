package model;

import database.DatabaseConnector;

public class GameModel extends Observable<GameObserver> {
    private final DatabaseConnector connector;

    public GameModel() {
        this.connector = new DatabaseConnector();
    }
}
