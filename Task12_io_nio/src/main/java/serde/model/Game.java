package serde.model;

import java.io.Serializable;

public class Game implements Serializable {

    private int killedMonsters;
    private int collectedTreasures;

    public Game() {
        this.killedMonsters = 0;
        this.collectedTreasures = 0;
    }

    public void setHitMonster(){
        killedMonsters++;
        System.out.println("Monster killed! Total killed monsters: " + killedMonsters);
    }

    public void setCollectedTreasures(){
        collectedTreasures++;
        System.out.println("Treasure collected! Total collected treasures: " + collectedTreasures);
    }

    public int getKilledMonsters(){
        return killedMonsters;
    }

    public int getCollectedTreasures(){
        return collectedTreasures;
    }
}
