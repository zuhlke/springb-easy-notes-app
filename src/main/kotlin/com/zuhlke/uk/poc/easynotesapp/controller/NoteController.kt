package com.zuhlke.uk.poc.easynotesapp.controller

import com.zuhlke.uk.poc.easynotesapp.model.Note
import com.zuhlke.uk.poc.easynotesapp.service.NoteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class NoteController {
    @Autowired
    lateinit var noteService: NoteService

    @GetMapping("/notes")
    fun findAll(): List<Note> = noteService.findAll()
}