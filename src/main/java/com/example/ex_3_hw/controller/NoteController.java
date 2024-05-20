package com.example.ex_3_hw.controller;

import com.example.ex_3_hw.model.Note;
import com.example.ex_3_hw.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notes")
public class NoteController {
    private final NoteService noteService;
    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes(){
        return new ResponseEntity<>(noteService.getAllNotes(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Note> createNote(Note note){
        return new ResponseEntity<>(noteService.createNote(note), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id){
        Note noteById;
        try {
            noteById = noteService.getNoteById(id);
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Note());
        }
        return new ResponseEntity<>(noteById, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@RequestBody Note note){
        return new ResponseEntity<>(noteService.updateNote(note), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Note> deleteNote(@PathVariable Long id){
        noteService.deleteNote(id);
        return ResponseEntity.ok().build();
    }
}
