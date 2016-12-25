/*package com.db.glue.search.service.test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import com.db.glue.search.model.ManageContact;
import com.db.glue.search.model.User;
import com.db.glue.search.resttemplate.RestSearchTemplate;
import com.db.glue.search.service.SearchServiceImpl;
import com.db.glue.search.util.DBException;
import com.db.glue.search.util.WebServiceError;
@RunWith(MockitoJUnitRunner.class)
public class SearchServiceImplTest {
	SearchServiceImpl searchServiceImpl;
	
	boolean thrown = false;
	
     ManageContact manageContact;
	
	@Mock
	WebServiceError webServiceError;
	
	@Mock
	RestSearchTemplate rest;
	
	//@Mock
	User user=new User();
	
	
	List<ManageContact> manageList = new ArrayList<ManageContact>();
	
    @Mock
	private RestTemplate restTemp;
	
	@Before
	public void setUp() throws Exception {
		
		manageList.add(new ManageContact());
		manageList.add(new ManageContact());
		manageList.add(new ManageContact());
		
		manageContact = new ManageContact();
		manageContact.setContactNumber(99999999);		
		manageContact.setEmail("apmca786@gmail.com");
		manageContact.setFirstName("apurva");
		manageContact.setLastName("vyas");
		
		user.setActivationStatus("Y");
		user.setActiveStatus("Yes");
		user.setContactNumber(9090000);
		user.setDob("07-04-1981");
		user.setEmail("apmca786@gmail.com");
		
		searchServiceImpl=new SearchServiceImpl(rest);
		
	}

	@After
	public void tearDown() throws Exception {
		searchServiceImpl=null;
	}

	@Test 
	public void searchUserValidateTest() {
		searchServiceImpl.validateUser("apurva");
	}
	@Test
	public void searchUserValidateNullTest() {
		try{
		searchServiceImpl.validateUser("");
		}catch(DBException e){
			thrown = true;
		}
		assertTrue(thrown); 
	}
	@Test
	public void searchUserValidateLessTest() {
		try{
		searchServiceImpl.validateUser("ab");
		}catch(DBException e){
			thrown = true;
		}
		assertTrue(thrown);
	}
	@Test
	public void searchUserTest() {
		User[] userArray={user};
		when(rest.getRestTemplate()).thenReturn(restTemp);
		
		when(restTemp.getForObject(anyString(),any())).thenReturn(userArray);
		searchServiceImpl.searchUser("raj");
		
	}
	
	
}
*/