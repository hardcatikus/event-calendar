package com.atomstroyrezerv.controller;

import com.atomstroyrezerv.exception.ResourceNotFoundException;
import com.atomstroyrezerv.model.MeetingRoom;
import com.atomstroyrezerv.service.MeetingRoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class MeetingRoomController {

    private final MeetingRoomService meetingRoomService;

    public MeetingRoomController(MeetingRoomService meetingRoomService){
        this.meetingRoomService = meetingRoomService;
    }

    @GetMapping("/meeting-room/all")
    public List<MeetingRoom> getAllMeetingRooms() {
        return meetingRoomService.findAll();
    }

    @GetMapping("/meeting-room/{id}")
    public ResponseEntity<MeetingRoom> getMeetingRoomById
            (@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        return ResponseEntity.ok(meetingRoomService.getMeetingRoomById(id));
    }

}
