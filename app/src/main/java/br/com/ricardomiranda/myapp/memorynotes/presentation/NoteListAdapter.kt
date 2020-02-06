package br.com.ricardomiranda.myapp.memorynotes.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.ricardomiranda.myapp.core.data.Note
import br.com.ricardomiranda.myapp.memorynotes.R
import kotlinx.android.synthetic.main.item_note.view.*
import java.text.SimpleDateFormat
import java.util.*

class NoteListAdapter(var notes: ArrayList<Note>, val actions: ListAction): RecyclerView.Adapter<NoteListAdapter.NoteViewHolder>(){

    fun updateNotes(newNotes:List<Note> ){
        notes.clear()
        notes.addAll(newNotes)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int ) = NoteViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_note,parent,false)
    )

    override fun getItemCount() = notes.size

    override fun onBindViewHolder(holder: NoteListAdapter.NoteViewHolder, position: Int) {
        holder.bind(notes[position])
    }

    inner class NoteViewHolder(view: View): RecyclerView.ViewHolder(view){
        private val layout = view.noteLayout
        private val noteTitle = view.title
        private val noteContent = view.content
        private val noteDate = view.date
        private val noteWords = view.wordCount

        fun bind(note: Note){
            noteTitle.text = note.title
            noteContent.text = note.content

            val sdf = SimpleDateFormat("MMM DD, HH:mm:ss")
            var resultDate = Date(note.updateTime)
            noteDate.text = "Last Update: ${sdf.format(resultDate)}"

            layout.setOnClickListener{actions.onClick(note.id)}

            noteWords.text = "Words: ${note.wordCount}"
        }
    }

}