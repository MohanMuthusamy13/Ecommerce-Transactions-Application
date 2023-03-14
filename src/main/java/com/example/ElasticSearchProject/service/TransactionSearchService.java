package com.example.ElasticSearchProject.service;

import com.example.ElasticSearchProject.entity.TransactionData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransactionSearchService {

    List<TransactionData> findByDescription(String description);
    List<TransactionData> findByInvoiceNo(String invoiceNo);
    List<TransactionData> findByCustomerID(long customerID);
    List<TransactionData> findByCountry(String country);
    List<TransactionData> findByStockCode(String stockCode);
    List<TransactionData> findByCustomerIDAndCountry(long customerID, String country);
}