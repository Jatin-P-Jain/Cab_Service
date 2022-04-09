package com.personal.service;

import java.util.List;

import com.personal.dto.CabBookingDTO;
import com.personal.dto.FareEstimationDTO;
import com.personal.exception.CabException;

public interface BookingService {

		public Integer bookCab(CabBookingDTO booking) throws CabException;
		public List<CabBookingDTO> getBookingDetails(Long mobileNo) throws CabException;
		public Integer cancelBooking(Integer bookingId) throws CabException;
		public List<FareEstimationDTO> getFares() throws CabException;
		public Integer updateRide(Integer bookingId, CabBookingDTO cabBookingDTO) throws CabException;
	
}
