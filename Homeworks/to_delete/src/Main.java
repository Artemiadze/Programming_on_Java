import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Elevator {
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

class Building {
    private final List<Elevator> elevators;

    public Building(int numElevators) {
        elevators = new ArrayList<>();
        for (int i = 0; i < numElevators; i++) {
            elevators.add(new Elevator(1, i+1));        // по умолчанию любой лифт на 1 этаже
        }
    }

    // Вызывается для вызова лифта на определенный этаж в здании.
    // Он находит ближайший лифт к этажу, к которому вызван лифт, и добавляет запрос на этот этаж в выбранный лифт.
    public void requestElevator(int floor) {
        Elevator closestElevator = elevators.get(0);
        int minDistance = Math.abs(closestElevator.getCurrentFloor() - floor);

        for (Elevator elevator : elevators) {
            int distance = Math.abs(elevator.getCurrentFloor() - floor);
            if (distance < minDistance) {
                minDistance = distance;
                closestElevator = elevator;
            }
        }

        System.out.println("Elevator called to floor " + floor);
        closestElevator.addRequest(floor);
    }
}

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
