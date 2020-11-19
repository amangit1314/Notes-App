package com.dinobeast.notes

import androidx.lifecycle.LiveData
import com.dinobeast.notes.Database.Notes
import com.dinobeast.notes.Database.NotesDao

class NotesRepository(private val notesDao: NotesDao) {
    val allNotes: LiveData<List<Notes>> = notesDao.getAllNotes()

    suspend fun insert(notes: Notes) {
        notesDao.insert(notes)
    }

    suspend fun delete(notes: Notes) {
        notesDao.delete(notes)
    }
}