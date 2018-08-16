package com.zuhlke.uk.poc.easynotesapp

import com.github.fakemongo.junit.FongoRule
import com.zuhlke.uk.poc.easynotesapp.model.Note
import com.zuhlke.uk.poc.easynotesapp.repository.NoteRepository
import org.bson.types.ObjectId
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
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
		val TEST_NOTE_1 = Note(ObjectId("1b71b7eeecbd28bac0b3f1ea"), "First Note", "Doe, a deer, a female deer")
		val TEST_NOTE_2 = Note(ObjectId("28bac0b3f1ea1b71b7eeecdb"), "Second Note", "Ray, a drop of golden sun")
		val TEST_NOTE_3 = Note(ObjectId("38bac0b3f1ea1b71b7eeecdc"), "Third Note", "Me, a name I call myself")
	}
}
