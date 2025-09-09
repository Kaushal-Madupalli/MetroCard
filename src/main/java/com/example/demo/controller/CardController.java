package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.repo.CardDetails;
import com.example.demo.service.CardDetailsService;

@RestController
@RequestMapping("/card")
public class CardController {
	@Autowired
	CardDetailsService cardDetailsService;
	
	@GetMapping
	public List<CardDetails> getAll()
	{
		return cardDetailsService.getAll();
	}
	
	@RequestMapping("/getDetails/{cardNo}")
	public Optional<CardDetails> getDetails(@PathVariable("cardNo")Long cardNo)
	{
		return cardDetailsService.getDetails(cardNo);
	}
	
	@PostMapping
	public void addUser(@RequestBody CardDetails card)
	{
		cardDetailsService.adduser(card);
	}
	
	@GetMapping("/validateCard/{cardNo}")
	public boolean validateCard(@PathVariable("cardNo")Long cardno)
	{
		return cardDetailsService.validateCard(cardno);
	}
	
	@GetMapping("/checkBalance/{cardNo}")
	public String checkBalance(@PathVariable("cardNo")Long cardNo)
	{
		float b=cardDetailsService.fetchBalance(cardNo);
		if(b<100.0f)
		{
			return "Insufficient funds";
		}
		else
		{
			return b+"";
		}
	}
	
}
