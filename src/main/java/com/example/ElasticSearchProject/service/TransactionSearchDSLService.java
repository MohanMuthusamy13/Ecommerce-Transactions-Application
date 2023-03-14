package com.example.ElasticSearchProject.service;

import co.elastic.clients.util.DateTime;
import com.example.ElasticSearchProject.entity.TransactionData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransactionSearchDSLService {
    List<TransactionData> getEcommerceTransactionsByCountry(String country);
    List<TransactionData> getEcommerceTransactionsByCustomerID(long customerID);
    long getTransactionsCountByCustomerID(long customerID);
    List<TransactionData> getTransactionsByContent(String content);
    long getTransactionsCountByDescription(String description);
    List<TransactionData> getTransactionsByContentAndCountry(String content, String country);
    List<TransactionData> getTransactions(String content, String country,
                                               DateTime startDate, DateTime endDate);
}