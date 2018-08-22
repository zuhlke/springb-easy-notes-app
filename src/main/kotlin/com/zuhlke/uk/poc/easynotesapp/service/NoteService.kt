package com.zuhlke.uk.poc.easynotesapp.service

import com.zuhlke.uk.poc.easynotesapp.model.Note
import com.zuhlke.uk.poc.easynotesapp.repository.NoteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

interface NoteService {

    /**
     * Returns all instances of the type Note.
     *
     * @return all entities
     */
    fun findAll(): List<Note>

    fun findById(id: String): Optional<Note>
}

@Service("noteService")
class NoteServiceImpl : NoteService {
    @Autowired
    lateinit var noteRepository: NoteRepository

    override fun findAll(): List<Note> = noteRepository.findAll().toList()
    override fun findById(id: String): Optional<Note> = noteRepository.findById(id)
}