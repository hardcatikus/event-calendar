package com.atomstroyrezerv.dto;

import java.util.Date;
import java.util.Objects;

public class EventDTO {

    private Integer id;
    private String name;
    private Date startDate;
    private Date endDate;

    public EventDTO(Integer id, String name, Date startDate, Date endDate) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventDTO eventDTO = (EventDTO) o;
        return Objects.equals(name, eventDTO.name) && Objects.equals(id, eventDTO.id)
                && Objects.equals(startDate, eventDTO.startDate) && Objects.equals(endDate, eventDTO.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, startDate, endDate);
    }
}
