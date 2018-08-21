package com.zuhlke.uk.poc.easynotesapp

import com.github.fakemongo.junit.FongoRule
import com.zuhlke.uk.poc.easynotesapp.model.Note
import com.zuhlke.uk.poc.easynotesapp.repository.NoteRepository
import org.junit.Rule
import org.springframework.beans.factory.annotation.Autowired
import java.util.*

abstract class EasyNotesAppData() {

	@get:Rule
	val fongoRule = FongoRule()

	@Autowired
	lateinit var noteRepository: NoteRepository

	protected fun setupNoNotes() {
		noteRepository.deleteAll()
	}

	protected fun setupFirstNote() {
		noteRepository.deleteAll()
		noteRepository.save(TEST_NOTE_1)
	}

	protected fun setupSecondNote() {
		noteRepository.deleteAll()
		noteRepository.save(TEST_NOTE_2)
	}

	protected fun setupTwoNotes() {
		noteRepository.deleteAll()
		noteRepository.save(TEST_NOTE_1)
		noteRepository.save(TEST_NOTE_2)
	}

	companion object {
		val TEST_NOTE_1 = Note(
				"1b71b7eeecbd28bac0b3f1ea",
				"First Note",
				"Doe, a deer, a female deer",
				Date(),
				Date(),
				0)
		val TEST_NOTE_2 = Note(
				"28bac0b3f1ea1b71b7eeecdb",
				"Second Note",
				"Ray, a drop of golden sun",
				Date(),
				Date(),
				0)
	}
}
