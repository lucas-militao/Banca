package com.example.banca

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

fun FragmentManager.inTransaction(transaction: FragmentTransaction.() -> Unit) {

    beginTransaction().apply(transaction).commit()

}