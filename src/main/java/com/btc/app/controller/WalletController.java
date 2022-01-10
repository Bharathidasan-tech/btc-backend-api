package com.btc.app.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.btc.app.common.constant.ApiConstant;
import com.btc.app.model.Wallet;
import com.btc.app.services.WalletService;




/**
 * Controller: WalletController
 * @author Bharathidasan
 *
 */
@RestController
@RequestMapping("/api/btc/")
public class WalletController {
	
	@Autowired	
    private WalletService walletService;
	
	
	@GetMapping(value = ApiConstant.GET_WALLET_HISTORY, headers = ApiConstant.REQ_HEADER_JSON_ACCEPT)
	public ResponseEntity<List<Wallet>> getWalletHistory(@RequestParam String startDatetime,
			@RequestParam String endDatetime){
		Date startDate=null;
		Date endDate=null;
		try {
			startDate = new SimpleDateFormat(ApiConstant.DATE_FORMAT).parse(startDatetime);
			endDate=new SimpleDateFormat(ApiConstant.DATE_FORMAT).parse(endDatetime);
		} catch (ParseException e) {
			
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			
		}
		
		return walletService.findByDatetimeBetween(startDate, endDate);	
		
	}
	
	
	@PostMapping(value=ApiConstant.SAVE_URL,headers = ApiConstant.REQ_HEADER_JSON_ACCEPT)
	public ResponseEntity<Wallet> saveWalletRecord(@RequestBody Wallet wallet){
		   
		   return walletService.saveWalletRecord(wallet);
	   }

}
