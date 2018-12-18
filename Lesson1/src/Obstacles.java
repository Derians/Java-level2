/**
 * Created by Ivan Chaykin
 * Date: 11.12.2018
 * Time: 11:59
 */
public class Obstacles {

    private String obstaclesName;
    private int obstaclesLength;

    Obstacles(String obstaclesName, int obstaclesLength) {
        this.obstaclesName = obstaclesName;
        this.obstaclesLength = obstaclesLength;
    }

    public String getObstaclesName() {
        return obstaclesName;
    }

    public int getObstaclesLength() {
        return obstaclesLength;
    }
}
