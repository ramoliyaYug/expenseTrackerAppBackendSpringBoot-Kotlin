package com.example.expensetrackerapp.dataSources

import com.example.expensetrackerapp.model.Expense
import org.springframework.stereotype.Repository

@Repository
class ExpenseRepositoryImpl : ExpenseRepository {

    private val expenses = mutableListOf<Expense>()

    override fun getAllExpenses(): List<Expense> {
        return expenses
    }

    override fun addExpense(expense: Expense) {
        expenses.add(expense)
    }

    override fun deleteExpenseByExpense(expense: Expense) {
        if (expenses.contains(expense)) {
            expenses.remove(expense)
        }else{
            throw NoSuchElementException("Expense with id $expense does not exists")
        }
    }

    override fun deleteExpenseById(id: String) {
        val expense = expenses.find { it.id == id }
        if (expense != null) {
            expenses.remove(expense)
        }else{
            throw NoSuchElementException("Expense with id $id does not exists")
        }
    }

    override fun updateExpenseByExpense(expense: Expense) {
        val index = expenses.indexOfFirst { it.id == expense.id }
        if (index != -1) {
            expenses[index] = expense
        }else{
            throw NoSuchElementException("Expense with id ${expense.id} does not exists")
        }
    }

    override fun getExpenseByDate(date: String): List<Expense> {
        val expense = expenses.filter { it.date == date }
        return expense
    }

    override fun getExpenseByCategory(category: String): List<Expense> {
        val expense = expenses.filter { it.category == category }
        return expense
    }
}