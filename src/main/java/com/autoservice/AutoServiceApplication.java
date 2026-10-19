package com.autoservice;

import com.autoservice.model.Car;
import com.autoservice.model.Customer;
import com.autoservice.model.RepairOrder;
import com.autoservice.model.RepairStatus;
import com.autoservice.repository.InMemoryRepairRepository;
import com.autoservice.repository.RepairRepository;
import com.autoservice.service.RepairService;

public class AutoServiceApplication {

    public static void main(String[] args) {
        RepairRepository repository = new InMemoryRepairRepository(); 
        RepairService service = new RepairService(repository); 

        Car car = new Car("c1", "Toyota", "A123BC");
        Customer customer = new Customer("u1", "Иванов", "89001112233");
        RepairOrder order = new RepairOrder("o1", car, customer, "Замена масла");
        service.createOrder(order);

        System.out.println("Создан: " + service.getOrder("o1"));
        
        try {
            service.completeOrder("o1");
        } catch (IllegalStateException e) {
            System.out.println("Завершение запрещено: " + e.getMessage());
        }

        service.acceptCar("o1");
        System.out.println("Автомобиль принят: " + service.getOrder("o1"));

        service.changeRepairStatus("o1", RepairStatus.DONE);
        System.out.println("Ремонт выполнен: " + service.getOrder("o1"));

        service.completeOrder("o1");
        System.out.println("Заказ закрыт: " + service.getOrder("o1"));
    }
}
