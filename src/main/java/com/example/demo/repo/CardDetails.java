package com.example.demo.repo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="CardDetails")
public class CardDetails {
	
	@Id
	@Column(nullable=false)
	private Long CardNumber;
	
	@Column(nullable=false)
	private float balance;
	
	public CardDetails() {
		// TODO Auto-generated constructor stub
	}
	
	public float getBalance() {
		return balance;
	}
	public Long getCardNumber() {
		return CardNumber;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	
	public void setCardNumber(Long cardNumber) {
		CardNumber = cardNumber;
	}
	
	
}
