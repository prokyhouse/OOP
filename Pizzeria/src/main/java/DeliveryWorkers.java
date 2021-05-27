import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class DeliveryWorkers {
    final Lock lock;
    private final List<Future<?>> orders;

    DeliveryWorkers() {
        orders = new ArrayList<>();
        lock = new ReentrantLock(true);
    }

    List<Future<?>> getOrders() {
        return orders;
    }

    void run(Employees employees, PizzeriaOverview pizzeriaOverview) {

        pizzeriaOverview.setNumberOfDeliveryWorkers(employees.getNumberOfDeliveryWorkers());
        ExecutorService executor = Executors.newFixedThreadPool(employees.getNumberOfDeliveryWorkers());

        List<DeliveryWorker> deliveryWorkers = employees.getDeliveryWorkers();
        for (DeliveryWorker deliveryWorker : deliveryWorkers) {
            deliveryWorker.setDeliveryWorkers(this);
            Future<?> future = executor.submit(deliveryWorker);
            orders.add(future);
        }
    }
}
