package com.example.ex_3_hw.repository;

import com.example.ex_3_hw.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
