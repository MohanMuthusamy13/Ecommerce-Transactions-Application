package com.example.ElasticSearchProject.repository;

import co.elastic.clients.util.DateTime;
import com.example.ElasticSearchProject.entity.TransactionData;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends ElasticsearchRepository<TransactionData, String> {

    List<TransactionData> findByDescription(String description);

    List<TransactionData> findByInvoiceNo(String invoiceNo);

    List<TransactionData> findByCustomerID(long customerID);

    List<TransactionData> findByCountry(String country);

    List<TransactionData> findByStockCode(String stockCode);

    List<TransactionData> findByCustomerIDAndCountry(long customerID, String country);

    @Query(value = """
            {
                "wildcard": {
                  "Country": {
                    "value": "*?0*"
                  }
                }
              }""")
    List<TransactionData> getEcommerceTransactionsByCountry(String country);


    @Query("""
            {
                "match": {
                  "CustomerID": ?0
                }
            }""")
    List<TransactionData> getEcommerceTransactionsByCustomerID(long customerID);

    @Query(value = """
            {
                "match": {
                  "CustomerID": ?0
                }
            }""", count = true)
    long getTransactionsCountByCustomerID(long customerID);


    @Query(value = """
            {
                "bool": {
                  "should": [
                    {
                      "match": {
                        "Description": "?0"
                      }
                    },
                    {
                      "wildcard": {
                        "Description": {
                          "value": "*?0*"
                        }
                      }
                    },
                    {
                      "fuzzy": {
                        "Description": {
                          "value": "?0"
                        }
                      }
                    }
                  ],
                  "minimum_should_match": 1
                }
              }""")
    List<TransactionData> getTransactionsByContent(String content);

    @Query(value = """
            {
                "match": {
                  "Description": "?0"
                }
            }""", count = true)
    long getTransactionsCountByDescription(String description);


    @Query("""
            {
                "bool": {
                  "must": [
                    {
                      "wildcard": {
                        "Description": {
                          "value": "*?0*"
                        }
                      }
                    }
                  ],
                  "should": [
                    {
                      "wildcard": {
                        "Country": {
                          "value": "*?0*"
                        }
                      }
                    }
                  ]
                }
              }""")
    List<TransactionData> getTransactionsByContentAndCountry(String content, String country);

    @Query("""
            {
                "bool": {
                  "must": [
                    {
                      "wildcard": {
                        "Description": {
                          "value": "*?0*"
                        }
                      }
                    }
                  ],
                  "should": [
                    {
                      "wildcard": {
                        "Country": {
                          "value": "*?1*"
                        }
                      }
                    }
                  ],
                  "filter": [
                    {
                      "range": {
                        "InvoiceDate": {
                          "gte": "?2",
                          "lte": "?3"
                        }
                      }
                    }
                  ]
                }
              }""")
    List<TransactionData> getTransactions(String content, String country,
                                               DateTime startDate, DateTime endDate);



}