package com.example.ex_3_hw.service;

import com.example.ex_3_hw.model.Note;

import java.util.List;

public interface NoteService {
    List<Note> getAllNotes();

    Note getNoteById(Long id);

    Note updateNote(Note note);

    Note createNote(Note note);

    void deleteNote(Long id);
}
