package com.revature.vicino.models;

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
    private Date checkin;

    public HotelRequest(Integer locationId) {
        this.locationId = locationId;
    }
}
