package game.model;

import java.util.Random;

public class Door {
    Character character;
    int number;

    public Door(){
        Random random = new Random();
        int randomValue = random.nextInt(2);

        if (randomValue == 0){
            character = new Monster();
        }
        else {
            character = new Artifact();
        }
        character.generateHp();
    }

    public Character getCharacter(){
        return character;
    }

    @Override
    public String toString() {
        return "" + number;
    }
}

