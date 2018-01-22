package com.neilist.mrs.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "meeting")
public class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "hostUserId")
    private Long hostUserId;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @Column(name = "date_time")
    private LocalDateTime dateTime;
    @Column(name = "day_of_week")
    private Integer dayOfWeek;
    @Column(name = "minute_of_day")
    private Integer minuteOfDay;

    public Meeting() {
    }

    public Meeting(Long id, Long hostUserId, LocalDateTime dateTime, Integer dayOfWeek, Integer minuteOfDay) {
        this.id = id;
        this.hostUserId = hostUserId;
        this.dateTime = dateTime;
        this.dayOfWeek = dayOfWeek;
        this.minuteOfDay = minuteOfDay;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHostUserId() {
        return hostUserId;
    }

    public void setHostUserId(Long hostUserId) {
        this.hostUserId = hostUserId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(Integer dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Integer getMinuteOfDay() {
        return minuteOfDay;
    }

    public void setMinuteOfDay(Integer minuteOfDay) {
        this.minuteOfDay = minuteOfDay;
    }
}
