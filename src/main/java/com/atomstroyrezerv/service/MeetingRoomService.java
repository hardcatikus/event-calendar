package com.atomstroyrezerv.service;

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

}
