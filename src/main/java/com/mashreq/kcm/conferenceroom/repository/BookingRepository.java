package com.mashreq.kcm.conferenceroom.repository;

import com.mashreq.kcm.conferenceroom.model.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Bookings, Long> {
    @Query(value="select * from bookings where conference_name = :conferenceName", nativeQuery = true)
    Optional<Bookings> findByConferenceName(String conferenceName);
    @Query(value="select * from bookings where start_time >= :startTime and end_time <= :endTime", nativeQuery = true)
    List<Bookings> findByStartTimeAndEndTime(String startTime, String endTime);
}

