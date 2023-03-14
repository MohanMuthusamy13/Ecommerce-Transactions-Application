package com.example.ElasticSearchProject.entity;

import co.elastic.clients.util.DateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(indexName = "ecommerce_sample_data")
public class TransactionData {

    @Id
    private String id;

    @Field(type = FieldType.Text, name = "Description")
    private String description;

    @Field(type = FieldType.Long, name = "Quantity")
    private long quantity;

    @Field(type = FieldType.Keyword, name = "InvoiceNo")
    private String invoiceNo;

    @Field(type = FieldType.Long, name = "CustomerID")
    private long customerID;

    @Field(type = FieldType.Double, name = "UnitPrice")
    private double unitPrice;

    @Field(type = FieldType.Keyword, name = "Country")
    private String country;

    @Field(type = FieldType.Date ,name = "InvoiceDate", pattern = "M/d/yyyy H:m")
    private DateTime invoiceDate;

    @Field(type = FieldType.Keyword, name = "StockCode")
    private String stockCode;

}