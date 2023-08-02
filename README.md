# Group 14 - Proposal

## ✨ABSTRACT🖌

The FIC Course Scheduler is a web application designed to simplify the process of scheduling courses for students and staff at FIC. The days of manual scheduling are over as our project aims to provide a convenient and user-friendly solution. The application considers the availability of professors, professor preferences and specific classroom requirements when generating schedules. Administrators can easily check instructor availability within the application, allowing for seamless identification of suitable time slots for classes based on professors' schedules.

FIC Scheduler provides a comprehensive course schedule and registration status for each day of the week, ensuring administrators have a clear overview of registered courses. Administrators can efficiently manage and organize academic schedules by utilizing flexible filters based on professor numbers, offered courses, and sections. The schedule is displayed in a table format, with room numbers as columns and times as rows, aligning course, instructor, and section information for easy reference.

Additionally, a map API integration offers a visual reference of the Fraser International College campus on the welcome page, enhancing the user experience. To further enhance user experience, the FIC Scheduler includes both light and dark modes, accommodating diverse user preferences and creating a visually appealing interface. With its user-friendly interface and powerful features, the FIC Scheduler revolutionizes class scheduling, providing administrators with an effective tool for optimized academic planning at Fraser International College.

The target audience for the FIC Course Scheduler includes students and faculty members of FIC. The project aims to make their lives easier by providing a convenient and efficient solution for scheduling courses. By streamlining the scheduling process, the application offers improved organization, reduced conflicts, and enhanced flexibility for students and faculty.
With a variety of features and a clear scope, the FIC Course Scheduler project provides ample work for a group of five members. Each member can take ownership of specific features, collaborating to build a comprehensive and robust solution. The team can alternate responsibilities if needed, ensuring efficient progress and minimizing confusion.

## CUSTOMER
The primary customers would be the administrative team or staff members responsible for creating class schedules within Fraser International College. This team would typically consist of administrators, schedulers, or academic coordinators who have the authority and responsibility to manage and organize the class schedules for the institution. 


## 📚STORIES📖

**As an administrator, I want to be able to login to the webpage so that I can view the schedule.** (complex - 3 points)

Precondition and triggers: 
* The administrator’s login credentials have been stored in the database
* The administrator enters their credentials and hits the login button. 

Actions/post conditions: 
* If login is successful, send user to the main schedule page
* If login is unsuccessful, have the login page display an error telling the user to try again. 

Tests: 
* (Test: registerWithValidPass) Input a username and password that are already stored in the database correctly, check if the user is   redirected to the main schedule page. 
* Input an username and password that isn’t stored in the database, check if the login page displays an error. 

Acceptance Criteria: 

* A login form
* A user cannot submit a login request without filling out all the mandatory fields (username, password) 
* The inputted username and password are compared to the usernames and passwords stored in the database to check for matches. If no -matches are found, an error will be displayed on the login page. 
* User is taken to the schedule page if login is successful. 
* The option to logout on the schedule page 


**As a new administrator, I want to be able to register myself so that I can use the scheduler.** (complex - 3 points)

Precondition and triggers:
* The user clicks the “Create an account” button on the login page  
* The user doesn’t have any valid login credentials stored in the database beforehand 

Actions/post conditions: 
* If registration is successful, the user is redirected to a success page. 
* If the user’s username matches one that's already in the database, the registration page displays an error message to the user. 
* If the user’s inputted password isn’t valid (i.e. it doesn’t have a length >= 8 or it doesn’t contain at least 1 capital letter and 1 -lowercase letter or it doesn’t contain at least 1 symbol), then the registration page displays an error message detailing the proper criteria for a password so the user knows what to fix.  

Tests: 
* (Test: registerWithInvalidUsername) Attempt to register using a pre-existing username. Check if the register page displays an error -message 
* Register using a valid username and password (i.e. the username isn’t in the database and the password meets the correct criteria). --* Check if the user is redirected to the success page. 
* (Test: registerWithInvalidPass) Attempt to register using an invalid password and check if the password validation is working. 

Acceptance Criteria: 

* A registration form 
* A user cannot register if their username is already in the database.
* A user has to follow the criteria for a valid password when registering (length >=8 and at least 1 capital letter and 1 lowercase -letter, and contains at least 1 symbol) 
* Users will be redirected to the success page if registration works. 
* The inputted credentials will be inputted into the database if the registration is successful.  



**As an administrator, I want to check the availability of the instructors for classes.** (complex - 3 points)

Precondition and triggers:
* The user clicks the “Availability” button on the top of the main schedule page
Actions/post conditions:
* Directs the user to the professor availability page which displays the timetable for professor availability and supports filtering search features by instructor number and specific periods.

Tests:
* (Test: testAvailabilityPage) Input the instructor number that is already in the database (Excel sheet), check if the timetable filters that certain instructor, and display the schedule for the user.
* Click and apply the specific period filter boxes, and check if the application displays the professor’s availability within the specified time range.
 
