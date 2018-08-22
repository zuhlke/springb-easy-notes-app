package com.zuhlke.uk.poc.easynotesapp.controller

import com.zuhlke.uk.poc.easynotesapp.EasyNotesAppData
import org.springframework.test.context.ActiveProfiles
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@ActiveProfiles("pactVerify")
class NoteControllerPactSetup : EasyNotesAppData() {

    @PostMapping("/setup")
    fun setup(@RequestParam(value = "state", defaultValue = "not specified") state : String) {
        when(state) {
            "no notes" -> setupNoNotes()
            "first note" -> setupFirstNote()
            "second note" -> setupSecondNote()
            "two notes" -> setupTwoNotes()
            else -> throw Exception("Unknown state requested: '$state'")
        }
    }
}
