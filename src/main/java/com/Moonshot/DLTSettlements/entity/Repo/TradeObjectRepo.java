package com.Moonshot.DLTSettlements.entity.Repo;

import com.Moonshot.DLTSettlements.entity.LegalEntity;
import com.Moonshot.DLTSettlements.entity.TradeObject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradeObjectRepo  extends JpaRepository<TradeObject,String> {
}
