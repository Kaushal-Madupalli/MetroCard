package com.example.demo.controller;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repo.JourneyDetailsRepository;
import com.example.demo.service.JourneyDetailsService;
@RestController
@RequestMapping("/journey")
public class JourneyDetailsController{

		JourneyDetailsService jds;
		
		@PostMapping("/{cardNo}/{entryid}")
		public String setEntryPoint(@RequestParam("{entryid}")int entryid,@RequestParam("{cardNo}")Long cardNo)
		{
			return jds.setEntryPoint(entryid, cardNo);
		}
		
		
		@PostMapping("/{cardNo}/{destinationid}")
		public String setDestinationPoint(@RequestParam("{destinationid}")int destinationid,@RequestParam("{cardNo}")Long cardNo)
		{
			return jds.setDestinationPoint(destinationid, cardNo);
		}

		
}

