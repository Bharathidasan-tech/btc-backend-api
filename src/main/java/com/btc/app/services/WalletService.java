package com.btc.app.services;


import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.btc.app.model.Wallet;




/**
 * Interface: WalletService
 * @author Bharathidasan
 *
 */
public interface WalletService {
	
	
	
	
	/**
	 * @param startDatetime
	 * 
	 * @param endDatetime
	 * @return List
	 */
	public ResponseEntity<List<Wallet>> findByDatetimeBetween(Date startDatetime, Date endDatetime);
	
	/**
	 * @return ResponseEntity<Wallet>
	 */
	public ResponseEntity<Wallet> saveWalletRecord(Wallet wallet);
	
	

	

}
