package com.zuhlke.uk.poc.easynotesapp.controller

import com.zuhlke.uk.poc.easynotesapp.model.Note
import com.zuhlke.uk.poc.easynotesapp.model.Response
import com.zuhlke.uk.poc.easynotesapp.service.NoteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class NoteController {
    @Autowired
    lateinit var noteService: NoteService

    @GetMapping("/notes")
    fun findAll(): ResponseEntity<List<Note>> = ResponseEntity.ok(noteService.findAll())

    @GetMapping("/notes/{id}")
    fun findById(@PathVariable id: String): ResponseEntity<Any> {
        return if (noteService.findById(id).isPresent) {
            ResponseEntity.ok(noteService.findById(id).get())
        } else {
            ResponseEntity(Response("Note not found with id $id"), HttpStatus.NOT_FOUND)
        }

//        return noteService.findById(id).map { note -> ResponseEntity.ok(note) }.orElse(ResponseEntity.notFound().build())
    }
}