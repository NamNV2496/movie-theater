package com.movie.theater.repository;

import com.movie.theater.model.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, String> {
    @Query("select i from Invoice i where i.accountId = ?1")
    Invoice findByAccountId(String accountId);
}
