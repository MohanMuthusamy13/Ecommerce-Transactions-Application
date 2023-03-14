package com.example.ElasticSearchProject.service;


import com.example.ElasticSearchProject.entity.TransactionData;
import com.example.ElasticSearchProject.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EcommerceCRUDServiceImpl implements EcommerceCRUDService {

    private TransactionRepository transactionRepository;

    @Autowired
    public EcommerceCRUDServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<TransactionData> getAllEcommerceData() {
        List<TransactionData> ecommerceData = new ArrayList<>();
        Iterable<TransactionData> ecommerceDataIterable = transactionRepository.findAll();
        ecommerceDataIterable.forEach(ecommerceData::add);
        return ecommerceData;
    }

    @Override
    public TransactionData getEcommerceDataById(String id) {
        return transactionRepository
                .findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Data with the given id is not found"));
    }

    @Override
    public TransactionData saveEcommerceData(TransactionData ecommerceData) {
        return transactionRepository.save(ecommerceData);
    }

    @Override
    public TransactionData updateEcommerceDate(String id, TransactionData updatedEcommerceData) {
        TransactionData ecommerceData = transactionRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Data with the id is not present")
        );

        ecommerceData.setCountry(updatedEcommerceData.getCountry());
        ecommerceData.setDescription(updatedEcommerceData.getDescription());
        ecommerceData.setInvoiceDate(updatedEcommerceData.getInvoiceDate());
        ecommerceData.setQuantity(updatedEcommerceData.getQuantity());
        ecommerceData.setInvoiceNo(updatedEcommerceData.getInvoiceNo());
        ecommerceData.setStockCode(updatedEcommerceData.getStockCode());
        ecommerceData.setUnitPrice(updatedEcommerceData.getUnitPrice());
        ecommerceData.setCustomerID(updatedEcommerceData.getCustomerID());

        return transactionRepository.save(ecommerceData);
    }

    @Override
    public void deleteEcommerceData(String id) {
        transactionRepository.deleteById(id);
    }

    @Override
    public Page<TransactionData> getAllEcommercePagination(int pageNumber, int pageSize) {
        Sort sort = Sort.by(Sort.Direction.ASC, "InvoiceDate");
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        return transactionRepository.findAll(pageable);
    }
}