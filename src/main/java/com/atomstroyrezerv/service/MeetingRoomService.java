package com.atomstroyrezerv.service;

import com.atomstroyrezerv.exception.ResourceNotFoundException;
import com.atomstroyrezerv.model.Event;
import com.atomstroyrezerv.model.MeetingRoom;
import com.atomstroyrezerv.repository.EventRepository;
import com.atomstroyrezerv.repository.MeetingRoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetingRoomService {

    private final MeetingRoomRepository meetingRoomRepository;
    private final EventRepository eventRepository;

    public MeetingRoomService(MeetingRoomRepository meetingRoomRepository,
                              EventRepository eventRepository) {
        this.meetingRoomRepository = meetingRoomRepository;
        this.eventRepository = eventRepository;
    }

    public List<MeetingRoom> findAll() {
        return meetingRoomRepository.findAll();
    }

    public MeetingRoom getMeetingRoomById(Integer id) throws ResourceNotFoundException {
        MeetingRoom meetingRoom = meetingRoomRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Meeting room was not found for id:" + id));
        return meetingRoom;
    }

    public MeetingRoom save(MeetingRoom meetingRoom){
        return meetingRoomRepository.save(meetingRoom);
    }

    public void deleteMeetingRoom(Integer id) throws ResourceNotFoundException {
        MeetingRoom meetingRoom = meetingRoomRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Meeting Room was not found for id:" + id));
        List<Event> events = eventRepository.findAllByMeetingRoom(id);
        eventRepository.deleteAll(events);
        meetingRoomRepository.delete(meetingRoom);
    }
}
