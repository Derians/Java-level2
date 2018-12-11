import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Ivan Chaykin
 * Date: 11.12.2018
 * Time: 10:59
 */
public class Team {

    private String teamName;
    private Person[] team;
    private double result;

    private List<String> swimmingResult = new ArrayList<>();
    private List<String> runningResult = new ArrayList<>();
    private List<String> jumpingResult = new ArrayList<>();

    Team(String teamName, Person[] team) {
        this.teamName = teamName;
        this.team = team;
    }

    public void doIt(Obstacles obstacle) {
        Random random = new Random();

        double min;
        double max;
        int distance;

        for (Person person: team) {
            switch (obstacle.getObstaclesName()){
                case "Water":
                    min = person.getSwimSpeed() - 0.5;
                    max = person.getSwimSpeed();
                    distance = obstacle.getObstaclesLength();
                    result = distance / min + (max - min) * random.nextDouble();
                    swimmingResult.add(String.format("%s swam %s m for %.2f sec", person.getName(), distance, result));
                    break;
                case "Track":
                    min = person.getRunSpeed() - 0.5;
                    max = person.getRunSpeed();
                    distance = obstacle.getObstaclesLength();
                    result = distance / min + (max - min) * random.nextDouble();
                    runningResult.add(String.format("%s run %s m for %.2f sec", person.getName(), distance, result));
                    break;
                case "Pit":
                    min = person.getJumpLength() - 0.5;
                    max = person.getJumpLength();
                    distance = obstacle.getObstaclesLength();
                    result = min + (max - min) * random.nextDouble() * random.nextDouble();
                    jumpingResult.add(String.format("%s jumped %.2f m uot of %s m", person.getName(), result, distance));
            }
        }
    }

    public void showResults() {

        System.out.println(teamName + " results");

        System.out.println("\nSwimming results: \n");
        for (String s: swimmingResult) {
            System.out.println(s);
        }
        System.out.println("\nRunning results: \n");
        for (String s: runningResult) {
            System.out.println(s);
        }
        System.out.println("\nJumping results: \n");
        for (String s: jumpingResult) {
            System.out.println(s);
        }

    }
}
