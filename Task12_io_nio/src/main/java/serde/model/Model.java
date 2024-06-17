package serde.model;

public interface Model {

    void startNewGame();
    void loadGame(String file);
    public int hitMonster();
    public int collectTreasures();
    public String saveGame(String file);
}
