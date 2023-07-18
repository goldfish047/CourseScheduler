package com.example.cmpt276project;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
// import static org.junit.Assert.assertTrue;
// import static org.junit.Assert.fail;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.example.cmpt276project.models.User;

// @RunWith(SpringJUnit4ClassRunner.class)
// @WebIntegrationTest

@SpringBootTest
class Cmpt276projectApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test 
	void registerWithInvalidPass(){

		User newUser = new User();
		try{	
			newUser.setName("Frank");
			newUser.setPassword("123");

		}
		catch (IllegalArgumentException e){

		}

	}

	@Test 
	void registerWithValidPass(){
		User newUser = new User();
		try{
			newUser.setName("Frank");
			newUser.setPassword("A2$aaaaaa");

		}
		catch(IllegalArgumentException e){

		}

	}

	@Test
	void registerWithInvalidUserName(){
		User newUser = new User();
		try{
			newUser.setName("");
			newUser.setPassword("A2$aaaaaa");
		}
		catch(IllegalArgumentException e){

		}		
		
	}


}
