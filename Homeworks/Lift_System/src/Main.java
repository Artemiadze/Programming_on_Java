import java.util.Random;


public class Main {
    public static void main(String[] args) {

        Building building = new Building(2); // создается здание с двумя лифтами

        Random rand = new Random();
        while (true){
            int floor = rand.nextInt(10) + 1;
            building.requestElevator(floor);        // генерируются случайные вызовы лифтов на различные этажи в здании
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}