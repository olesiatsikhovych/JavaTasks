package game.model;

import java.util.Random;

 abstract class Character {
     protected int hp;

    public int getHp(){
        return hp;
    }

    protected abstract void generateHp();

    protected int generateRandomNumber(int minHp, int maxHp){
        Random random = new Random();
        hp = random.nextInt(maxHp - minHp + 1) + minHp;
        return hp;
    }
}
