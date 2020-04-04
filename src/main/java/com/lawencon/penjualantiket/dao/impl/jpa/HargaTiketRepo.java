package com.lawencon.penjualantiket.dao.impl.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lawencon.penjualantiket.model.HargaTiket;

@Repository
public interface HargaTiketRepo extends JpaRepository<HargaTiket, Integer>{

}
