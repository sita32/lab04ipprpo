package com.autoservice.model;

public class RepairOrder {

    private final String id;              
    private final Car car;                
    private final Customer customer;      
    private final String description;     
    private RepairStatus repairStatus;    
    private boolean completed;            

    public RepairOrder(String id, Car car, Customer customer, String description) {
        this.id = id;
        this.car = car;
        this.customer = customer;
        this.description = description;
        this.repairStatus = RepairStatus.NEW; 
        this.completed = false;               
    }

    public String getId() {
        return id;
    }

    public Car getCar() {
        return car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getDescription() {
        return description;
    }

    public RepairStatus getRepairStatus() {
        return repairStatus;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setRepairStatus(RepairStatus repairStatus) {
        this.repairStatus = repairStatus;
    }

    public void markCompleted() {
        this.completed = true;
    }

    @Override
    public String toString() {
        return "Заказ " + id + ": " + description
                + " | ремонт: " + repairStatus
                + " | завершён: " + completed;
    }
}
