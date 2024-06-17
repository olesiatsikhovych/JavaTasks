package serde.model;

import java.io.*;

public class ConsoleModel implements Model {

    private Game game;

    public ConsoleModel() {
        this.game = new Game();
    }

    @Override
    public void startNewGame() {
        game = new Game();
        System.out.println("New game started!");
    }

    @Override
    public void loadGame(String file) {
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))){
            game = (Game) objectInputStream.readObject();
            System.out.println("Game loaded successfully!");
        }
        catch (FileNotFoundException e){
            System.out.println("No saved game found.");
        }
        catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        System.out.println("Number of killed monster: " + game.getKilledMonsters());
        System.out.println("Number of collected treasures: " + game.getCollectedTreasures());
    }

    @Override
    public int hitMonster() {
        game.setHitMonster();
        return game.getKilledMonsters();
    }

    @Override
    public int collectTreasures() {
        game.setCollectedTreasures();
        return game.getCollectedTreasures();
    }

    @Override
    public String saveGame(String file) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))){
            objectOutputStream.writeObject(game);
            return "Game saved succesfully!";
        }catch (IOException e){
            e.printStackTrace();
            return "Failed to save the game.";
        }
    }

    public Game getGame() {
        return game;
    }
}
