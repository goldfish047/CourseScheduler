package com.example.cmpt276project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;

import com.example.cmpt276project.controllers.UsersController;

import com.example.cmpt276project.models.User;

import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SpringBootTest
class Cmpt276projectApplicationTests {

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
			newUser.setName("Tom");
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

	@Test
	void testAvailabilityPage() {
		// Create a user and login
		User user = new User();
		user.setName("testttttttt");
		user.setPassword("A2$aaaaaa");

		// Simulate the login process
		HttpSession session = new MockHttpSession();
		session.setAttribute("session_user", user);

		// Set the user attribute in the Model object
		Model model = new ConcurrentModel();
		model.addAttribute("user", user);

		// Create an instance of UsersController
		UsersController usersController = new UsersController();

		// Get the availability page
		String availabilityPage = usersController.timetable(model, session);

		// Assert that the page name returned is correct
		assertEquals("users/availability", availabilityPage);
	}

	@Test
	void testSchedulePage() {
		// Create a user and login
		User user = new User();
		user.setName("testttttttt");
		user.setPassword("A2$aaaaaa");

		// Simulate the login process
		HttpSession session = new MockHttpSession();
		session.setAttribute("session_user", user);

		// Set the user attribute in the Model object
		Model model = new ConcurrentModel();
		model.addAttribute("user", user);

		// Create an instance of UsersController
		UsersController usersController = new UsersController();

		// Get the schedule page 
		String schedulePage = usersController.schedule(model, session);

		// Assert that the page name is returned correct
		assertEquals("users/schedule", schedulePage);
	}
	@Test
    void testLogout() {
        // Create a mock HttpServletRequest and HttpServletResponse
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        // Create a mock HttpSession and set a dummy attribute
        HttpSession session = mock(HttpSession.class);
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("session_user")).thenReturn("dummy_user");

        // Create an instance of UsersController
        UsersController usersController = new UsersController();

        // Call the destroySession method
        String result = usersController.destroySession(request, response, session);

        // Verify that the session's invalidate method is called
        assertTrue(result.startsWith("redirect:/"));
    }

	

}
