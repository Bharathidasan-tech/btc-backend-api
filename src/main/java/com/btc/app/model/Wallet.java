package com.btc.app.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * Entity Class: Wallet
 * @author Bharathidasan
 *
 */
@Entity
@Table(name="btc_wallet")
public class Wallet implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
    private Integer id;

    private Double amount;
   
    private Timestamp datetime;

    public Wallet() {
    }




	/**
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}


	/**
	 * @return the datetime
	 */
	public Date getDatetime() {
		return datetime;
	}


	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}


	/**
	 * @param datetime the datetime to set
	 */
	public void setDatetime(Timestamp datetime) {
		this.datetime = datetime;
	}




	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}




	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}




	/**
	 * @param id
	 * @param amount
	 * @param datetime
	 */
	public Wallet(Integer id, Double amount, Timestamp datetime) {
		this.id = id;
		this.amount = amount;
		this.datetime = datetime;
	}




	/**
	 * @param amount
	 * @param datetime
	 */
	public Wallet(Double amount, Timestamp datetime) {
		this.amount = amount;
		this.datetime = datetime;
	}

    
}
