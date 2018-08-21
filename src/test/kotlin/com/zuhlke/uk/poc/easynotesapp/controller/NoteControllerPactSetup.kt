package com.zuhlke.uk.poc.easynotesapp.controller

import com.zuhlke.uk.poc.easynotesapp.service.NoteService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class NoteControllerPactSetup {
    @Autowired
    lateinit var noteService: NoteService

    @PostMapping("/setup")
    fun setup(@RequestParam(value = "state", defaultValue = "not specified") state : String) : String {
        logger.info("setup state $state")
        return ""
    }

    companion object {
        val logger: Logger =
                LoggerFactory.getLogger(NoteControllerPactSetup::class.java)
    }
}