package com.movie.theater.service.impl;

import com.movie.theater.model.entity.Invoice;
import com.movie.theater.model.request.InvoiceRequest;
import com.movie.theater.model.response.InvoiceResponse;
import com.movie.theater.repository.InvoiceRepository;
import com.movie.theater.service.InvoiceService;
import com.movie.theater.service.mapper.InvoiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    private final InvoiceRepository invoiceRepository;
    private final InvoiceMapper invoiceMapper;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository, InvoiceMapper invoiceMapper) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceMapper = invoiceMapper;
    }

    @Override
    public List<InvoiceResponse> findAll() {
        List<InvoiceResponse> invoiceResponseList = new ArrayList<>();
        for (Invoice item: invoiceRepository.findAll()
             ) {
            InvoiceResponse invoiceResponse = invoiceMapper.mapInvoiceEntity(item);
            invoiceResponseList.add(invoiceResponse);
        }
        return invoiceResponseList;
    }

    @Override
    public Invoice findOne(String invoiceId) {
        return invoiceRepository.findById(invoiceId).get();
    }

    @Override
    public Invoice findByAccountId(String accountId) {
        return invoiceRepository.findByAccountId(accountId);
    }

    @Override
    public InvoiceResponse create(InvoiceRequest invoiceRequest) {
        Invoice newInvoice = new Invoice();
        newInvoice = invoiceMapper.mapInvoiceRequest(invoiceRequest);
        return invoiceMapper.mapInvoiceEntity(invoiceRepository.save(newInvoice));
    }
}
