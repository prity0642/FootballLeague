package com.sapient.league.footballLeague.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sapient.league.footballLeague.entity.FootballLeague;

@Service
public class FootballLeagueService {
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	public List<FootballLeague> getLeagueData(String url) {
		FootballLeague[] footballLeagues = restTemplate.getForObject(url, FootballLeague[].class);
		return Arrays.asList(footballLeagues);
	}
	
}
