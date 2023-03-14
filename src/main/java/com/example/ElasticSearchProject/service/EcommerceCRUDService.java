package com.example.ElasticSearchProject.service;

import com.example.ElasticSearchProject.entity.TransactionData;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EcommerceCRUDService {
    List<TransactionData> getAllEcommerceData();
    TransactionData getEcommerceDataById(String id);
    TransactionData saveEcommerceData(TransactionData ecommerceData);
    TransactionData updateEcommerceDate(String id, TransactionData ecommerceData);
    void deleteEcommerceData(String id);
    Page<TransactionData> getAllEcommercePagination(int pageNumber, int pageSize);
}