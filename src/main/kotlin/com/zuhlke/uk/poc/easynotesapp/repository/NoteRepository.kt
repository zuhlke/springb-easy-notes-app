package com.zuhlke.uk.poc.easynotesapp.repository

import com.zuhlke.uk.poc.easynotesapp.model.Note
import org.springframework.data.repository.CrudRepository

interface NoteRepository : CrudRepository<Note, String> {
}