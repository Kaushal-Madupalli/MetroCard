package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.RequestMapping;


import com.example.demo.repo.JourneyDetailsRepository;
@Service
@RequestMapping("/journey")
public class JourneyDetailsService {

		JourneyDetailsRepository jdr;
		@Autowired
		CardDetailsService cardDetailsService;
		
		public String setEntryPoint(int entryid,Long cardNo)
		{
			boolean flag=cardDetailsService.validateCard(cardNo);
			if(!flag)
			{
				return "Invalid Card Number";
			}
			float balance=cardDetailsService.fetchBalance(cardNo);
			if(balance<90.0f)
			{
				return "mininum balance not maintained, your balance is="+balance;
			}
			
			
			return "";
		}



		public String setDestinationPoint(int destinationid, Long cardNo) {
			
			return "";
		}
		
}
