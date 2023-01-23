package com.atomstroyrezerv.service;

import com.atomstroyrezerv.dto.EventDTO;
import com.atomstroyrezerv.exception.ResourceNotFoundException;
import com.atomstroyrezerv.model.Event;
import com.atomstroyrezerv.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public HashSet<EventDTO> getEvents() {
        List<Event> events = eventRepository.findAll();
        HashSet<EventDTO> result = new HashSet<>();
        for (Event event : events) {
            EventDTO eventDTO = new EventDTO(event.getId(), event.getName(), event.getStartTime(), event.getEndTime());
            result.add(eventDTO);
        }
        return result;
    }

    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    public Event getEventById(Integer id) throws ResourceNotFoundException {
        Event event = eventRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Event was not found for id:" + id));
        return event;
    }

    public Event save(Event event) {
        return eventRepository.save(event);
    }
}
