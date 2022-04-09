package com.personal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.personal.dto.CabBookingDTO;
import com.personal.dto.FareEstimationDTO;
import com.personal.entity.CabBooking;
import com.personal.entity.FareEstimation;
import com.personal.exception.CabException;
import com.personal.repository.BookingRepository;
import com.personal.repository.FareRepository;

@Service("bookingService")
@Transactional
public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingRepository bookingRepository;
	
	@Autowired
	FareRepository fareRepository;

	@Override
	public Integer bookCab(CabBookingDTO bookingDTO) throws CabException {
		Float fare = fareRepository.findFareBySourceAndDestination(bookingDTO.getSource(), bookingDTO.getDestination());
		if (fare == null) {
			throw new CabException("BookingService.AREA_INVALID");
		}
		bookingDTO.setFare(fare);
		bookingDTO.setStatus('B');
		CabBooking cabBooking = new CabBooking();
		cabBooking.setDestination(bookingDTO.getDestination());
		cabBooking.setSource(bookingDTO.getSource());
		cabBooking.setFare(bookingDTO.getFare());
		cabBooking.setTravelDate(bookingDTO.getTravelDate());
		cabBooking.setUserMobile(bookingDTO.getUserMobile());
		cabBooking.setStatus(bookingDTO.getStatus());
		return bookingRepository.save(cabBooking).getBookingId();
	}

	@Override
	public List<CabBookingDTO> getBookingDetails(Long mobileNo) throws CabException {
		List<CabBookingDTO> cabBookingDTOs = new ArrayList<>();
		List<CabBooking> cabBookings = bookingRepository.findByUserMobile(mobileNo);
		if (cabBookings.isEmpty())
			throw new CabException("BookingService.BOOKINGS_NOT_FOUND");
		cabBookings.forEach( cabBooking -> {
			CabBookingDTO cabBookingDTO = new CabBookingDTO();
			cabBookingDTO.setBookingId(cabBooking.getBookingId());
			cabBookingDTO.setDestination(cabBooking.getDestination());
			cabBookingDTO.setSource(cabBooking.getSource());
			cabBookingDTO.setFare(cabBooking.getFare());
			cabBookingDTO.setStatus(cabBooking.getStatus());
			cabBookingDTO.setTravelDate(cabBooking.getTravelDate());
			cabBookingDTO.setUserMobile(cabBooking.getUserMobile());
			cabBookingDTOs.add(cabBookingDTO);
		});
		
		return cabBookingDTOs;
	}

	@Override
	public Integer cancelBooking(Integer bookingId) throws CabException {
		Optional<CabBooking> optional = bookingRepository.findById(bookingId);
		if(!optional.isPresent()) {
			throw new CabException("BookingService.BOOKINGS_NOT_FOUND");
		}
		else {
			bookingRepository.deleteById(optional.get().getBookingId());
			return optional.get().getBookingId();
		}
		
	}

	@Override
	public List<FareEstimationDTO> getFares() throws CabException {
		List<FareEstimationDTO> fareEstimationDTOs = new ArrayList<>();
		List<FareEstimation> fares = fareRepository.findFares();
		if (fares.isEmpty())
			throw new CabException("BookingService.FARES_NOT_FOUND");
		fares.forEach( fare -> {
			FareEstimationDTO fareEstimationDTO = new FareEstimationDTO();
			fareEstimationDTO.setFareId(fare.getFareId());
			fareEstimationDTO.setSource(fare.getSource());
			fareEstimationDTO.setDestination(fare.getDestination());
			fareEstimationDTO.setFare(fare.getFare());
			fareEstimationDTOs.add(fareEstimationDTO);
		});
		
		return fareEstimationDTOs;
	}
	@Override
	public Integer updateRide(Integer bookingId,CabBookingDTO cabBookingDTO) throws CabException {
		Optional<CabBooking> optional = bookingRepository.findById(bookingId);
		if(!optional.isPresent()) {
			throw new CabException("BookingService.BOOKINGS_NOT_FOUND");
		}
		else {
			CabBooking cabBooking= optional.get();
			cabBooking.setSource(cabBookingDTO.getSource());
			cabBooking.setDestination(cabBookingDTO.getDestination());
			Float fare = fareRepository.findFareBySourceAndDestination(cabBookingDTO.getSource(), cabBookingDTO.getDestination());
			if (fare == null) {
				throw new CabException("BookingService.AREA_INVALID");
			}
			cabBooking.setFare(fare);
			cabBooking.setTravelDate(cabBookingDTO.getTravelDate());
			return bookingRepository.save(cabBooking).getBookingId();
		}
	}
}
