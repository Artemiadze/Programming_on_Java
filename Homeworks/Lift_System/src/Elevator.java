import java.util.ArrayList;
import java.util.List;

public class Elevator {
    private int currentFloor;
    private boolean moving;
    private final List<Integer> requests;       // запросы
    private final int elevatorNumber;

    public Elevator(int initialFloor, int elevatorNumber) {
        this.currentFloor = initialFloor;
        this.moving = false;        // Лифт не едет
        this.requests = new ArrayList<>();
        this.elevatorNumber = elevatorNumber;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    // добавляет запрос на вызов лифта на определенный этаж в список запросов
    public void addRequest(int floor) {
        requests.add(floor);
        if (!moving) {
            move();
        }
    }

    // запускает новый поток, который перемещает лифт к нужным этажам
    private void move() {
        // запускает новый поток для выполнения цикла перемещения лифта
        // многопоточность через лямбда выражения
        new Thread(() -> {
            moving = true;      // Лифт едет
            while (!requests.isEmpty()) {
                // лифт едет
                int requestFloor = requests.get(0);       // Извлекаем первый элемент из списка ожидания
                if (requestFloor > currentFloor) {
                    // лифт едет на верх
                    System.out.println("Elevator " + elevatorNumber + " moving up to floor " + requestFloor);
                    currentFloor = requestFloor;
                } else if (requestFloor < currentFloor) {
                    // лифт едет вниз
                    System.out.println("Elevator " + elevatorNumber + " moving down to floor " + requestFloor);
                    currentFloor = requestFloor;
                }
                // лифт приехал и готов принять пассажиров
                System.out.println("Elevator " + elevatorNumber + " arrived at floor " + currentFloor);
                requests.remove(0);
            }
            moving = false;         // лифт пуст
        }).start();
    }
}
