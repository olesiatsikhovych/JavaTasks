package serde.model;

import org.junit.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {

    private Game game = new Game();

    @Test
    public void testSetHitMonster(){
        game.setHitMonster();
        assertEquals(1, game.getKilledMonsters());
    }

    @Test
    public void testSetCollectTreasures(){
        game.setCollectedTreasures();
        assertEquals(1, game.getCollectedTreasures());
    }
}
