package com.zuhlke.uk.poc.easynotesapp.controller

import com.zuhlke.uk.poc.easynotesapp.service.NoteServiceTest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.test.web.servlet.MockMvc

@AutoConfigureMockMvc
abstract class NoteControllerTestFongoMockMvc : NoteServiceTest() {
    @Autowired
    lateinit var mvc: MockMvc
}
