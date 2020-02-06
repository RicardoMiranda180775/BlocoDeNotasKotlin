package br.com.ricardomiranda.myapp.memorynotes.framework

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import br.com.ricardomiranda.myapp.core.data.Note
import br.com.ricardomiranda.myapp.memorynotes.framework.di.ApplicationModule
import br.com.ricardomiranda.myapp.memorynotes.framework.di.DaggerViewModelComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class NoteViewModel(application: Application) : AndroidViewModel(application) {

    private val coroutinesScope = CoroutineScope(Dispatchers.IO)

    @Inject
    lateinit var useCases : UseCases

    init {
        DaggerViewModelComponent.builder()
            .applicationModule(ApplicationModule(getApplication()))
            .build()
            .inject(this)
    }

    val saved = MutableLiveData<Boolean>()
    val currentNote = MutableLiveData<Note?>()

    fun saveNote(note: Note){
        coroutinesScope.launch {
            useCases.addNote(note)
            saved.postValue(true)
        }
    }

    fun getNote(id:Long){
        coroutinesScope.launch {
           val note = useCases.getNote(id)
            currentNote.postValue(note)
        }
    }

    fun deleteNote(note: Note){
        coroutinesScope.launch {
            val note = useCases.removeNote(note)
            saved.postValue(true)
        }
    }
}