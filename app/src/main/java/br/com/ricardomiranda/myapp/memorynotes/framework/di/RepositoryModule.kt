package br.com.ricardomiranda.myapp.memorynotes.framework.di

import android.app.Application
import br.com.ricardomiranda.myapp.core.repository.NoteRepository
import br.com.ricardomiranda.myapp.memorynotes.framework.RoomNoteDataSource
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideRepository(app: Application) = NoteRepository(RoomNoteDataSource(app))
}