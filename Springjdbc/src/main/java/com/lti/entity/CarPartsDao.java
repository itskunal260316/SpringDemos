package com.lti.entity;

import java.util.List;

import com.lti.dao.CarPart;

public interface CarPartsDao {

	public void addNewPart(CarPart carPart);

	public List<CarPart> getAvailableParts();

}
