package com.atomstroyrezerv.repository;

import com.atomstroyrezerv.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

    List<Event> findAllByMeetingRoomAndStartTimeGreaterThanEqualAndStartTimeLessThanAndLastVersionIsTrue
            (Integer meetingRoom, Date dayStart, Date dayEnd);

    List<Event> findAllByStartTimeGreaterThanEqualAndStartTimeLessThanAndLastVersionIsTrue
            (Date dayStart, Date dayEnd);

    List<Event> findAllByIdEqualsOrInitialStateEqualsOrderByCreationTimeDesc(Integer id1, Integer id2);

    List<Event> findAllByEndTimeGreaterThanAndLastVersionIsTrueOrderByStartTime (Date currentDate);

    List<Event> findAllByStartTimeLessThan(Date previousWeek);

    List<Event> findAllByMeetingRoom(Integer meetingRoomId);

    List<Event> findAllByPurpose(Integer purposeId);

}
