# 📦 Expense Tracker API (Spring Boot + Kotlin)

A simple RESTful API backend for an Expense Tracker app built with **Spring Boot** and **Kotlin** using **MVC** architecture.  
This backend serves the core functionalities such as **adding**, **retrieving**, **updating**, and **deleting** expense entries.

---

## 🚀 Features

- 🔁 CRUD operations for expenses
- 📅 Filter by date
- 🧾 Filter by category
- 📡 Exposes clean RESTful endpoints
- 🧩 Modular structure using Controller, Service, Model, and DataSources packages
- ⚡️ Fast, stateless API (no auth or database for simplicity)

---

---

## 🔗 API Endpoints

| Method | Endpoint                  | Description                  |
|--------|---------------------------|------------------------------|
| GET    | `/expenses`              | Get all expenses              |
| GET    | `/expenses/date/{date}`  | Get expenses by date          |
| GET    | `/expenses/category/{c}` | Get expenses by category      |
| POST   | `/expenses`              | Add a new expense             |
| PUT    | `/expenses`              | Update an expense by ID       |
| DELETE | `/expenses/{id}`         | Delete an expense by ID       |

---

## 📦 Sample JSON Body

```json
{
  "title": "Ganne Ka Juice",
  "amount": 20.0,
  "date": "2025-07-24",
  "category": "Drinks",
  "note": "Ganne Ka Juice Bada Gilas 20 Rupe Idher Idher Chale Aaiye"
}
```
