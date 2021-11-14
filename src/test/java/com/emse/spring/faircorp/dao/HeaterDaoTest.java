package com.emse.spring.faircorp.dao;


import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.HeaterStatus;
import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.stream.Collectors;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class HeaterDaoTest {
    @Autowired
    private HeaterDao heaterDao;
    @Autowired
    private RoomDao roomDao;
    @Test
    public void shouldFindAHeater() {
       Heater heater = heaterDao.getById(-10L);
       Assertions.assertThat(heater.getName()).isEqualTo("Heater1");
       Assertions.assertThat(heater.getHeaterStatus()).isEqualTo(HeaterStatus.ON);
    }

    @Test
    public void shouldNotFindHeatersInRoom(){
        List<Heater> result = heaterDao.deleteAllHeatersInRoom(-10L);
        Assertions.assertThat(result).isEmpty();
    }
    @Test
    public void shouldDeleteHeatersRoom() {
        Room room = roomDao.getById(-10L);
        List<Long> roomIds = room.getWindows().stream().map(Window::getId).collect(Collectors.toList());
        Assertions.assertThat(roomIds.size()).isEqualTo(2);

        heaterDao.deleteAllHeatersInRoom(-10L);
        List<Heater> result = heaterDao.findAllById(roomIds);
        Assertions.assertThat(result).isEmpty();

    }
}
