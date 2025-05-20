## Pop  Quiz App


 **Developer**:          Nhlanhla Cindi
- **Student Nr.**:       ST10470261
- **Group**:               GR01
- **Course code**:      HMAW0501
-  **Campus**:            Sandton    
- **Module**:              IMAD5112 Assignment 2

## About app
 
 **Pop Quiz** is a mobile app developed as part of an assignment in the module **Intrtoduction to mobile application and Web development** (IMAD5112).
This app was created using **Kotlin** and **Android Studio**. The primary purpose of this app is to assess and educate users in understanding General Knowledge material in a fun interactive manner without the pressure of formal testing.
By being unannounced, it encourages users to expand and test their capabilities on completely randomized general topics.The requirements of the assignment were met as listed on the assignment documentation.


## Links

- **GitHub Repository**: [[https://github.com/VCSTDN2024/imad5112-assignment-2-ST10470261]
- **YouTube Video**: [(https://www.youtube.com/watch?v=oL--XKVMwMg)]

##Features:

Feature 1:**Question Display**
-Presents a single true/false question to the user at a time.
-Randomly selects one out of five predefined sets of questions for each quiz session.
-Each question set contains 10 questions.

Feature 2:**Answer Input**
-Provides "True" and "False" buttons for the user to answer the current question.

Feature 3:**Answer Checking**
-Compares the user's answer to the correct answer for the current question.
-Provides immediate feedback to the user ("Correct!" in green or "Incorrect!" in red).

Feature 4:**Scoring**
-Keeps track of the user's score (number of correct answers).

Feature 5:**Question Navigation**
-A "Next" button allows the user to proceed to the next question after answering.
-Disables True/False buttons after an answer is given to prevent multiple submissions for the same question.
-Enables the "Next" button only after an answer is submitted.

Feature 6:**Quiz Completion**
-After all 10 questions in a set are answered, the quiz ends.
-Navigates to a results screen (MainActivity3). Results Screen (MainActivity3):

Feature 7:**Score Display**
-Shows the user's final score (e.g., "7/10").

Feature 8:**Feedback**
-Provides simple feedback based on the score (e.g., "Great job!" or "Keep practicing!").

Feature 9:**Review Option**
-A "Review" button that navigates to a review screen (MainActivity4).

Feature 10:**Exit Option**
-An "Exit" button to close the application. Review Screen (MainActivity4):

Feature 11:**Question and Answer Display**
-Displays all the questions and their corresponding correct answers from the specific question set the user just played.
-Uses a ScrollView to accommodate all the questions and answers if they exceed the screen height.

Feature 12:**Identifier-Based Data Transfer**
-Uses a QuestionSetIdentifier (an enum) to uniquely identify each question set.
-Passes this identifier along with the questions and answers via -Intent extras from MainActivity3 to MainActivity4 to ensure the correct set is displayed for review. Data Structure and Management:

Feature 13:**QuestionSet Data Class**
-A data class to neatly store a set of questions (as ArrayList<String>), their corresponding answers (as ArrayList<Boolean>), and a unique QuestionSetIdentifier.

Feature 14:**Centralized Question Data (DataClasses.kt)**
-The QuestionSetIdentifier enum, QuestionSet data class, and the questionSets list (containing all five question sets) are defined in a separate DataClasses.kt file, making them globally accessible within the app. Technical Implementations:

Feature 15:**Multiple Activities**
-Uses multiple Activity classes (MainActivity, MainActivity2, MainActivity3, MainActivity4) to manage different screens and flows.

Feature 16:**Intent for Navigation and Data Passing**
-Utilizes Intent objects to navigate between activities.
-Uses Intent extras (putExtra, getStringArrayListExtra, getBooleanArrayExtra, getIntExtra) to pass data (score, questions, answers, identifier) between activities.

Feature 17:**UI Elements**
-Uses standard Android UI elements like TextView, Button, and ScrollView.
-Dynamically updates TextView content (questions, feedback, score, review text).
-Changes TextView text color for feedback.
-Enables/disables buttons based on the quiz state.

Feature 18:**Edge-to-Edge Display**
-Uses enableEdgeToEdge() for a more immersive UI experience. In essence, you've built a functional true/false quiz application with multiple screens, scoring, feedback, and a review feature that correctly displays the questions and answers for the played session.


## Color Reference:

| Color                 | Hex                                                                                       |
| ----------------------| ----------------------------------------------------------------------------------------- |
| colour:Estoril Blue   | ![#2F539B](https://www.computerhope.com/htmcolor.htm) #2F539B                             |
| colour:Yellow         | ![#ffcc00](https://www.canva.com/design/DAGkmZfI0Ws/kBiD_EHWvQOo7BGbcEIWQA/edit) #ffcc00  |


## App Design:

User Experience (UX): The app was designed with the goal of providing an intuitive and easy-to-navigate user interface, ensuring a seamless user experience.

Clear Flow: The app follows a logical progression: Start Screen (MainActivity) -> Quiz Screen (MainActivity2) -> Results Screen (MainActivity3) -> Optional Review Screen (MainActivity4). This linear flow is generally easy for users to understand.

Explicit Actions: Buttons like "Start," "True," "False," "Next," "Review," and "Exit" clearly indicate their purpose, guiding the user through the quiz.

Immediate Feedback: Displaying "Correct!" or "Incorrect!" right after an answer provides instant reinforcement and helps the user learn.

Minimal Distractions: The focus is on the question and answer options during the quiz, minimizing cognitive load.
Responsiveness: The app was built to ensure it performs well on different screen sizes, with particular attention to device compatibility.

Standard Android UI Components: By using standard TextView, Button, and ScrollView components, you leverage Android's built-in adaptability to different screen densities and sizes.

Layout Managers: While not explicitly detailed in our discussion, the use of LinearLayout (as seen in activity_main4.xml) and potentially ConstraintLayout (common in Android layouts) helps in creating flexible UIs that can adapt to screen variations. ScrollView in MainActivity4 is a key element for responsiveness, ensuring that all review content is accessible regardless of screen height.

enableEdgeToEdge(): This contributes to a modern look and feel that utilizes the full screen space, which is generally expected by users on contemporary devices.
Simplicity: The design is minimalistic, focusing on core features without overwhelming the user.

Core Focus: The app centers around the primary task: taking a true/false quiz. There are no extraneous features or complex settings.

Clean UI: Each screen presents a limited set of interactive elements. For instance, the quiz screen primarily shows the question and two answer buttons, with a "Next" button appearing contextually.

Straightforward Information: The results screen directly presents the score and simple feedback. The review screen just lists questions and answers without added complexity.

Performance: Code optimization was considered to ensure fast response times and low battery usage.

Efficient Data Structures: Using ArrayList for questions and answers is generally performant for the scale of data in this app (10 questions per set).

Direct Logic: The quiz logic (checking answers, moving to the next question) is straightforward, minimizing computational overhead.

No Heavy Background Tasks: Based on the features discussed, the app doesn't seem to involve network requests, complex database operations, or continuous background processing during active use, which are common sources of performance bottlenecks and battery drain.

StringBuilder (in MainActivity4): While a small optimization for this app's scale, the use of StringBuilder for constructing the review text is more efficient than repeated string concatenation, demonstrating an awareness of performance considerations.

Closing Activities: The finishAffinity() and exitProcess(0) on the "Exit" button ensure the app resources are released, which is good practice. Areas for Potential Further Enhancement (Beyond Current Implementation).


## Screenshots
**App Design:**

![Home Screen]("C:\Users\cindi\OneDrive\Documents\Desktop\IMAD5112\Assignment 2\1st question\Screenshot 2025-05-19 021324.png")

![Question Screen]("C:\Users\cindi\OneDrive\Documents\Desktop\IMAD5112\Assignment 2\1st question\Screenshot 2025-05-19 021413.png")

![Score Screen]("C:\Users\cindi\OneDrive\Documents\Desktop\IMAD5112\Assignment 2\1st question\Screenshot 2025-05-19 021503.png")

![Review Screen]("C:\Users\cindi\OneDrive\Documents\Desktop\IMAD5112\Assignment 2\1st question\Screenshot 2025-05-19 021547.png")

Running process:

![Home Screen]("C:\Users\cindi\OneDrive\Documents\Desktop\IMAD5112\Assignment 2\1st question\Screenshot 2025-05-19 001212.png")

![Question Screen]("C:\Users\cindi\OneDrive\Documents\Desktop\IMAD5112\Assignment 2\1st question\Screenshot 2025-05-19 001344.png")

![Question Correct Screen]("C:\Users\cindi\OneDrive\Documents\Desktop\IMAD5112\Assignment 2\1st question\Screenshot 2025-05-19 001442.png")

![Question Incorrect Screen]("C:\Users\cindi\OneDrive\Documents\Desktop\IMAD5112\Assignment 2\1st question\Screenshot 2025-05-19 001612.png") 

![Score(<5) Screen]("C:\Users\cindi\OneDrive\Documents\Desktop\IMAD5112\Assignment 2\1st question\Screenshot 2025-05-19 001849.png")

![Score(>5) Screen]("C:\Users\cindi\OneDrive\Documents\Desktop\IMAD5112\Assignment 2\1st question\Screenshot 2025-05-19 002022.png")

![Review Screen]("C:\Users\cindi\OneDrive\Documents\Desktop\IMAD5112\Assignment 2\1st question\Screenshot 2025-05-19 002149.png")

![Shutdown of Screen]("C:\Users\cindi\OneDrive\Documents\Desktop\IMAD5112\Assignment 2\1st question\Screenshot 2025-05-19 001737.png")





## Challenges:

During the development of this project, I encountered several challenges, including:

1. Challenge 1: I initially had created an array of objects where each cell contains 2 arrays, the questions and the related answers - I then stated that when it was 1 set of 10 questions and  it worked, but when I initiated multiple sets(Multiple Array) - the information was not being transferred to the 3rd screen.

- Solution: I seeked guidance from my lectures and had the idea to implement an Identifier, which will then be able to know and select the  relative (questions and answers) to display after I link the screens through the use of a intent variable.
   
2. Challenge 2: I experienced alot of logical errors. 
   - Solution: I cleaned and rebuilt my code.
  
##Refrences

