/**
 * 
 */
package com.btc.app.repository;

import java.sql.Timestamp;
import java.util.List;

import com.btc.app.model.Wallet;

/**
 * @author Bharathidasan
 *
 */
public interface WalletDao {
	
	List<Wallet>  findByDatetimeBetween(Timestamp startDatetime, Timestamp endDatetime);

}
