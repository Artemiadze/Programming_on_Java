import java.util.ArrayList;
import java.util.List;

public class Building {
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
