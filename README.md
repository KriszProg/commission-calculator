<h3>Project settings </h3>

- Language: Java 11
- Language level: 11 - Local variable syntax for lambda parameters

---
<h3>Build the application </h3>

- build with Maven by command: `mvn clean install`


---
<h3>Run the application </h3>

- __Option_1__: Use IDEA's Run Configuration


- __Option_2__: 
  - [1] Open a terminal and navigate to the root folder of the project
  - [2] Run command: `java -jar target/commission-calculator-1.0-SNAPSHOT.jar`


- __Option_3__:
  - [1] Copy 'commission-calculator-1.0-SNAPSHOT.jar' directly from GitHub REPO and paste to any folder you want  
  - [2] Open a terminal and navigate to that folder
  - [3] Run command: `java -jar commission-calculator-1.0-SNAPSHOT.jar`


---
<h3>What does this application do?</h3>

- [1] Reads data from file according to the user's choice _(see additional info in *Process Details)_
- [2] Calculates commission by determined rules
- [3] Creates 2 xml files ('_commission-report.xml_' and '_commission-report-detailed.xml_') 
- [4] Saves both xml to '__C:\commission-report__' folder. (__Note:__ _When folder not exists the app creates it automatically!_)


__Process Details:__
- When application is starts the user should provide Setups in 2 steps:
- __[STEP_1]__
  -  User must enter the full path of the file which want to work with _(example: C:\reports\sales-report.txt)_
  - [WARNING]: The file path must not contain accented characters (like 'áéíóöúű')
- __[STEP_2]__
  -  User must specify the separator character that separates the data in the file 
  - [WARNING]: The application currently accepts 2 types of separator characters: pipe ('|') or semicolon (';')
- After Setups was successful: application starts to read the data from the specified file and validate each line 
  (based on the specified separator character among others)
- [WARNING]: If it finds any errors during the validation the execution will stop and display the errors on the terminal

---
<h3>Playground</h3>


- You can find the following 3 txt files in the source code under the __src\main\resources__ folder:
  - Feladat_fejlesztoknek_1_jutalekadatok.txt
  - Test.txt
  - TestWithSemicolonSeparator.txt
- Please feel free to download and try running the application with them
- Have fun :)