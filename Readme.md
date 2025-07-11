# 📚 Library Management System (Backend)

A backend REST API project built using Spring Boot for managing library operations like books, members, borrowing and returning.

---

## ⚙️ Tech Stack

- Java 21
- Spring Boot
- Spring Data JPA (Hibernate)
- MySQL / H2
- Lombok
- Maven

---

## 📁 Features

- Add, update, view, delete books
- Register and manage members
- Borrow books and return them
- Track active borrowings and history
- Book availability auto-updates

---

## 🚀 API Endpoints

### 📘 Book
- `GET /books` – List all books
- `POST /book` – Add a new book
- `PUT /book/{id}` – Update a book
- `DELETE /book/{id}` – Delete a book

### 👤 Member
- `GET /members` – Get all members
- `POST /member` – Add a new member
- `PUT /member/{id}` – Update member
- `DELETE /member/{id}` – Delete member

### 📖 Borrow
- `POST /borrow` – Borrow a book
- `PUT /borrow/{id}` – Return a book
- `GET /borrows` – All borrow records
- `GET /borrow/member/{id}` – Borrow history of a member
- `GET /borrow/active` – Active borrowings

---
## 🙋 Author

**Sagar B N**
🔗 [www.linkedin.com/in/sagar--bn](https://www.linkedin.com/in/sagar--bn)

## 🧬 Swagger UI

> Swagger helps you test APIs from your browser easily.

### 🔧 How to Use:

1. Add this dependency to your `pom.xml`:
```xml
<dependency>
  <groupId>org.springdoc</groupId>
  <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
  <version>2.2.0</version>
</dependency>



