package com.zuhlke.uk.poc.easynotesapp.controller

import com.zuhlke.uk.poc.easynotesapp.service.NoteServiceTest
import org.junit.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import kotlin.test.assertEquals

class NoteControllerTest : NoteControllerTestFongoMockMvc() {

    @Test
    fun testControllerShouldFindThreeNotes() {
        NoteServiceTest.logger.info("Begin testControllerShouldFindThreeNotes")

        // Verify that the notes are as expected.
        val notes = noteService.findAll()
        assertEquals(3, notes.size, "There should be 3 notes.")
        assertEquals(TEST_NOTE_1, notes[0],
                "The first note should be 'First Note'.")
        assertEquals(TEST_NOTE_2, notes[1],
                "The first note should be 'Second Note'.")
        assertEquals(TEST_NOTE_3, notes[2],
                "The first note should be 'Third Note'.")

        NoteServiceTest.logger.info("End testControllerShouldFindThreeNotes")
    }

    companion object {
        val logger: Logger =
                LoggerFactory.getLogger(NoteControllerTest::class.java)
    }
}