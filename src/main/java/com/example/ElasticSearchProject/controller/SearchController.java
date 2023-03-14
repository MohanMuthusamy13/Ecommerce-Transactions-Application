package com.example.ElasticSearchProject.controller;

import com.example.ElasticSearchProject.entity.TransactionData;
import com.example.ElasticSearchProject.service.TransactionSearchDSLService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Controller
@RequestMapping("/")
public class SearchController {

    private TransactionSearchDSLService transactionSearchDSLService;

    @Autowired
    public SearchController(TransactionSearchDSLService transactionSearchDSLService) {
        this.transactionSearchDSLService = transactionSearchDSLService;
    }

    @GetMapping("/search")
    public String getAllTransactions(Model model) {
        List<TransactionData> transactionData = transactionSearchDSLService.getTransactionsByContent("White");
        List<String> names = transactionData.stream().flatMap(transactionData1->{
            return Stream.of(transactionData1.getDescription());
        }).collect(Collectors.toList());
        log.info("product names {}", names);
        model.addAttribute("names", names);
        return "search";
    }

}