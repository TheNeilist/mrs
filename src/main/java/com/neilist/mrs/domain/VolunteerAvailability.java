package com.neilist.mrs.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "volunteer_availability")
public class VolunteerAvailability {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @NotNull
    @Column(name = "volunteer_user_id")
    private Long volunteerUserId;
    @NotNull
    @Column(name = "day_of_week")
    private Integer dayOfWeek;
    @Transient
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime startTime;
    @Column(name = "start_minute")
    private Integer startMinute;
    @Transient
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime endTime;
    @Column(name = "end_minute")
    private Integer endMinute;

    public VolunteerAvailability() {
    }

    public VolunteerAvailability(Long id, Long volunteerUserId, Integer dayOfWeek, LocalDateTime startTime, Integer startMinute, LocalDateTime endTime, Integer endMinute) {
        this.id = id;
        this.volunteerUserId = volunteerUserId;
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.startMinute = startMinute;
        this.endTime = endTime;
        this.endMinute = endMinute;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVolunteerUserId() {
        return volunteerUserId;
    }

    public void setVolunteerUserId(Long volunteerUserId) {
        this.volunteerUserId = volunteerUserId;
    }

    public Integer getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(Integer dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public Integer getStartMinute() {
        return startMinute;
    }

    public void setStartMinute(Integer startMinute) {
        this.startMinute = startMinute;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Integer getEndMinute() {
        return endMinute;
    }

    public void setEndMinute(Integer endMinute) {
        this.endMinute = endMinute;
    }
}
