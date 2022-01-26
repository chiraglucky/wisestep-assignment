# wisestep-assignment

### demo : [https://react-user-login.herokuapp.com](https://react-user-login.herokuapp.com)

# Requirements

For building and running the application you need:

- JDK 11
- Maven
- Node

# Running the application locally

- Clone the project.
- project folder consist 2 folder
  - boot (Backend)
  - react-login (Frontend)
- open in terminal/IDE

### Run springboot app

- cd boot
- Now,To run the backend application :
  ```
   ./mvnw spring-boot:run
  ```
### Run frontend app

- open new terminal
- cd react-login
- Now,To run the frontend application,firstly install the necessary packages :
  ```
   npm install
  ```
- then,
  ```
  npm start
  ``` 
  
  ### Now we have a backend server in Spring Boot running at http://localhost:8080 and a frontend in React running at http://localhost:3000 .We'd like to be able to call services in the backend and display the results in the frontend.In order to do this (and not get into trouble with any cross-origin requests (CORS)) so we add @CrossOrigin annotation on our spring controller class. 

### Note: Database (MySQL) is hosted on google cloud platform and running on public ip address 34.93.158.141 and port 3306.
