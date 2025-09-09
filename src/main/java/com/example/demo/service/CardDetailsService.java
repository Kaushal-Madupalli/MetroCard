package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repo.CardDetails;
import com.example.demo.repo.CardDetailsRepository;

@Service
public class CardDetailsService {
	@Autowired
	CardDetailsRepository cardDetailsRepository;
	
	public void adduser(CardDetails cardDetails)
	{
		 cardDetailsRepository.save(cardDetails);
	}
	
	public Optional<CardDetails> getDetails(Long cardNo)
	{
		return cardDetailsRepository.findById(cardNo);
	}
	
	public boolean validateCard(Long CardNo)
	{
		 Optional<CardDetails> cd=cardDetailsRepository.findById(CardNo);
		if(cd==null)
		{
			return false;
		}
		return true;
	}
	
	public List<CardDetails> getAll()
	{
		return cardDetailsRepository.findAll();
	}
	
	public float fetchBalance(Long cardNo)
	{
		Optional<CardDetails> card=cardDetailsRepository.findById(cardNo);
		if(card.isPresent())
		{
			return card.get().getBalance();
		}
		else
		{
			return 0;
		}
	}
	
	public void setBalance(Long cardNo,float newBalance)
	{
		Optional<CardDetails> card=cardDetailsRepository.findById(cardNo);
		if(card.isPresent())
		{
			
			card.get().setBalance(newBalance);
		}

	}


}
