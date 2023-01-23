package com.atomstroyrezerv.controller;

import com.atomstroyrezerv.exception.ResourceNotFoundException;
import com.atomstroyrezerv.model.Event;
import com.atomstroyrezerv.service.EventService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/events")
    public List<Event> getAllEvents() {
        return eventService.findAll();
    }

    @GetMapping("/events/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        return ResponseEntity.ok(eventService.getEventById(id));
    }

    @PostMapping("/events")
    public Event createEvent(@RequestBody Event event) {
        return eventService.save(event);
    }
}
