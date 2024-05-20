package com.example.ex_3_hw.service.impl;

import com.example.ex_3_hw.model.Note;
import com.example.ex_3_hw.repository.NoteRepository;
import com.example.ex_3_hw.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteServiceImplement implements NoteService {
    private final NoteRepository noteRepository;

    @Override
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @Override
    public Note getNoteById(Long id) {
        return noteRepository.findById(id).orElseThrow();
    }

    @Override
    public Note updateNote(Note note) {
        Note noteFind = getNoteById(note.getId());
        noteFind.setTitle(note.getTitle());
        noteFind.setContent(note.getContent());
        noteFind.setDateTimeCreate(note.getDateTimeCreate());
        return noteRepository.save(noteFind);
    }

    @Override
    public Note createNote(Note note) {
        note.setDateTimeCreate(LocalDateTime.now());
        return noteRepository.save(note);
    }

    @Override
    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }
}
