/**
 * Created by Ivan Chaykin
 * Date: 11.12.2018
 * Time: 10:57
 */
public class Lesson1 {

    public static void main(String[] args) {

//      Создаём массив препятствий
        Obstacles[] obstacles = {
                new Obstacles("Water", 25),
                new Obstacles("Track", 1500),
                new Obstacles("Pit", 5)};

//      Создаем полосу препятствий
        Course course = new Course(obstacles);

//      Создаём массив спортсменов
        Person[] persons = {
                new Person("Andrew", 1.22, 6.94, 5),
                new Person("Ashley", 1, 17.4, 4),
                new Person("Samantha", 1.86, 4.33, 5),
                new Person("David", 1.41, 5.13, 6)};

//      Создаем команду
        Team team = new Team("Team of champions", persons);

//      Просим команду пройти полосу
        course.doIt(team);

//      Показываем результаты
        team.showResults();
    }
}


