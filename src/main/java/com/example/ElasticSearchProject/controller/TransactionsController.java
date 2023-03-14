package com.example.ElasticSearchProject.controller;

import co.elastic.clients.util.DateTime;
import com.example.ElasticSearchProject.entity.TransactionData;
import com.example.ElasticSearchProject.service.TransactionSearchDSLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class TransactionsController {

    private TransactionSearchDSLService transactionSearchDSLService;

    @Autowired
    public TransactionsController(TransactionSearchDSLService transactionSearchDSLService) {
        this.transactionSearchDSLService = transactionSearchDSLService;
    }

    @GetMapping("/transactions")
    public List<TransactionData> getTransactionsByContent(
            @RequestParam(value = "q", required = false) String content
    ) {
        return transactionSearchDSLService.getTransactionsByContent(content);
    }

    @GetMapping("/geoRelatedTransactions")
    public List<TransactionData> getEcommerceDataByCountry(
            @RequestParam(value = "q", required = false) String country
    ) {
        return transactionSearchDSLService.getEcommerceTransactionsByCountry(country);
    }

    @GetMapping
    public List<TransactionData> getEcommerceTransactionsByCustomerID(
            @RequestParam("customerID") long customerID
    ) {
        return transactionSearchDSLService.getEcommerceTransactionsByCustomerID(customerID);
    }

    @GetMapping("/count")
    public long getTransactionsCountByCustomerID(
            @RequestParam("customerID") long customerID
    ) {
        return transactionSearchDSLService.getTransactionsCountByCustomerID(customerID);
    }

    @GetMapping("/countByDescription")
    public long getTransactionsCountByDescription(
            @RequestParam("description") String description
    ) {
        return transactionSearchDSLService.getTransactionsCountByDescription(description);
    }

    @GetMapping("/getContentByCountry")
    public List<TransactionData> getTransactionsByContentAndCountry(
            @RequestParam(value = "content") String content,
            @RequestParam(value = "country") String country
    ) {
        return transactionSearchDSLService.getTransactionsByContentAndCountry(content, country);
    }

    @GetMapping("/ByContentCountryAndDate")
    public List<TransactionData> getTransactionsByContentAndDate(
            @RequestParam(value = "content") String content,
            @RequestParam(value = "country") String country,
            @RequestParam(value = "date1") DateTime startDate,
            @RequestParam(value = "date2") DateTime endDate
    ) {
        return transactionSearchDSLService.getTransactions(content, country, startDate, endDate);
    }
}