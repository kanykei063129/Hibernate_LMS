package org.example.repository;

import org.example.model.Publisher;

import java.util.List;

public interface PublisherRepository {
    String savePublisher(Publisher publisher);
    Publisher getPublisherById(Long id);
    List<Publisher> getAllSortPublishersName(String ascOrDesc);
    String updatePublisher(Long id,Publisher publisher);
    void deletePublisherByName(String name);


}
