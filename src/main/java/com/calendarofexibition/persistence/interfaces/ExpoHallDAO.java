package com.calendarofexibition.persistence.interfaces;

import com.calendarofexibition.model.ExpoHall;
import java.util.List;

public interface ExpoHallDAO {

    /**
     * Obtain all ExpoHalls from database
     *
     * @return list of Events
     */
    List<ExpoHall> findAllHalls();

    /**
     * @param expoHall updated expoHall
     * @return Boolean
     */
   Boolean updateExpoHall(ExpoHall expoHall);

}

