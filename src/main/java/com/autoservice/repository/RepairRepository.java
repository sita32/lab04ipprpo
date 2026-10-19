package com.autoservice.repository;

import com.autoservice.model.RepairOrder;


public interface RepairRepository {

    void save(RepairOrder order);
    RepairOrder findById(String id);
}
