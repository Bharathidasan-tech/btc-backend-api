package com.btc.app.repository;

import com.btc.app.model.Wallet;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Data Repository: WalletRepository
 * @author Bharathidasan
 *
 */
@Repository 
public interface WalletRepository extends JpaRepository<Wallet, Integer> {
	

}
