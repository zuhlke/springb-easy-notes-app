package com.zuhlke.uk.poc.easynotesapp

import com.github.fakemongo.junit.FongoRule
import com.zuhlke.uk.poc.easynotesapp.model.Note
import com.zuhlke.uk.poc.easynotesapp.repository.NoteRepository
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
@ActiveProfiles("test")
abstract class EasyNotesAppTests(val initializeTestData: Boolean = true) {

	@get:Rule
	val fongoRule = FongoRule()

	@Autowired
	lateinit var noteRepository: NoteRepository

	@Before
	fun setupTestDatabase() {
		if (initializeTestData) {
			noteRepository.save(TEST_NOTE_1)
			noteRepository.save(TEST_NOTE_2)
			noteRepository.save(TEST_NOTE_3)
		}
	}

	companion object {
		val TEST_NOTE_1 = Note(
				"1b71b7eeecbd28bac0b3f1ea",
				"First Note",
				"Doe, a deer, a female deer",
				"2018-08-22T13:27:17.496Z",
				"2018-08-22T13:27:17.496Z",
				0)
		val TEST_NOTE_2 = Note(
				"28bac0b3f1ea1b71b7eeecdb",
				"Second Note",
				"Ray, a drop of golden sun",
				"2018-08-22T13:27:17.496Z",
				"2018-08-22T13:27:17.496Z",
				0)
		val TEST_NOTE_3 = Note(
				"38bac0b3f1ea1b71b7eeecdc",
				"Third Note",
				"Me, a name I call myself",
				"2018-08-22T13:27:17.496Z",
				"2018-08-22T13:27:17.496Z",
				0)
	}
}
