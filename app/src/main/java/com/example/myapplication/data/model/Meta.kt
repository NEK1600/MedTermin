package com.example.myapplication.data.model

data class Meta(
    val id: String,
    val offensive: Boolean,
    val section: String,
    val sort: String,
    val src: String,
    val stems: List<String>,
    val uuid: String
)