package com.neilist.mrs.repository;

import com.neilist.mrs.domain.VolunteerAvailability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository()
public interface VolunteerAvailabilityRepository extends JpaRepository<VolunteerAvailability, Long> {

}