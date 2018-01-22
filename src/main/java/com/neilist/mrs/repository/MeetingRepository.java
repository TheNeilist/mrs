package com.neilist.mrs.repository;

import com.neilist.mrs.domain.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository()
public interface MeetingRepository extends JpaRepository<Meeting, Long> {

}