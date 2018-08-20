package com.zuhlke.uk.poc.easynotesapp.model

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.TypeAlias
import java.util.*

@TypeAlias("notes")
data class Note(@Id val _id: String,
                val title: String,
                val content: String,
                val createdAt: Date,
                val updatedAt: Date,
                val __v: Int) {
}
