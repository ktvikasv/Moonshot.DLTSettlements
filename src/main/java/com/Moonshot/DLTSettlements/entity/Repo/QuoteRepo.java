package com.Moonshot.DLTSettlements.entity.Repo;

import com.Moonshot.DLTSettlements.entity.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuoteRepo extends JpaRepository<Quote,Integer> {
}
