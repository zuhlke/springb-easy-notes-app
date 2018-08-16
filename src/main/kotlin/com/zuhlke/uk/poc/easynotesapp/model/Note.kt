package com.zuhlke.uk.poc.easynotesapp.model

import org.springframework.data.annotation.TypeAlias

@TypeAlias("note")
data class Note(val title: String,
                val content: String) {
}
