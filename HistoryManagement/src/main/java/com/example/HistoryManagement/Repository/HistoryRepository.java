package com.example.HistoryManagement.Repository;

import com.example.HistoryManagement.Entity.HistoryData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepository extends MongoRepository<HistoryData, String> {
    List<HistoryData> findAllByUserId(String userId);
}
