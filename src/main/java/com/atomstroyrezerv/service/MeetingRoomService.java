package com.atomstroyrezerv.service;

import com.atomstroyrezerv.exception.ResourceNotFoundException;
import com.atomstroyrezerv.model.MeetingRoom;
import com.atomstroyrezerv.repository.MeetingRoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetingRoomService {

    private final MeetingRoomRepository meetingRoomRepository;

    public MeetingRoomService(MeetingRoomRepository meetingRoomRepository) {
        this.meetingRoomRepository = meetingRoomRepository;
    }

    public List<MeetingRoom> findAll() {
        return meetingRoomRepository.findAll();
    }

    public MeetingRoom getMeetingRoomById(Integer id) throws ResourceNotFoundException {
        MeetingRoom meetingRoom = meetingRoomRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Meeting room was not found for id:" + id));
        return meetingRoom;
    }
}
