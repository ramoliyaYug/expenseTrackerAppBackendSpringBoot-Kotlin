package com.example.expensetrackerapp.service

import com.example.expensetrackerapp.dataSources.ExpenseRepository
import com.example.expensetrackerapp.model.Expense
import org.springframework.stereotype.Service

@Service
class ExpenseService(
    private val expensesRepository: ExpenseRepository
) {
    fun getAllExpenses(): List<Expense> {
        return expensesRepository.getAllExpenses()
    }

    fun addExpense(expense: Expense) {
        expensesRepository.addExpense(expense)
    }

    fun deleteExpenseByExpense(expense: Expense){
        expensesRepository.deleteExpenseByExpense(expense)
    }

    fun deleteExpenseById(id: String){
        expensesRepository.deleteExpenseById(id)
    }

    fun updateExpenseByExpense(expense: Expense) {
        expensesRepository.updateExpenseByExpense(expense)
    }

    fun getExpenseByDate(date: String): List<Expense> {
        return expensesRepository.getExpenseByDate(date)
    }

    fun getExpenseByCategory(category: String): List<Expense> {
        return expensesRepository.getExpenseByCategory(category)
    }
}