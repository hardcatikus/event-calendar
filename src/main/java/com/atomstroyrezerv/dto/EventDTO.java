package com.atomstroyrezerv.dto;

import java.util.Objects;

public class EventDTO {

    private String name;
    private String startTime;
    private String endTime;
    private String purpose;
    private String meetingRoom;
    private String applicant;
    private String participantsList;

    public EventDTO(String name, String startDate, String endDate, String purpose,
                    String meetingRoom, String applicant, String participantsList) {
        this.name = name;
        this.startTime = startDate;
        this.endTime = endDate;
        this.purpose = purpose;
        this.meetingRoom = meetingRoom;
        this.applicant = applicant;
        this.participantsList = participantsList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getMeetingRoom() {
        return meetingRoom;
    }

    public void setMeetingRoom(String meetingRoom) {
        this.meetingRoom = meetingRoom;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public String getParticipantsList() {
        return participantsList;
    }

    public void setParticipantsList(String participantsList) {
        this.participantsList = participantsList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventDTO eventDTO = (EventDTO) o;
        return Objects.equals(name, eventDTO.name) && Objects.equals(startTime, eventDTO.startTime)
                && Objects.equals(endTime, eventDTO.endTime) && Objects.equals(purpose, eventDTO.purpose)
                && Objects.equals(meetingRoom, eventDTO.meetingRoom) && Objects.equals(applicant, eventDTO.applicant)
                && Objects.equals(participantsList, eventDTO.participantsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, startTime, endTime, purpose, meetingRoom, applicant, participantsList);
    }
}
