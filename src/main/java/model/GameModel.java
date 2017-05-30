package model;

import database.DatabaseConnector;
import observe.GameObserver;
import observe.Observable;

public class GameModel extends Observable<GameObserver> {
    private final DatabaseConnector connector;

    public GameModel() {
        this.connector = new DatabaseConnector();
    }
}
