package com.example.ElasticSearchProject.service;

import co.elastic.clients.util.DateTime;
import com.example.ElasticSearchProject.entity.TransactionData;
import com.example.ElasticSearchProject.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionSearchDSLServiceImpl implements TransactionSearchDSLService {

    private TransactionRepository transactionRepository;

    @Autowired
    public TransactionSearchDSLServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<TransactionData> getEcommerceTransactionsByCountry(String country) {
        return transactionRepository.getEcommerceTransactionsByCountry(country);
    }

    @Override
    public List<TransactionData> getEcommerceTransactionsByCustomerID(long customerID) {
        return transactionRepository.getEcommerceTransactionsByCustomerID(customerID);
    }

    @Override
    public long getTransactionsCountByCustomerID(long customerID) {
        return transactionRepository.getTransactionsCountByCustomerID(customerID);
    }

    @Override
    public List<TransactionData> getTransactionsByContent(String content) {
        return transactionRepository.getTransactionsByContent(content);
    }

    @Override
    public long getTransactionsCountByDescription(String description) {
        return transactionRepository.getTransactionsCountByDescription(description);
    }

    @Override
    public List<TransactionData> getTransactionsByContentAndCountry(String content, String country) {
        return transactionRepository.getTransactionsByContentAndCountry(content, country);
    }

    @Override
    public List<TransactionData> getTransactions(String content, String country, DateTime startDate, DateTime endDate) {
        return transactionRepository.getTransactions(content, country, startDate, endDate);
    }
}