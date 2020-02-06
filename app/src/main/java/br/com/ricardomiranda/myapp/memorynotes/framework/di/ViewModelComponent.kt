package br.com.ricardomiranda.myapp.memorynotes.framework.di

import br.com.ricardomiranda.myapp.memorynotes.framework.ListViewModel
import br.com.ricardomiranda.myapp.memorynotes.framework.NoteViewModel
import dagger.Component

@Component(modules = [ApplicationModule::class, RepositoryModule::class, UseCasesModule::class])
interface ViewModelComponent {
    fun inject(noteViewModel: NoteViewModel)
    fun inject(listViewModel: ListViewModel)
}