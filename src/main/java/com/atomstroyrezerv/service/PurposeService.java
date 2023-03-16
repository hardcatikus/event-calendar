package com.atomstroyrezerv.service;

import com.atomstroyrezerv.exception.ResourceNotFoundException;
import com.atomstroyrezerv.model.Event;
import com.atomstroyrezerv.model.Purpose;
import com.atomstroyrezerv.repository.EventRepository;
import com.atomstroyrezerv.repository.PurposeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurposeService {

    private final PurposeRepository purposeRepository;
    private final EventRepository eventRepository;

    public PurposeService (PurposeRepository purposeRepository,
                           EventRepository eventRepository) {
        this.purposeRepository = purposeRepository;
        this.eventRepository = eventRepository;
    }

    public List<Purpose> findAll() {
        return purposeRepository.findAll();
    }

    public Purpose getPurposeById(Integer id) throws ResourceNotFoundException {
        Purpose purpose = purposeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Purpose was not found for id:" + id));
        return purpose;
    }

    public Purpose save(Purpose purpose){
        return purposeRepository.save(purpose);
    }

    public void deletePurpose(Integer id) throws ResourceNotFoundException {
        Purpose purpose = purposeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Purpose was not found for id:" + id));
        List<Event> events = eventRepository.findAllByPurpose(id);
        eventRepository.deleteAll(events);
        purposeRepository.delete(purpose);
    }

}
