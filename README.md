# 💵 **MaturityAlert – Investment Maturity Alert System**

A **Spring Boot based investment maturity alert application** that helps users track investments, calculate interest, and receive automated notifications when investments reach maturity.

The system allows users to manage investment details, monitor their status, and receive timely email alerts for upcoming maturities.

**MaturityAlert solves a real-world financial problem — missing critical investment maturity dates and related returns.**

---

# 🚀 Tech Stack

**Backend**
- Java
- Spring Boot
- Spring MVC
- Spring Data JPA
- Hibernate

**Frontend**
- HTML
- CSS
- JavaScript
- Thymeleaf
- Bootstrap

**Database**
- MySQL

**Tools**
- Maven
- Postman

---

# 📦 Key Features

- Full CRUD operations for customer and investment management
- Automated calculation of interest and investment status updates
- Email notifications for upcoming investment maturities
- Maintain investment history logs
- Entity relationship management with JPA/Hibernate
- Global exception handling
- Mobile-friendly interface

---

# 🔗 REST APIs

**CustomerController**

1. View Homepage - @GetMapping("/")
2. Add new customer - @GetMapping("/customer/new")
3. Save customer details - @PostMapping("/customer/save")
4. View all customers - @GetMapping("/customers/view")
5. Update a customer using ID - @GetMapping("/update-customer/{id}")
6. Delete a customer using ID - @GetMapping("/delete-customer/{id}")
    
**InvestmentController**

1. Add new investment for a particular customer using Customer ID - @GetMapping("/investment/new/{id}")
2. Save an investment - @PostMapping("/investment/save")
3. View all investments - @GetMapping("/investments/view")
4. View investments of particular customer using Customer ID - @GetMapping("/investments/view/{id}")
5. Update an investment using Investment ID - @GetMapping("/update-investment/{id}")
6. Delete an investment using Investment ID - @GetMapping("/delete-investment/{id}")

---

## 🏗️ Project Architecture

The application follows a **layered architecture** to separate responsibilities and maintain clean code structure.

```
Client (Browser / JavaScript / Thymeleaf)
            │
            ▼
        Controller Layer
            │
            ▼
        Service Layer
            │
            ▼
       Repository Layer
            │
            ▼
           Database
```

### Controller Layer

Handles incoming HTTP requests and returns responses or views.

Controllers:

- CustomerController
- InvestmentController

Responsibilities:

- Receive API requests
- Call appropriate service methods
- Return JSON responses or HTML views


### Service Layer

Contains the **business logic** of the application.

Services:

- CustomerService / CustomerServiceImpl
- InvestmentService / InvestmentServiceImpl
- EmailService / EmailServiceImpl
- ReminderService / ReminderServiceImpl

Responsibilities:

- Process customer and investment data
- Calculate interest and maturity status
- Trigger email notifications
- Coordinate repository operations


### Repository Layer

Handles **database interactions** using Spring Data JPA.

Responsibilities:

- Fetch customer and investment records
- Store investment and transaction details
- Query maturity-related data efficiently


### Database Layer

The application uses **MySQL** for persistent storage.

Main tables:

- customer_details
- investment_details

---

# 🗄️ Database Tables

**customer_details**

- custId (Primary Key)
- custName
- custEmail
- custPhone

**investment_details**

- investId (Primary Key)
- custId (Foreign Key)
- bankName
- schemeName
- depositAccountNum
- principal
- interestRate
- startDate
- maturityDate
- maturityValue
- creditAccountNum
- status

---

# 🖼️ Screenshots

1. View Homepage

![homepage](https://github.com/SAM10012/MaturityAlertApp/blob/6640da4240e8966435901a61d13cc1e6a790780e/maturity-alert/screenshots/maturity-alert-homepage.png)

2. Add new customer 

![add_new_cust](https://github.com/SAM10012/MaturityAlertApp/blob/6640da4240e8966435901a61d13cc1e6a790780e/maturity-alert/screenshots/add-new-user.png)

3. Update customer details 

![update_cust](https://github.com/SAM10012/MaturityAlertApp/blob/6640da4240e8966435901a61d13cc1e6a790780e/maturity-alert/screenshots/update-user-details.png)

4. View all customers

![view_all_cust](https://github.com/SAM10012/MaturityAlertApp/blob/6640da4240e8966435901a61d13cc1e6a790780e/maturity-alert/screenshots/view-all-users.png)

5. Delete customer with investment

![del-cust-with-investment](https://github.com/SAM10012/MaturityAlertApp/blob/6640da4240e8966435901a61d13cc1e6a790780e/maturity-alert/screenshots/delete-customer-with-investment.png)
 
6. Add new investment for a particular customer using Customer ID 

![add_new_investment](https://github.com/SAM10012/MaturityAlertApp/blob/6640da4240e8966435901a61d13cc1e6a790780e/maturity-alert/screenshots/add-new-investment-of-a-customer.png)

7. Update an investment using Investment ID  

![update-investment](https://github.com/SAM10012/MaturityAlertApp/blob/6640da4240e8966435901a61d13cc1e6a790780e/maturity-alert/screenshots/update-investment-of-customer.png)

8. View investments of particular customer using Customer ID 

![view-an-investment](https://github.com/SAM10012/MaturityAlertApp/blob/6640da4240e8966435901a61d13cc1e6a790780e/maturity-alert/screenshots/view-investments-of-a-customer.png)

9. View all investments

![view-all-investments](https://github.com/SAM10012/MaturityAlertApp/blob/6640da4240e8966435901a61d13cc1e6a790780e/maturity-alert/screenshots/view-all-investments.png)
    
10. Maturity Alert Email Notification

![email-notification](https://github.com/SAM10012/MaturityAlertApp/blob/6640da4240e8966435901a61d13cc1e6a790780e/maturity-alert/screenshots/maturity-alert-email.png)

---

# 🛠️ How to Run

Follow the steps below to run the MedTrack application locally.

1. Clone the Repository

- git clone https://github.com/your-username/maturityalert.git
- cd maturityalert

2. Create MySQL Database

- CREATE DATABASE maturityalert;

3. Configure Database Connection

- Open src/main/resources/application.properties and configure your database credentials:

- spring.datasource.url=jdbc:mysql://localhost:3306/maturityalert
- spring.datasource.username=your_mysql_username
- spring.datasource.password=your_mysql_password

- spring.jpa.hibernate.ddl-auto=update
- spring.jpa.show-sql=true

4. Build the Project

- mvn clean install

5. Run the Application

- mvn spring-boot:run OR run the main class MaturityAlertApplication.java from your IDE.


7. Application Flow

- Open the homepage to view customers and their investments
- Add, update, or delete customer and investment records
- Check upcoming investment maturities
- Receive automated email alerts for matured investments

---

# 👩‍💻 Author

**Samadrita Paul**  
Java Backend Developer | Spring Boot | REST APIs | MySQL

---

   

