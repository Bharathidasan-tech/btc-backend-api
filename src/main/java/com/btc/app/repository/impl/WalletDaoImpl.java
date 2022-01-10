/**
 * 
 */
package com.btc.app.repository.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.btc.app.model.Wallet;
import com.btc.app.repository.WalletDao;

/**
 * @author Bharathidasan
 *
 */
@Repository
public class WalletDaoImpl implements WalletDao {
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Wallet> findByDatetimeBetween(Timestamp startDatetime, Timestamp endDatetime) {
		
		Query qury=entityManager.createQuery("select wa.amount, wa.datetime  from Wallet wa where wa.datetime between :startDate and :endDate ORDER BY wa.id");
		qury.setParameter("startDate", startDatetime);
		qury.setParameter("endDate", endDatetime);
		
		List<Wallet> list=qury.getResultList();
		
		return list;
		
	}

}
