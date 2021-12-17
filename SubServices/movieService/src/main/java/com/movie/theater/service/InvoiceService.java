package com.movie.theater.service;

import com.movie.theater.model.entity.Invoice;
import com.movie.theater.model.request.InvoiceRequest;
import com.movie.theater.model.response.InvoiceResponse;

import java.util.List;

public interface InvoiceService {
    List<InvoiceResponse> findAll();
    Invoice findOne(String invoiceId);
    Invoice findByAccountId(String accountId);
    InvoiceResponse create(InvoiceRequest invoiceRequest);
}
