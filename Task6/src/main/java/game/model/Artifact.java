package game.model;

public class Artifact extends Character {
    public Artifact() {
        generateHp();
    }

    @Override
    protected void generateHp() {
      hp = generateRandomNumber(10, 80);
    }

    @Override
    public String toString(){
        return "Artifact (HP: " + hp + ")";
    }
}
