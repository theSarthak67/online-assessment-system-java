# Online Assessment & Evaluation System (Java, JDBC, MySQL)

The **Online Assessment & Evaluation System** is a backend-focused application designed to simulate a real-world **computer-based test (CBT)** environment.  
It enables **admins to manage exams and questions** and allows **students to log in, attempt exams, and receive automated results**.

This project emphasizes **backend architecture, database design, and core Java concepts**, using a **console-based (terminal) interface** instead of a graphical UI.

---

## 💡 Why I Built This Project

I built this project to:
- Strengthen my **Core Java** and **JDBC** skills
- Learn how backend systems manage exams, users, and results
- Practice **database design with relationships and constraints**
- Understand real-world flows like **exam attempts, evaluation, and result processing**

This project helped me connect **theory with practical backend development**.


---

## 📌 Project Objectives

- Design a normalized relational database for an online examination system
- Implement backend logic using **Core Java and JDBC**
- Support **role-based access** (Admin / Student)
- Enable **timed exam attempts**
- Automate **evaluation and result processing**
- Demonstrate real-world backend development practices

---

## 🚀 Key Features

### 👤 User Management
- Two user roles: **ADMIN** and **STUDENT**
- Secure login using email and password
- Role-based authorization logic

### 🧑‍💼 Admin Functionalities
- Create exams with:
  - Title
  - Duration
  - Total marks
- Add multiple-choice questions (MCQs) to exams
- Maintain a structured question bank

### 🧑‍🎓 Student Functionalities
- Login through console
- View available exams
- Start an exam (creates an exam attempt)
- Answer questions interactively via terminal
- Submit the exam

### 🧠 Automated Evaluation
- Each answer is validated against correct options
- Marks are calculated automatically
- Percentage and Pass/Fail status are derived
- Results are stored permanently in the database

---

## 🏗️ Technology Stack

| Layer | Technology |
|-----|-----------|
| Language | Java 21 |
| Database | MySQL |
| Database Access | JDBC |
| Build Tool | Maven |
| Interface | Terminal / Console |

---

## 🗂️ Project Structure

```
com.sarthak.assessment
│
├── model
│   ├── User.java
│   ├── Exam.java
│   ├── Question.java
│   ├── ExamAttempt.java
│   ├── StudentAnswer.java
│   └── Result.java
│
├── dao
│   ├── UserDao.java
│   ├── ExamDao.java
│   ├── QuestionDao.java
│   ├── ExamAttemptDao.java
│   ├── StudentAnswerDao.java
│   └── ResultDao.java
│
├── service
│   └── EvaluationService.java
│
├── util
│   └── DBConnection.java
│
└── App.java   (Main entry point – console-based execution)
```

---

## 🧩 Database Design Overview

### Tables Used
- `users`
- `exams`
- `questions`
- `exam_attempts`
- `student_answers`
- `results`

### Design Highlights
- Uses **AUTO_INCREMENT primary keys**
- Enforces **foreign key constraints**
- Maintains **referential integrity**
- Supports **multiple attempts per student**
- Stores **audit data** (timestamps)

---

## 🔄 System Workflow

### Admin Flow
1. Admin logs in
2. Admin creates an exam
3. Admin adds questions to the exam

### Student Flow
1. Student logs in via console
2. Student views available exams
3. Student starts an exam (attempt is created)
4. Questions are displayed one by one
5. Student enters answers via terminal
6. Student submits exam
7. System evaluates and stores result

---

## ▶️ How to Run the Project

### 1️⃣ Prerequisites
- Java 21 installed
- MySQL Server running
- Maven installed
- Database schema created

---

### 2️⃣ Database Configuration

Update credentials in:

```
com.sarthak.assessment.util.DBConnection
```

Example:
```java
jdbc:mysql://localhost:3306/online_assessment_db
username: root
password: your_password
```

---

### 3️⃣ Run the Application

#### Using IDE (Recommended)
- Open the project
- Run `App.java` as **Java Application**

#### Using Terminal
```bash
mvn compile
mvn exec:java -Dexec.mainClass="com.sarthak.assessment.App"
```

---

## 🧪 Console-Based Interaction

- Login credentials are entered via terminal
- Exams and questions are displayed in console
- Answers are typed using keyboard
- Results are generated automatically after submission

This simulates how a frontend would interact with the backend.

---

## 🧠 Design Decisions

- **DAO Pattern** used to separate database logic
- **Service Layer** used for evaluation logic
- **PreparedStatement** used to prevent SQL injection
- **LocalDate / LocalDateTime** used for modern date handling
- **ENUMs in DB** used for controlled values (roles, status)

---

## 📌 Project Scope

### Included
✔ Backend architecture  
✔ Database-driven logic  
✔ Role-based flows  
✔ Automated evaluation  

### Not Included (By Design)
❌ Web UI  
❌ REST APIs  
❌ Password hashing  
❌ Deployment  

These can be added as future enhancements.

---

## 🔮 Future Enhancements

- Web-based UI using Spring Boot + React
- REST APIs
- Password encryption
- Exam timer enforcement
- Attempt limits
- Result analytics dashboard

---

## 🎯 Academic & Interview Relevance

This project demonstrates:
- Core Java proficiency
- JDBC and SQL skills
- Backend system design
- Real-world exam workflow logic

Suitable for:
- College projects
- Backend developer interviews
- Java fresher roles

---

## 👨‍💻 Author

**Sarthak Tambe**  
Electronics & Telecommunication Engineering  
Java Backend Developer (Fresher)

#personal exp--
i started this project thinking it will be an easy one it was ultil i started putting piaces together.
so many error and relentless nights and yeah backpain.. haha...
learned a lot through errors and yeah used litle but chatgpt, but learning was worth it.

I MAY WILL UPGRADE THIS FROM COMSOLE TO FRAME BASED TO GUI - BASED OR MAYBE STANDALONE
depends if i got any free time from learning spring
---

## 📄 License

This project is created for **educational and learning purposes**.
