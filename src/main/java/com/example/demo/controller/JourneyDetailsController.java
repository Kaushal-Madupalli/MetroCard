package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repo.JourneyDetailsRepository;
import com.example.demo.service.JourneyDetailsService;
@RestController
@RequestMapping("/journey")
public class JourneyDetailsController{
		@Autowired
		JourneyDetailsService jds;
		
		@RequestMapping("/entry/{cardNo}/{entryid}")
		public String setEntryPoint(@PathVariable Long cardNo,@PathVariable int entryid)
		{
			return jds.setEntryPoint(entryid, cardNo);
		}
		
		@GetMapping
		public String Verification()
		{
			return "checking whether the controller is working or not";
		}
		@RequestMapping("/exit/{cardNo}/{destinationid}")
		public String setDestinationPoint(@PathVariable Long cardNo,@PathVariable int destinationid)
		{
			return jds.setDestinationPoint(destinationid, cardNo);
		}

		
}

