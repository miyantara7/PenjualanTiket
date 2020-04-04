package com.lawencon.penjualantiket.service;

import java.util.List;
import com.lawencon.penjualantiket.model.Type;

public interface TypeService {
	abstract String insertTypeHiber(Type type, String user, String pass) throws Exception;
	abstract String editTypeHiber(Type type, String user, String pass, int id) throws Exception;
	abstract String deleteTypeHiber(Type type, String user, String pass) throws Exception;
	abstract List<Type> viewTypeHiber(String user, String pass) throws Exception;
	
	abstract String insertTypeJpa(Type type, String user, String pass) throws Exception;
	abstract String editTypeJpa(Type type, String user, String pass, int id) throws Exception;
	abstract String deleteTypeJpa(Type type, String user, String pass) throws Exception;
	abstract List<Type> viewTypeJpa(String user, String pass) throws Exception;
}
