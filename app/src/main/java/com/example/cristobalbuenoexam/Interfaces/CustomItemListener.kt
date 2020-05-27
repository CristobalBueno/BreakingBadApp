package com.example.cristobalbuenoexam.Interfaces

import com.example.cristobalbuenoexam.Models.ResultItem

interface CustomItemListener {
    fun onItemClick(item: ResultItem)
    fun onLongItemClick(item: ResultItem)
}