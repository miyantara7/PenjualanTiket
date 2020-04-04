package com.lawencon.penjualantiket.dao;

import java.util.List;
import com.lawencon.penjualantiket.model.Type;

public interface TypeDao {
	abstract void insertType(Type type) throws Exception;
	abstract void editType(Type type) throws Exception;
	abstract void deleteType(Type type) throws Exception;
	abstract List<Type> viewType() throws Exception;
	abstract Type findById(int id) throws Exception;
	abstract Type findType(Type type) throws Exception;
}
