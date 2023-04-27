package org.example.service.serviceImpl;

import org.example.model.Reader;
import org.example.repository.ReaderRepository;
import org.example.repository.repositoryImpl.ReaderRepositoryImpl;
import org.example.service.ReaderService;

import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    ReaderRepository repository = new ReaderRepositoryImpl();
    @Override
    public String saveReader(Reader reader) {
        return repository.saveReader(reader);
    }

    @Override
    public String updateReader(Long id, Reader reader) {
        return repository.updateReader(id,reader);
    }

    @Override
    public Reader getReaderByBookId(Long id) {
        return repository.getReaderByBookId(id);
    }

    @Override
    public String deleteReaderById(Long id) {
        return repository.deleteReaderById(id);
    }

    @Override
    public List<Reader> getReadersByAuthorId(Long id) {
        return repository.getReadersByAuthorId(id);
    }
}
