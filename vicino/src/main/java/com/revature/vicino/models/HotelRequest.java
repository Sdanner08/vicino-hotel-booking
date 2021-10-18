package com.revature.vicino.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sun.util.calendar.BaseCalendar;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelRequest {
    private Integer locationId;
    private Double latitude;
    private Double longitude;
    private Integer adults;
    private Integer numOfRooms;
    private Integer numOfNights;
    private Integer checkinYear;
    private Integer checkinMonth;
    private Integer checkinDay;

    public HotelRequest(Integer locationId) {
        this.locationId = locationId;
    }
}
