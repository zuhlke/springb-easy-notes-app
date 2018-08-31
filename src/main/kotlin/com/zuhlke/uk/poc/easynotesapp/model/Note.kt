package com.zuhlke.uk.poc.easynotesapp.model

import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

//@TypeAlias("notes") -- does not work!
@Document(collection = "notes")
data class Note (@Id val _id: String?,
                 val title: String,
                 val content: String,
                 @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                 var createdAt: Date?,
                 @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                 var updatedAt: Date?,
                 var __v: Int?)
