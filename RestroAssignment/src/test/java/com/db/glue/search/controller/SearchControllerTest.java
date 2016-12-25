/*package com.db.glue.search.controller;


import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.util.Assert;

import com.db.glue.search.model.ManageContact;
import com.db.glue.search.service.SearchService;
import com.db.glue.search.util.DBException;
import com.db.glue.search.util.WebServiceError;

@RunWith(MockitoJUnitRunner.class)
public class SearchControllerTest { 
	
	@Mock
	private SearchService searchService;
	
	Logger log = Logger.getLogger(SearchControllerTest.class);
	
	ManageContact manageContact;
	
	@Mock
	WebServiceError webServiceError;
	
	
	SearchController searchController;
	List<ManageContact> userList = new ArrayList<ManageContact>();
	@Mock
	private DBException exception;
	
	@Before
	public void setUp(){
		userList.add(new ManageContact());
		userList.add(new ManageContact());
		userList.add(new ManageContact());
		
		manageContact = new ManageContact();
		manageContact.setContactNumber(99999999);		
		manageContact.setEmail("apmca786@gmail.com");
		manageContact.setFirstName("apurva");
		manageContact.setLastName("vyas");
		
		
		searchController = new SearchController(searchService);
	}
	
	
	@Test
	public void searchUserTest() throws IllegalStateException, IOException{
		when(searchService.searchUser("apurva")).thenReturn(userList);
		Map<String, Object> response = searchController.searchUser("abc");
		response.put("sucess", userList);
		Assert.notNull(response);
		
	}
	
	@Test
	public void searchUserEmptyTest() throws IllegalStateException, IOException{
		try{
		when(searchService.searchUser("")).thenReturn(null);
		Map<String, Object> response = searchController.searchUser("");
		response.put("sucess", userList);
		Assert.isNull(response);
		}
		catch(DBException e){
			log.info(e.getMessage());
		}
		
	}
	
	@Test
	public void handleValidationException_4002(){
		when(exception.getErrorCode()).thenReturn(4002);
		when(exception.getMessage()).thenReturn("Bad request error");
		searchController.handleValidationException(exception);
		
	}
	
	
	
	@Test
	public void handleValidationException_5001(){
		when(exception.getErrorCode()).thenReturn(5001);
		when(exception.getMessage()).thenReturn("Unexpected server error");
		searchController.handleValidationException(exception);
		
	}

	@Test
	public void handleValidationException_500(){
		when(exception.getErrorCode()).thenReturn(500);
		when(exception.getMessage()).thenReturn("SERVER IS DOWN");
		searchController.handleValidationException(exception);
		
	}
	@After
	public void tearDown() throws Exception {
		searchController = null;
	}

}
*/