package com.example.expensetrackerapp.controller

import com.example.expensetrackerapp.model.Expense
import com.example.expensetrackerapp.service.ExpenseService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/expenses")
class ExpenseController(
    private val expenseService: ExpenseService
) {
    @ExceptionHandler(IllegalArgumentException::class)
    fun handleIllegalArgumentException(e: IllegalArgumentException): ResponseEntity<String> {
        return ResponseEntity(e.message, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNoSuchElementException(e: NoSuchElementException): ResponseEntity<String> {
        return ResponseEntity(e.message, HttpStatus.NOT_FOUND)
    }

    @GetMapping
    fun getAllExpenses(): List<Expense> {
        return expenseService.getAllExpenses()
    }

    @PostMapping
    fun addExpense(@RequestBody expense: Expense): ResponseEntity<String> {
        expenseService.addExpense(expense)
        return ResponseEntity("Expense added successfully", HttpStatus.CREATED)
    }

    @DeleteMapping("/byObject")
    fun deleteExpenseByObject(@RequestBody expense: Expense): ResponseEntity<String> {
        expenseService.deleteExpenseByExpense(expense)
        return ResponseEntity("Expense deleted successfully", HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun deleteExpenseById(@PathVariable id: String): ResponseEntity<String> {
        expenseService.deleteExpenseById(id)
        return ResponseEntity("Expense with ID $id deleted successfully", HttpStatus.OK)
    }

    @PutMapping
    fun updateExpense(@RequestBody expense: Expense): ResponseEntity<String> {
        expenseService.updateExpenseByExpense(expense)
        return ResponseEntity("Expense updated successfully", HttpStatus.OK)
    }

    @GetMapping("/byDate")
    fun getExpensesByDate(@RequestParam date: String): List<Expense> {
        return expenseService.getExpenseByDate(date)
    }

    @GetMapping("/byCategory")
    fun getExpensesByCategory(@RequestParam category: String): List<Expense> {
        return expenseService.getExpenseByCategory(category)
    }
}