package com.db.glue.search.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.restro.assignment.SearchApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SearchApplication.class)
@WebAppConfiguration
public class CustomerApplicationTest {

	@Test
	public void contextLoads() {
	}

}
