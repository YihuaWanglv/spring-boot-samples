package com.iyihua.remote.base;

import java.util.List;

import com.iyihua.model.base.LocationDTO;

public interface LocationRemote {

	public List<LocationDTO> findLoationByUserId(Long userId);
	
	public LocationDTO saveLocation(LocationDTO location);
	
	public void deleteLoation(Long locationId);
}
