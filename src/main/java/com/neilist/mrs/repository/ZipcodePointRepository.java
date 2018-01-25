package com.neilist.mrs.repository;

import com.neilist.mrs.domain.ZipcodePoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository()
public interface ZipcodePointRepository extends JpaRepository<ZipcodePoint, String> {

}