package br.com.ricardomiranda.myapp.core.usecase

import br.com.ricardomiranda.myapp.core.data.Note
import br.com.ricardomiranda.myapp.core.repository.NoteRepository

class AddNote(private val noteRepository: NoteRepository) {
    suspend operator fun invoke(note: Note) = noteRepository.addNote(note)
}