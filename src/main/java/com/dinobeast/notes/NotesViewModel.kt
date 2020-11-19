package com.dinobeast.notes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.dinobeast.notes.Database.Notes
import com.dinobeast.notes.Database.NotesDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesViewModel(application: Application) : AndroidViewModel(application) {
    val allNotes: LiveData<List<Notes>>
    private val repository: NotesRepository

    init {
        val dao = NotesDatabase.getDatabase(application).getNotesDao()
        repository = NotesRepository(dao)
        allNotes = repository.allNotes

    }

    fun deleteNotes(notes: Notes) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(notes)
    }

    fun insertNotes(notes: Notes) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(notes)
    }
}