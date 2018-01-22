package com.neilist.mrs.controller;

import com.neilist.mrs.domain.Meeting;
import com.neilist.mrs.domain.VolunteerAvailability;
import com.neilist.mrs.repository.MeetingRepository;
import com.neilist.mrs.repository.VolunteerAvailabilityRepository;
import com.neilist.mrs.util.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MeetingsController extends BaseController {

    @Autowired
    private MeetingRepository meetingRepository;

    @Autowired
    private VolunteerAvailabilityRepository volunteerAvailabilityRepository;

    @GetMapping("/meetings")
    public String meetings() {
        return "meetings";
    }

    @GetMapping("/meetings/host")
    public String host(Model model) {
        model.addAttribute("meeting", new Meeting());
        return "host-meeting";
    }

    @PostMapping("/meetings/host")
    public String hostSave(@ModelAttribute("meeting") Meeting meeting, BindingResult bindingResult) {
        meeting.setHostUserId(getUser().getId());
        meeting.setDayOfWeek(DateTimeUtil.dayOfWeek(meeting.getDateTime()));
        meeting.setMinuteOfDay(DateTimeUtil.minuteOfDay(meeting.getDateTime()));
        meetingRepository.save(meeting);
        return "meetings";
    }

    @GetMapping("/meetings/volunteer")
    public String availability(Model model) {
        model.addAttribute("volunteerAvailability", new VolunteerAvailability());
        return "volunteer-availability";
    }

    @PostMapping("/meetings/volunteer")
    public String availabilitySave(@ModelAttribute("volunteerAvailability") VolunteerAvailability volunteerAvailability, BindingResult bindingResult) {
        volunteerAvailability.setVolunteerUserId(getUser().getId());
        volunteerAvailability.setStartMinute(DateTimeUtil.minuteOfDay(volunteerAvailability.getStartTime()));
        volunteerAvailability.setEndMinute(DateTimeUtil.minuteOfDay(volunteerAvailability.getEndTime()));
        volunteerAvailabilityRepository.save(volunteerAvailability);
        return "meetings";
    }

}