Acceptance Criteria:
* A timetable that displays the availability of the instructor.
* Display the schedule of a certain instructor, when the user searches for a certain instructor number.
* Display the schedule of instructor availability within the specified time range when the user clicks the specific period filter boxes.



**As an administrator, I want to check the course schedule.** (epic - 8 points) 
Precondition and triggers:
* The user clicks the “Schedule” button on the top of the main schedule page

Actions/post conditions:
* Directs the user to the schedule of different courses that support Monday to Friday and TBA filter boxes.
* Support the search of specific instructor numbers and courses.

Tests:
* (Test: testSchedulePage) Apply the search filter, and check if the application displays the schedule within the specified category.

Acceptance Criteria:
* A timetable that displays the course,section and instructor number and specific periods for each day of the week.
* Display the schedule within the specified category when the specific day or TBA filter and search boxes are applied.



**As an administrator, I want to change the theme of the interface.** (complex - 3 points)
Precondition and triggers:
* The user clicks the moon/sun button on the navigation bar

Actions/Post Conditions:.
* The application interface switches between light and dark mode according to the user's selection, providing a visually appealing appearance.

Tests:
* (Test: testLightModeSwitch) Click the sun button and verify that the application interface changes to light mode.
* (Test: testDarkModeSwitch) Click the moon button again and verify that the application interface changes to dark mode.
  
Acceptance Criteria:
* The FIC Scheduler application supports both light and dark modes.
* When the user clicks the sun/moon button, the application's appearance switches accordingly between light and dark mode.
* The light mode presents a visually clear and bright interface, while the dark mode offers a visually comfortable and eye-friendly interface for users to choose according to their preferences.


## 🏆COMPETITIVE ANALYSIS📊

The FIC scheduler application, designed exclusively for administrators, offers several advantages over the goSFU scheduling system used by students. While the goSFU system primarily caters to students' scheduling needs, the FIC scheduler focuses on the specific requirements administrators are responsible for when creating and managing class schedules. Unlike the goSFU system, which is student-oriented, the FIC scheduler provides a secure login system that ensures only authorized administrators can access the application. Moreover, the FIC scheduler takes into account professors' availability and specific classroom requirements when generating schedules, which might be similar to the backend process in goSFU. Similar to goSFU, the schedules are presented in a convenient calendar format, allowing administrators to visualize and manage class schedules efficiently. However, the FIC scheduler displays all classes scheduled for a given day, providing a comprehensive overview, whereas the goSFU system only shows classes selected by students. Administrators also benefit from the ability to filter classes by professor names and departments, enabling efficient management and organization of academic schedules. Overall, the FIC scheduler application caters specifically to the needs of administrators, providing them with a tool for streamlining class scheduling processes within the FIC institution.


## 👥GROUP MEETINGS🗣🔥🔥🔥
Our group plans to meet twice a week in person after class, and we’re using Discord for communication. On our first meeting on June 6, 2023, we took the opportunity to get to know each other and discussed the requirements for this project.

In the second meeting on June 8, 2023, we explored different course scheduling websites and brainstormed some features we would like to incorporate. Such as bookmarking a favorite schedule, waitlist function, and the ability to check for class overlaps. We plan to make the project somewhat flexible, so it allows us to add more features and functions as we continue to develop the application.

During the third meeting on June 14, 2023, we worked on the UI mock up and discussed the layout of the web page. We also agreed that each of us would take turns leading the meetings, ensuring that everyone feels included and involved.

In the fourth meeting held on June 16, 2023, we discussed possible APIs we could use for the project. After careful consideration, we finalized the layout of the webpage, ensuring that it meets the project requirements and aligns with our vision.

In the fifth meeting held on June 21, 2023, we reviewed different template choices for the login page and decided on the one which best resonated with FIC. Additionally, we worked on possible password requirements for the login. 

During the sixth meeting held on June 23, 2023, we explored specific requirements to create a new authenticated account. We decided on the username and password requirements to create a secure login. 

On our seventh meeting on June 28, 2023, we explored different ways to successfully log out the user while also considering the user is not able to access the secured pages when pressing the back button. 

In our eighth meeting on June 30, 2023, we decided to add a tag that links to the course webpage of FIC to make course assigning easier. Furthermore we discussed on ways to increase feature development. 

In our ninth meeting on July 5, 2023, we settled on incorporating the Google Maps API for a convenient way to access information about the college’s surroundings and enhance awareness of the FIC’s geographic context. 

During our tenth meeting on July 7, 2023, we discussed on adding an availability page which displays instructor time openings and preferences to help FIC admin view it easily. We also changed some design patterns of small buttons and features. 

On our 11th meeting on July 12, 2023, we explored adding different time filters to make the searching process easier. Furthermore, we finalized on creating a search bar which can provide results based on instructor number. 

In the 12th meeting held on July 14, 2023, we decided to create a default homepage in which the user is directed to after logging in. We updated the UI mockup based on changes to the homepage and availability page. 
