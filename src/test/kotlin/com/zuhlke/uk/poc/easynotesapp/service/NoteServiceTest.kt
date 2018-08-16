package com.zuhlke.uk.poc.easynotesapp.service

import com.zuhlke.uk.poc.easynotesapp.EasyNotesAppTests
import org.junit.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import kotlin.test.assertEquals

class NoteServiceTest : EasyNotesAppTests() {
    @Autowired
    lateinit var noteService: NoteService

    @Test
    fun testShouldFindThreeNotes() {
        logger.info("Begin testShouldFindThreeNotes")

        // Verify that the notes are as expected.
        val notes = noteService.findAll()
        assertEquals(3, notes.size, "There should be 3 notes.")
        assertEquals(TEST_NOTE_1, notes[0],
                "The first note should be 'First Note'.")
        assertEquals(TEST_NOTE_2, notes[1],
                "The first note should be 'Second Note'.")
        assertEquals(TEST_NOTE_3, notes[2],
                "The first note should be 'Third Note'.")

        logger.info("End testShouldFindThreeNotes")
    }

    companion object {
        val logger: Logger =
                LoggerFactory.getLogger(NoteServiceTest::class.java)
        const val TEST_PLAYER_HANDLE = "testNote"
    }
}