package com.sapient.league.footballLeague.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sapient.league.footballLeague.entity.FootballLeague;
import com.sapient.league.footballLeague.service.FootballLeagueService;

@Controller
@RequestMapping("/footballLeague")
public class FootballLeagueController {
	
	@Value("${api.key}")
	private String apiKey;
	
	@Value("${data.url}")
	private String url;
	
	@Autowired
	FootballLeagueService footballLeagueService;
	
	@GetMapping(value="/summary")
	public ResponseEntity<List<FootballLeague>> leagueSummary(@RequestParam(required = true)  String id){
		
		
		List<FootballLeague> footballLeagues = footballLeagueService.getLeagueData(url+"&league_id="+id+"&APIkey="+apiKey);
		
		return new ResponseEntity<List<FootballLeague>>(footballLeagues,HttpStatus.OK);
	}
}
