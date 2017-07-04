# Robot Movement

This system uses Gradle build system(version 3.3). However, to use this application or run any of the below commands, you do not need to install Gradle.

**Prerequisite**:
- In order to use the system Java 8 should be installed.

**Commands**

1. Run Unit Tests
    - Unix      : _./gradlew clean test_
    - Windows   : _gradlew clean test_
    
2. Run Integration Tests
   - Unix      : _./gradlew clean integrationTest_
   - Windows   : _gradlew clean integrationTest_
       
3. Run Code Coverage
   - Unix      : _./gradlew clean test integrationTest jacocoTestReport_
   - Windows   : _gradlew clean test integrationTest jacocoTestReport_
       
4. Run System
    - Unix      : _./gradlew clean run_
    - Windows   : _gradlew clean run_
    
Once you execute the Run System command, system will boot up and show following list of commands,

    PLACE X,Y,F [X --> X coordinate, Y --> Y coordinate & F --> Facing direction]
    MOVE
    LEFT
    RIGHT
    REPORT
    EXIT
    
Then user can interact with the system by entering any of the above commands. However, system will ignore any command
entered by user until a valid **PLACE** command is given.

System performs required validation for Command and Command formats entered into the system.

By entering **REPORT** command user will be able to view current position of the robot. Output will be as follows,

    0, 2, NORTH

User will be able to exit the system by **EXIT** command

Test coverage report can be found under _/RobotMovement/build/reports/coverage/index.html_

Assumptions:

    1. System uses 5 X 5 table to move the robot
    2. All commands are case sensitive and should follow the exact format shown in the Command menu
    