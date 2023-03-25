package com.Moonshot.DLTSettlements.entity.Repo;

import com.Moonshot.DLTSettlements.entity.LegalEntity;
import com.Moonshot.DLTSettlements.entity.TradeObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TradeObjectRepo  extends JpaRepository<TradeObject,Integer> {
    List<TradeObject> findTradeObjectByStatus(String status);
}
