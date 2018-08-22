package com.zuhlke.uk.poc.easynotesapp.service

import com.zuhlke.uk.poc.easynotesapp.model.Note
import com.zuhlke.uk.poc.easynotesapp.repository.NoteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.text.SimpleDateFormat
import java.util.*

interface NoteService {

    /**
     * Returns all instances of the type Note.
     *
     * @return all entities
     */
    fun findAll(): List<Note>

    fun findById(id: String): Optional<Note>

    fun findByIdAndUpdate(id: String, note: Note): Optional<Note>

    fun save(note: Note): Note
}

@Service("noteService")
class NoteServiceImpl : NoteService {
    @Autowired
    lateinit var noteRepository: NoteRepository

    override fun findAll(): List<Note> = noteRepository.findAll().toList()
    override fun findById(id: String): Optional<Note> = noteRepository.findById(id)
    override fun save(note: Note): Note = noteRepository.save(note)
    override fun findByIdAndUpdate(id: String, note: Note): Optional<Note> {
        val existingNote = findById(id)
        return if(existingNote.isPresent) {
            Optional.of(save(Note(existingNote.get()._id, note.title, note.content, existingNote.get().createdAt, sdf.format(Date()), existingNote.get().__v)))
        } else {
            Optional.empty()
        }
    }

    companion object {
        val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    }
}