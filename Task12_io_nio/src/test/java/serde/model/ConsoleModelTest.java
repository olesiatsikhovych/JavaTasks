package serde.model;

import org.junit.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsoleModelTest {

    private ConsoleModel model = new ConsoleModel();

    private String file = "test.ser";

    @Test
    public void testHitMonster(){
        assertEquals(1, model.hitMonster());
    }

    @Test
    public void testCollectTreasures(){
        assertEquals(1, model.collectTreasures());
    }

    @Test
    public void testLoadGame(){
        Game game1 = new Game();

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(game1);
        }
        catch(IOException e){
            e.printStackTrace();
        }
        model.loadGame(file);
        assertEquals(0, model.getGame().getKilledMonsters());
        assertEquals(0, model.getGame().getCollectedTreasures());
    }

    @Test
    public void testSaveGame(){
        String result = model.saveGame(file);
        Game game = new Game();
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
            game = (Game) objectInputStream.readObject();
        }
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        assertEquals("Game saved succesfully!", result);
        assertEquals(0, game.getKilledMonsters());
        assertEquals(0, game.getCollectedTreasures());
    }
}
