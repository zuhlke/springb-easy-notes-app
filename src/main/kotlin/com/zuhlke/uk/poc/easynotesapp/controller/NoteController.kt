package com.zuhlke.uk.poc.easynotesapp.controller

import com.zuhlke.uk.poc.easynotesapp.model.DeleteByIdResponse
import com.zuhlke.uk.poc.easynotesapp.model.Note
import com.zuhlke.uk.poc.easynotesapp.model.Response
import com.zuhlke.uk.poc.easynotesapp.service.NoteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class NoteController {
    @Autowired
    lateinit var noteService: NoteService

    @GetMapping("/notes")
    fun findAll(): ResponseEntity<List<Note>> = ResponseEntity.ok(noteService.findAll())

    @GetMapping("/notes/{id}")
    fun findById(@PathVariable id: String): ResponseEntity<Any> {
        val optionalNote = noteService.findById(id)
        return if (optionalNote.isPresent) {
            ResponseEntity.ok(optionalNote.get())
        } else {
            ResponseEntity(Response("Note not found with id $id"), HttpStatus.NOT_FOUND)
        }

//        return noteService.findById(id).map { note -> ResponseEntity.ok(note) }.orElse(ResponseEntity.notFound().build())
    }

    @PostMapping("/notes")
    fun save(@RequestBody note: Note): ResponseEntity<Note> = ResponseEntity.ok(noteService.save(note))

    @PutMapping("/notes/{id}")
    fun findByIdAndUpdate(@PathVariable id: String, @RequestBody note: Note): ResponseEntity<Any> {
        val optionalNote = noteService.findByIdAndUpdate(id, note)
        return if (optionalNote.isPresent) {
            ResponseEntity.ok(optionalNote.get())
        } else {
            ResponseEntity(Response("Note not found with id $id"), HttpStatus.NOT_FOUND)
        }
    }

    @DeleteMapping("/notes/{id}")
    fun deleteById(@PathVariable id: String): ResponseEntity<Any> {
        val optionalNote = noteService.deleteById(id)
        return if(optionalNote.isPresent) {
            ResponseEntity.ok(DeleteByIdResponse("Note deleted successfully.", optionalNote.get()))
        } else {
            ResponseEntity(Response("Note not found with id $id"), HttpStatus.NOT_FOUND)
        }
    }

    @DeleteMapping("/notes")
    fun deleteAll(): ResponseEntity<Response> {
        noteService.deleteAll()
        return ResponseEntity.ok(Response("All notes deleted successfully."))
    }
}