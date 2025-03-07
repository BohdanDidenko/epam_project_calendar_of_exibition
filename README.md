# Exhibition Calendar System  

## Project Description  

The **Exhibition Calendar System** is designed to manage a list of **Exhibition Halls**, each hosting multiple **Exhibitions**. Visitors can purchase **Tickets** by selecting an **Exhibition Theme** and completing a **Payment** transaction.  

## Installation Requirements  

Ensure the following dependencies are installed:  

- **JDK** 1.8 or higher  
- **MySQL** 5.7 or higher  
- **Apache Tomcat** 8.5.13 or higher  

## Application Setup and Execution  

Follow these steps to run the application:  

1. **Clone, fork, or download** the source code from this GitHub repository.  
2. **Create the database** by executing the SQL script:  
   ```sql
   \src\main\resources\periodicals.sql
3. **Build the project** using Maven:  
mvn clean install
4. **Start the Tomcat server**.  
5. **Access the application** at:  
http://localhost:8080/
