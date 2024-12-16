import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Elevator {
    private int currentFloor;
    private boolean moving;
    private final List<Integer> requests;       // запросы
    private final int elevatorNumber;
    private int targetFloor;
    private final List<Integer> intermediateFloors;


    public Elevator(int initialFloor, int elevatorNumber) {
        this.currentFloor = initialFloor;
        this.intermediateFloors = new ArrayList<>();
        this.moving = false;        // Лифт не едет
        this.requests = new ArrayList<>();
        this.targetFloor = 1;
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

    public void addTargetFloor(int floor) {
        intermediateFloors.add(floor);
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
                if (requests.size() > 0) {
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
            }
            System.out.println("Elevator " + elevatorNumber + " heading to final destination floor " + targetFloor);

            while (currentFloor != targetFloor) {
                if (targetFloor > currentFloor) {
                    System.out.println("Elevator " + elevatorNumber + " moving up to floor " + targetFloor);
                } else {
                    System.out.println("Elevator " + elevatorNumber + " moving down to floor " + targetFloor);
                }
                currentFloor = targetFloor;
            }
            System.out.println("Elevator " + elevatorNumber + " arrived at destination floor " + currentFloor);
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
        Random rand = new Random();
        Elevator selectedElevator = elevators.get(rand.nextInt(elevators.size())); // выбираем случайный лифт
        int targetFloor = rand.nextInt(10) + 1; // генерируем случайный целевой этаж
        System.out.println("Elevator called to floor " + floor + " with destination floor " + targetFloor);
        selectedElevator.addTargetFloor(targetFloor);
        selectedElevator.addRequest(floor);
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
