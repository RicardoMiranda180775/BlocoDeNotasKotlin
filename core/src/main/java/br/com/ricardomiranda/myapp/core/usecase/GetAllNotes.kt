package br.com.ricardomiranda.myapp.core.usecase

import br.com.ricardomiranda.myapp.core.repository.NoteRepository

class GetAllNotes(private val noteRepository: NoteRepository) {

    suspend operator fun invoke() = noteRepository.getAllNotes()
}