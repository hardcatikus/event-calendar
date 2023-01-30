package com.atomstroyrezerv.controller;

import com.atomstroyrezerv.model.MeetingRoom;
import com.atomstroyrezerv.service.MeetingRoomService;
import org.springframework.web.bind.annotation.GetMapping;
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

}
