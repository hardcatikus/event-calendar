package com.atomstroyrezerv.controller;

import com.atomstroyrezerv.exception.ResourceNotFoundException;
import com.atomstroyrezerv.model.Event;
import com.atomstroyrezerv.response.UpdateResponse;
import com.atomstroyrezerv.service.EventService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/event/all")
    public List<Event> getAllEvents() {
        return eventService.findAll();
    }

    @GetMapping("/event/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        return ResponseEntity.ok(eventService.getEventById(id));
    }

    @PostMapping("/event/add")
    public Event createEvent(@RequestBody Event event) {
        return eventService.save(event);
    }

    @GetMapping("/event/allByMeetingRoomAndDay")
    public ResponseEntity<List<Event>> getAllEventsByMeetingRoomAndDay
            (@RequestParam(value = "meetingRoom") Integer meetingRoom,
             @RequestParam(value = "dayStart") @DateTimeFormat(pattern="yyyy-MM-dd") Date dayStart) {
        return ResponseEntity.ok(eventService.findAllByMeetingRoomAndDay(meetingRoom,dayStart));
    }

    @PatchMapping("/event/{id}")
    public ResponseEntity<UpdateResponse> updateEventVersion
            (@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        eventService.updateEventLastVersion(id,false);
        return ResponseEntity.ok(new UpdateResponse("Event with id: " + id + " was updated"));
    }

    @GetMapping("/event/allByDay")
    public ResponseEntity<List<Event>> getAllEventsByDay
            (@RequestParam(value = "dayStart") @DateTimeFormat(pattern="yyyy-MM-dd") Date dayStart) {
        return ResponseEntity.ok(eventService.findAllByDay(dayStart));
    }

    @GetMapping("/event/allStates")
    public ResponseEntity<List<Event>> getAllEventStates(@RequestParam(value = "id") Integer id){
        return ResponseEntity.ok(eventService.findEventStates(id));
    }

}
