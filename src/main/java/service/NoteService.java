package service;

import entity.AnimalNotes;
import repository.NoteRepository;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by katherine_celeste on 8/31/16.
 */
public class NoteService {
    private NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public void createNote(String text, int num) throws IOException, SQLException {
        noteRepository.createNote(text, num);
    }

    public void deleteNote(int noteID) throws IOException, SQLException {
        noteRepository.deleteNote(noteID);
    }

    public ArrayList<AnimalNotes> listNotes(int animalID) {
        ArrayList<AnimalNotes> notes = new ArrayList<>();

        try {
            ResultSet resultSet = this.noteRepository.listNotes(animalID);

            while (resultSet.next()) {
                AnimalNotes aNote = new AnimalNotes(
                        resultSet.getInt("animal_id"),
                        resultSet.getString("note_text"),
                        resultSet.getString("date_time"),
                        resultSet.getInt("note_id")

                );

                notes.add(aNote);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return notes;
    }



}

