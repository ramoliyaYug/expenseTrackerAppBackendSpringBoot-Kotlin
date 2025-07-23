package com.example.expensetrackerapp.model

import java.util.UUID

data class Expense(
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val amount: Double,
    val date: String,
    val category: String,
    val note: String ?= null
)
