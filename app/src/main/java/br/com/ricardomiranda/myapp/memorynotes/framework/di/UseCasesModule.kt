package br.com.ricardomiranda.myapp.memorynotes.framework.di

import br.com.ricardomiranda.myapp.core.repository.NoteRepository
import br.com.ricardomiranda.myapp.core.usecase.*
import br.com.ricardomiranda.myapp.memorynotes.framework.UseCases
import dagger.Module
import dagger.Provides

@Module
class UseCasesModule {

    @Provides
    fun getUseCases(repository: NoteRepository) = UseCases(
        AddNote(repository),
        GetAllNotes(repository),
        GetNote(repository),
        RemoveNote(repository),
        GetWordCount()
    )
}