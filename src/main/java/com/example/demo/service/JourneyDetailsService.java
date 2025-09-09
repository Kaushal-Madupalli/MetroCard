package com.example.demo.service;

import java.time.LocalDate;
import java.time.LocalTime;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




import com.example.demo.repo.JourneyDetails;

import com.example.demo.repo.JourneyDetailsRepository;
@Service
public class JourneyDetailsService {
		@Autowired
		JourneyDetailsRepository jorneyDetailsRepository;
		@Autowired
		CardDetailsService cardDetailsService;
		

		public String setEntryPoint(int entryid,Long cardNo)
		{
			String flag=cardDetailsService.validateCard(cardNo);
			if(!flag)
			{
				return "Invalid Card Number";
			}
			float balance=cardDetailsService.fetchBalance(cardNo);
			if(balance<90.0f)
			{
				return "mininum balance not maintained, your balance is="+balance;
			}
			JourneyDetails JdObj=new JourneyDetails();
			JdObj.setCardDetails(cardNo);
			JdObj.setEntryStation(entryid);
			JdObj.setEntryDate(LocalDate.now());
			JdObj.setEntryTime(LocalTime.now());
			JdObj.setInTransit(true);
			jorneyDetailsRepository.save(JdObj);
			return "Entry Successful & Your minimum balance is="+balance;
		}



		public String setDestinationPoint(int destinationid, Long cardNo) {
			JourneyDetails jd=jorneyDetailsRepository.fetchData(cardNo);
			jd.setExitStation(destinationid);
			jd.setExitDate(LocalDate.now());
			jd.setExitTime(LocalTime.now());
			jd.setInTransit(false);
			float fare=calculateFare(jd.getEntryStation(),destinationid);
			float balance=cardDetailsService.fetchBalance(cardNo);
			balance-=fare;
			cardDetailsService.setBalance(cardNo, balance);
			jorneyDetailsRepository.save(jd);
			return "Thank you for using metro services & you balance="+balance;
		}
		
		public float calculateFare(int entryid,int destinationid)
		{
			return Math.abs(destinationid-entryid)*10;
		}
		
}
