package com.revature.vicino.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelRequest {
    private Integer locationId;
    private Integer adults;
    private Integer numOfRooms;
    private Integer numOfNights;
}
