package course_scheduler.cmpt276;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.cmpt276project.models.User;

@SpringBootTest
class Cmpt276ApplicationTests {

	@Test 
	void registerWithInvalidPass(){

		User newUser = new User();
		try{	
			newUser.setName("Frank");
			newUser.setPassword("123");
			fail();
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
			fail();
		}
		catch(IllegalArgumentException e){

		}		
		
	}
}
