package com.example.expensetrackerapp.dataSources

import com.example.expensetrackerapp.model.Expense

interface ExpenseRepository {
    fun getAllExpenses() : List<Expense>

    fun addExpense(expense: Expense)

    fun deleteExpenseByExpense(expense: Expense)

    fun deleteExpenseById(id: String)

    fun updateExpenseByExpense(expense: Expense)

    fun getExpenseByDate(date: String): List<Expense>

    fun getExpenseByCategory(category: String): List<Expense>
}