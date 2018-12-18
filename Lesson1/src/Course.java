/**
 * Created by Ivan Chaykin
 * Date: 11.12.2018
 * Time: 10:59
 */
public class Course {

    private Obstacles[] obstacles;

    Course(Obstacles[] obstacles) {
        this.obstacles = obstacles;
    }

    public void doIt(Team team) {
        for (Obstacles obstacle : obstacles)
            team.doIt(obstacle);
    }
}
