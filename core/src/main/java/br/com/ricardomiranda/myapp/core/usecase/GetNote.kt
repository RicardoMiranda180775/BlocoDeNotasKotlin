package br.com.ricardomiranda.myapp.core.usecase

import br.com.ricardomiranda.myapp.core.repository.NoteRepository

class GetNote (private val noteRepository: NoteRepository) {

    suspend operator fun invoke(id: Long) = noteRepository.getNote(id)

}