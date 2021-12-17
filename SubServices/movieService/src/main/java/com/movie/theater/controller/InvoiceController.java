package com.movie.theater.controller;

import com.movie.theater.model.entity.Invoice;
import com.movie.theater.model.request.InvoiceRequest;
import com.movie.theater.model.response.InvoiceResponse;
import com.movie.theater.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    private final InvoiceService invoiceService;

    @Autowired
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping(value = "/get-invoices")
    public List<InvoiceResponse> getInvoices(){
        return invoiceService.findAll();
    }

    @GetMapping(value = "/{invoiceId}")
    public Invoice getInvoice(@PathVariable("invoiceId") String invoiceId) {
        return invoiceService.findOne(invoiceId);
    }

    @GetMapping(value = "/account/{accountId}")
    public Invoice getInvoiceByAccount(@PathVariable("accountId") String accountId) {
        return invoiceService.findByAccountId(accountId);
    }

    @PostMapping(value = "/post")
    public InvoiceResponse createInvoice(@RequestBody InvoiceRequest invoiceRequest) {
        return invoiceService.create(invoiceRequest);
    }
}
