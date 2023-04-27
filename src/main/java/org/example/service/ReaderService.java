package org.example.service;

import org.example.model.Reader;

import java.util.List;

public interface ReaderService {
    String saveReader(Reader reader);
    String updateReader(Long id,Reader reader);
    Reader getReaderByBookId(Long id);
    String deleteReaderById(Long id);
    List<Reader> getReadersByAuthorId(Long id);
}
