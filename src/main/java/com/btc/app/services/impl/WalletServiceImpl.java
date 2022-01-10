package com.btc.app.services.impl;



import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.btc.app.common.constant.ApiConstant;
import com.btc.app.model.Wallet;
import com.btc.app.repository.WalletDao;
import com.btc.app.repository.WalletRepository;
import com.btc.app.services.WalletService;

/**
 * Class Name: WalletServiceImpl
 * @author Bharathidasan
 *
 */
@Service
public class WalletServiceImpl implements WalletService {
	
	@Autowired
	private WalletRepository walletRepository;
	
	@Autowired
	private WalletDao walletDao;
	
	@Override
	public ResponseEntity<Wallet> saveWalletRecord(Wallet wallet) {
				
        if(wallet.getId() ==null || ApiConstant.NULL_STR_VAL.equals(String.valueOf(wallet.getId()))) {
			
        	walletRepository.save(wallet);
			return new ResponseEntity<>(wallet,HttpStatus.CREATED);
		}
		
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		
	}


	@Override
	public ResponseEntity<List<Wallet>> findByDatetimeBetween(Date startDatetime, Date endDatetime) {
		
		Timestamp startDate=new Timestamp(startDatetime.getTime());
		Timestamp endDate=new Timestamp(endDatetime.getTime());
		
		return new ResponseEntity<List<Wallet>>(walletDao.findByDatetimeBetween(startDate, endDate),HttpStatus.OK);
		
		}
	
	



}
