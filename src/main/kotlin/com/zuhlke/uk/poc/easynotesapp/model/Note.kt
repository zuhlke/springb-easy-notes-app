package com.zuhlke.uk.poc.easynotesapp.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.TypeAlias

@TypeAlias("note")
data class Note(val id: ObjectId,
                val title: String,
                val content: String) {
}
