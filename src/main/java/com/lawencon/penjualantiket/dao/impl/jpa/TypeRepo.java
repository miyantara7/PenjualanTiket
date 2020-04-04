package com.lawencon.penjualantiket.dao.impl.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lawencon.penjualantiket.model.Type;

@Repository
public interface TypeRepo extends JpaRepository<Type, Integer> {
	@Query("from Type where kodeType = :kodeParam")
	abstract Type findByKodeType(@Param("kodeParam") String kode) throws Exception;
}
