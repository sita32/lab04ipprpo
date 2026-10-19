package com.autoservice.service;

import com.autoservice.model.RepairOrder;
import com.autoservice.model.RepairStatus;
import com.autoservice.repository.RepairRepository;

public class RepairService {

    private final RepairRepository repairRepository;

    public RepairService(RepairRepository repairRepository) { 
        this.repairRepository = repairRepository; 
    }

    public RepairOrder createOrder(RepairOrder order) {
        repairRepository.save(order);
        return order;
    }

    public void acceptCar(String orderId) {
        RepairOrder order = requireOrder(orderId);
        if (order.isCompleted()) {
            throw new IllegalStateException("Нельзя принять автомобиль: заказ уже завершён");
        }
        if (order.getRepairStatus() != RepairStatus.NEW) {
            throw new IllegalStateException("Нельзя принять автомобиль: заказ уже в работе");
        }
        order.setRepairStatus(RepairStatus.IN_PROGRESS);
        repairRepository.save(order);
    }

    public void changeRepairStatus(String orderId, RepairStatus newStatus) {
        RepairOrder order = requireOrder(orderId); 
        if (order.isCompleted()) {
            throw new IllegalStateException("Нельзя менять статус: заказ уже завершён");
        }
        order.setRepairStatus(newStatus);
        repairRepository.save(order);
    }


    public void completeOrder(String orderId) {
        RepairOrder order = requireOrder(orderId);
        if (order.isCompleted()) {
            throw new IllegalStateException("Заказ уже завершён");
        }
        if (order.getRepairStatus() != RepairStatus.DONE) {
            throw new IllegalStateException("Нельзя завершить заказ: ремонт ещё не выполнен");
        }
        order.markCompleted();
        repairRepository.save(order);
    }

    public RepairOrder getOrder(String orderId) {
        return requireOrder(orderId);
    }

    private RepairOrder requireOrder(String orderId) {
        RepairOrder order = repairRepository.findById(orderId);
        if (order == null) {
            throw new IllegalArgumentException("Заказ не найден: " + orderId);
        }
        return order;
    }
}
