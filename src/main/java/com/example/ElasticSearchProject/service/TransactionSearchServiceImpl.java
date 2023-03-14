package com.example.ElasticSearchProject.service;

import com.example.ElasticSearchProject.entity.TransactionData;
import com.example.ElasticSearchProject.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionSearchServiceImpl implements TransactionSearchService {

    private TransactionRepository transactionRepository;

    @Autowired
    public TransactionSearchServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<TransactionData> findByDescription(String description) {
        return transactionRepository.findByDescription(description);
    }

    @Override
    public List<TransactionData> findByInvoiceNo(String invoiceNo) {
        return transactionRepository.findByInvoiceNo(invoiceNo);
    }

    @Override
    public List<TransactionData> findByCustomerID(long customerID) {
        return transactionRepository.findByCustomerID(customerID);
    }

    @Override
    public List<TransactionData> findByCountry(String country) {
        return transactionRepository.findByCountry(country);
    }

    @Override
    public List<TransactionData> findByStockCode(String stockCode) {
        return transactionRepository.findByStockCode(stockCode);
    }

    @Override
    public List<TransactionData> findByCustomerIDAndCountry(long customerID, String country) {
        return transactionRepository.findByCustomerIDAndCountry(customerID, country);
    }
}