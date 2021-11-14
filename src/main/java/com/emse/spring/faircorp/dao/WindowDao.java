package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Window;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface WindowDao extends JpaRepository<Window, Long>, WindowDaoCustom {
    @Modifying
    @Query
            ("delete from Window w where w.room.id = (select r.id from w.room r where r.building.id = :id)")
    void deleteAllWindowsInBuilding(Long id);

}