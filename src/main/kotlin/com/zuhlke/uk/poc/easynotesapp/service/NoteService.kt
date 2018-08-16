package com.zuhlke.uk.poc.easynotesapp.service

import com.zuhlke.uk.poc.easynotesapp.model.Note
import com.zuhlke.uk.poc.easynotesapp.repository.NoteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

public interface NoteService {

    /**
     * Returns all instances of the type Note.
     *
     * @return all entities
     */
    abstract fun findAll(): List<Note>
}

@Service("noteService")
class NoteServiceImpl : NoteService {
    @Autowired
    lateinit var noteRepository: NoteRepository

    override fun findAll(): List<Note> = noteRepository.findAll().toList();
}