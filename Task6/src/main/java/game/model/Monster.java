package game.model;

public class Monster extends Character{
    public Monster() {
        generateHp();
    }

    @Override
    protected void generateHp(){
        hp = generateRandomNumber(5, 100);
    }

    @Override
    public String toString(){
        return "Monster (НР: " + hp + ")";
    }
}
