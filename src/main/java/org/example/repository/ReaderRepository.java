package org.example.repository;

import org.example.model.Book;
import org.example.model.Reader;

import java.util.List;

public interface ReaderRepository {
    String saveReader(Reader reader);
    String updateReader(Long id,Reader reader);
    Reader getReaderByBookId(Long id);
    String deleteReaderById(Long id);
    List<Reader> getReadersByAuthorId(Long id);
}
