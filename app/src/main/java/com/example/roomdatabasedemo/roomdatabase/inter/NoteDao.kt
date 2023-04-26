package com.example.roomdatabase.inter

import androidx.room.*
import com.example.roomdatabase.dataclass.Contact

@Dao
interface NoteDao {

    @Insert
    fun addNote(note: Contact)

    @Query("SELECT * FROM Contact")
    fun getNotes(): List<Contact>
//
//    @Update
//    suspend fun updateNote(note: Contact)
//
//    @Delete
//    suspend fun deleteNote(note: Contact)

}