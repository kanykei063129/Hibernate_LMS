package org.example.service;

import org.example.model.Publisher;

import java.util.List;

public interface PublisherService {
    String savePublisher(Publisher publisher);
    Publisher getPublisherById(Long id);
    List<Publisher> getAllSortPublishersName(String ascOrDesc);
    String updatePublisher(Long id,Publisher publisher);
    void deletePublisherByName(String name);
}
