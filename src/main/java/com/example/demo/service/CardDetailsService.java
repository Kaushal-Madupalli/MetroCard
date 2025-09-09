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
	
	public CardDetails addUser(CardDetails cardDetails) {
	    return cardDetailsRepository.save(cardDetails);
	}

	
	public Optional<CardDetails> getDetails(Long cardNo)
	{
		return cardDetailsRepository.findById(cardNo);
	}
	
	public String validateCard(Long cardNo) {
        Optional<CardDetails> cd = cardDetailsRepository.findById(cardNo);
        if (cd.isPresent()) {
            return "Card is valid";
        } else {
            return "Card is invalid";
        }
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
	
	public String addBalance(Long cardNo, float amountToAdd) {
	    Optional<CardDetails> cardOpt = cardDetailsRepository.findById(cardNo);
	    if (cardOpt.isPresent()) {
	        CardDetails card = cardOpt.get();
	        float currentBalance = card.getBalance(); 
	        card.setBalance(currentBalance + amountToAdd);
	        cardDetailsRepository.save(card);
	        return "Balance updated successfully. New balance: " + card.getBalance();
	    } else {
	        return "Card not found";
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


	public Optional<CardDetails> findById(Long cardNo) {
		// TODO Auto-generated method stub
		return null;
	}


}
