package game.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private static final Logger logger = LogManager.getLogger(Room.class);

    private List<Door> doors;
    private Hero hero;

    private List<Door> monstersDoors;
    private List<Door> artifactsDoors;

    public Room(){
        doors = new ArrayList<Door>();
        monstersDoors = new ArrayList<Door>();
        artifactsDoors = new ArrayList<Door>();

        for (int i = 0; i < 10; i++){
            Door door = new Door();
            door.number = i + 1;
            doors.add(door);

            Character character = door.getCharacter();
            if (character instanceof Monster){
                monstersDoors.add(door);
            }
            else if (character instanceof Artifact){
                artifactsDoors.add(door);
            }
        }
        hero = new Hero();
    }

    public String describeDoors(){
        logger.info("start method describeDoors");
        StringBuilder stringBuilder = new StringBuilder();
       for (int i = 0; i < doors.size(); i++){
          stringBuilder.append("Door ").append(i + 1).append(": ").append(doors.get(i).getCharacter()).append("\n");
        }
        logger.info("finish method describeDoors");
        return stringBuilder.toString();
    }

    public int countDeadlyDoors(){
        logger.info("start method countDeadlyDoors");
        int count = 0;
        for (Door door : doors){
            if (door.getCharacter() instanceof Monster && door.getCharacter().getHp() > 25){
                count++;
            }
        }
        logger.info("finish method countDeadlyDoors");
        return count;
    }

    public List<Door> getSafeDoorOrder(){
        logger.info("start method getSafeDoorOrder");
       if (isAlive()) {
           List<Door> safeOrder = new ArrayList<Door>(artifactsDoors);
           safeOrder.addAll(monstersDoors);
           logger.info("finish method getSafeDoorOrder - heroIsAlive");
           return safeOrder;
       }
       else {
        List<Door> list = new ArrayList<Door>();
           logger.info("finish method getSafeDoorOrder - heroIsDead");
        return list;
       }
    }

    public boolean isAlive(){
        int artifactHps = 0;
        for (Door artifactDoor : artifactsDoors) {
         artifactHps += artifactDoor.getCharacter().getHp();
        }
        int monsterHps = 0;
        for (Door monsterDoor : monstersDoors){
            monsterHps += monsterDoor.getCharacter().getHp();
        }
        int totalHp = hero.getHp() + artifactHps - monsterHps;
        return totalHp >= 0;

    }
}
