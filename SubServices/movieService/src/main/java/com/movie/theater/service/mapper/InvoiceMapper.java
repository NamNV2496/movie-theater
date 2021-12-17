package com.movie.theater.service.mapper;

import com.movie.theater.model.entity.Invoice;
import com.movie.theater.model.request.InvoiceRequest;
import com.movie.theater.model.response.InvoiceResponse;
import org.springframework.stereotype.Component;

@Component
public class InvoiceMapper {

    public Invoice mapInvoiceRequest(InvoiceRequest invoiceRequest) {
        Invoice result = new Invoice();
        result.setAccountId(invoiceRequest.getAccountId());
        result.setAddScore(invoiceRequest.getAddScore());
        result.setBookingDate(invoiceRequest.getBookingDate());
        result.setMovieName(invoiceRequest.getMovieName());
        result.setScheduleShow(invoiceRequest.getScheduleShow());
        result.setSeat(invoiceRequest.getSeat());
        result.setStatus(invoiceRequest.getStatus());
        result.setTotalMoney(invoiceRequest.getTotalMoney());
        result.setUserScore(invoiceRequest.getUserScore());
        return result;
    }

    public InvoiceResponse mapInvoiceEntity(Invoice invoice) {
        InvoiceResponse result = new InvoiceResponse();
        result.setInvoiceId(invoice.getInvoiceId());
        result.setAccountId(invoice.getAccountId());
        result.setAddScore(invoice.getAddScore());
        result.setBookingDate(invoice.getBookingDate());
        result.setMovieName(invoice.getMovieName());
        result.setScheduleShow(invoice.getScheduleShow());
        result.setSeat(invoice.getSeat());
        result.setStatus(invoice.getStatus());
        result.setTotalMoney(invoice.getTotalMoney());
        result.setUserScore(invoice.getUserScore());
        return result;
    }
}
