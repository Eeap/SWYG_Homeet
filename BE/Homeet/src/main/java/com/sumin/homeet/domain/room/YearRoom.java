package com.sumin.homeet.domain.room;

import com.sumin.homeet.dto.YearRoomDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter @Setter
@DiscriminatorValue("Y")
public class YearRoom extends Room{
    private int YearPrice;
    public void changeYear(YearRoomDto room){
        System.out.println("room Year= " + room);
        this.YearPrice = room.getYearPrice();
        this.setLocation(room.getLocation());
        this.setDuplex(room.isDuplex());

    }
}
