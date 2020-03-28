package com.sapient.league.footballLeague;

import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import com.sapient.league.footballLeague.controller.FootballLeagueController;
import com.sapient.league.footballLeague.entity.FootballLeague;
import com.sapient.league.footballLeague.service.FootballLeagueService;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = {TestContext.class})
@WebAppConfiguration
class FootballLeagueApplicationTests {
	
	@InjectMocks
	FootballLeagueController footballController=new FootballLeagueController();
	
	@Mock
	FootballLeagueService footballLeagueService =new FootballLeagueService();

	@Mock
	RestTemplate restTemplate = new RestTemplate();
	

	
	//@Test
	void testLeagueSummary() {
		FootballLeague footballLeague = new FootballLeague();
		footballLeague.setCountry_name("England");
		footballLeague.setLeague_id("148");
		footballLeague.setLeague_name("");
		footballLeague.setOverall_league_position("1");
		footballLeague.setTeam_id("123");
		footballLeague.setTeam_name("test");
		
		FootballLeague[] fbl = {footballLeague};
		
		List<FootballLeague> footballLeagues = new ArrayList<>();
		
		footballLeagues.add(footballLeague);
		
	   String url ="https://apiv2.apifootball.com/?action=get_standings&league_id=148&APIkey=9bb66184e0c8145384fd2cc0f7b914ada57b4e8fd2e4d6d586adcc27c257a978";
		
 		Mockito.when(footballLeagueService.getLeagueData(url)).thenReturn(footballLeagues);	
 		Mockito.when(restTemplate.getForObject(url,FootballLeague[].class)).thenReturn(fbl);
		
		ResponseEntity<List<FootballLeague>> result =footballController.leagueSummary("148");
		
		
		
		assertSame(result.getStatusCode(), HttpStatus.OK);
	}

}
