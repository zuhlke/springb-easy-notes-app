package com.zuhlke.uk.poc.easynotesapp.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

//@TypeAlias("notes") -- does not work!
@Document(collection = "notes")
data class Note(@Id val _id: String,
                val title: String,
                val content: String,
                val createdAt: Date,
                val updatedAt: Date,
                val __v: Int) {
}
