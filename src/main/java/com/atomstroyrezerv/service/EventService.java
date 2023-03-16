package com.atomstroyrezerv.service;

import com.atomstroyrezerv.dto.EventDTO;
import com.atomstroyrezerv.exception.ResourceNotFoundException;
import com.atomstroyrezerv.model.Event;
import com.atomstroyrezerv.model.MeetingRoom;
import com.atomstroyrezerv.model.Purpose;
import com.atomstroyrezerv.repository.EventRepository;
import com.atomstroyrezerv.repository.MeetingRoomRepository;
import com.atomstroyrezerv.repository.PurposeRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final PurposeRepository purposeRepository;
    private final MeetingRoomRepository meetingRoomRepository;

    public EventService(EventRepository eventRepository, PurposeRepository purposeRepository,
                        MeetingRoomRepository meetingRoomRepository) {
        this.eventRepository = eventRepository;
        this.purposeRepository = purposeRepository;
        this.meetingRoomRepository = meetingRoomRepository;
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

    public List<Event> findAllByMeetingRoomAndDay(Integer meetingRoom, Date dayStart){
        Calendar c = Calendar.getInstance();
        c.setTime(dayStart);
        c.add(Calendar.DATE, 1);
        Date dayEnd = c.getTime();
        return eventRepository.findAllByMeetingRoomAndStartTimeGreaterThanEqualAndStartTimeLessThanAndLastVersionIsTrue
                (meetingRoom, dayStart, dayEnd);
    }

    public void updateEventLastVersion(Integer id, Boolean lastVersion) throws ResourceNotFoundException {
        Event event = eventRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Event was not found for id:" + id));
        event.setLastVersion(lastVersion);
        eventRepository.save(event);
    }

    public List<Event> findAllByDay(Date dayStart){
        Calendar c = Calendar.getInstance();
        c.setTime(dayStart);
        c.add(Calendar.DATE, 1);
        Date dayEnd = c.getTime();
        return eventRepository.findAllByStartTimeGreaterThanEqualAndStartTimeLessThanAndLastVersionIsTrue
                (dayStart, dayEnd);
    }

    public List<Event> findEventStates(Integer id){
        return eventRepository.findAllByIdEqualsOrInitialStateEqualsOrderByCreationTimeDesc(id,id);
    }

    public List<EventDTO> getRelevantEvents(Date date){
        List<Event> events = eventRepository.findAllByEndTimeGreaterThanAndLastVersionIsTrueOrderByStartTime(date);
        List<Purpose> purposes = purposeRepository.findAll();
        List<MeetingRoom> meetingRooms = meetingRoomRepository.findAll();
        ArrayList<EventDTO> result = new ArrayList<>();
        for (Event event: events){
            String startTime = event.getStartTime().toString();
            startTime = startTime.substring(8,10) + "." + startTime.substring(5,7) + "."
                    + startTime.substring(0,4) + ", " + startTime.substring(11,16);
            String endTime = event.getEndTime().toString();
            endTime = endTime.substring(8,10) + "." + endTime.substring(5,7) + "."
                    + endTime.substring(0,4) + ", " + endTime.substring(11,16);
            String purposeName = "", meetingRoomName = "";
            for (Purpose purpose: purposes){
                if(purpose.getId() == event.getPurpose()){
                    purposeName = purpose.getName();
                    break;
                }
            }
            for (MeetingRoom meetingRoom: meetingRooms){
                if(meetingRoom.getId() == event.getMeetingRoom()){
                    meetingRoomName = meetingRoom.getName();
                    break;
                }
            }
            EventDTO eventDTO = new EventDTO(event.getName(), startTime, endTime,
                    purposeName, meetingRoomName, event.getApplicant(), event.getParticipantsList());
            result.add(eventDTO);
        }
        return result;
    }

    public void deleteObsoleteEvents(Date currentDate) {
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);
        c.add(Calendar.DATE, -7);
        Date previousWeek = c.getTime();
        List<Event> events = eventRepository.findAllByStartTimeLessThan(previousWeek);
        eventRepository.deleteAll(events);
    }

}
