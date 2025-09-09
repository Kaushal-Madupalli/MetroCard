package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public Map<String, Object> addUser(@RequestBody CardDetails card) {
	    CardDetails savedCard = cardDetailsService.addUser(card);

	    Map<String, Object> response = new HashMap<>();
	    response.put("message", "Card details are created successfully");
	    response.put("cardDetails", savedCard);

	    return response;
	}

	
	@GetMapping("/validateCard/{cardNo}")
	public String validateCard(@PathVariable("cardNo") Long cardNo) {
	    return cardDetailsService.validateCard(cardNo);
	}

	@PostMapping("/addBalance/{cardNo}/{amount}")
	public ResponseEntity<String> addBalance(
	        @PathVariable Long cardNo,
	        @PathVariable float amount) {

	    String result = cardDetailsService.addBalance(cardNo, amount);

	    if (result.startsWith("Balance updated successfully")) {
	        return ResponseEntity.ok(result);
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
	    }
	}



	
	@GetMapping("/checkBalance/{cardNo}")
	public String checkBalance(@PathVariable("cardNo") Long cardNo) {
	    float balance = cardDetailsService.fetchBalance(cardNo);

	    if (balance < 100.0f) {
	        float amountNeeded = 100.0f - balance;
	        return "You are not maintaining minimum balance 100. Your balance is " + balance 
	               + ". Please add " + amountNeeded + " more to maintain minimum balance.";
	    } else {
	        return "Your balance is " + balance;
	    }
	}

	
}
