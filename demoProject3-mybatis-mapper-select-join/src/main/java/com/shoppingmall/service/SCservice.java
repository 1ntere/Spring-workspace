package com.shoppingmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingmall.dto.SC;
import com.shoppingmall.mapper.SCMapper;

@Service
public class SCservice {
	@Autowired
	private SCMapper scmapper;
	
	public List<SC> getAllSC() {
		return scmapper.getAllSC();
	}
	
	//getSnackById
	public SC getSnackById(int snack_id) {
		return scmapper.getSnackById(snack_id);
	}
	
	public SC getCompanyById(int company_id) {
		return scmapper.getCompanyById(company_id);
	}
}
