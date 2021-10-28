package com.boot.bookingrestaurantapi.services.impl;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.bookingrestaurantapi.entities.Reservation;
import com.boot.bookingrestaurantapi.entities.Restaurant;
import com.boot.bookingrestaurantapi.entities.Turn;
import com.boot.bookingrestaurantapi.exceptions.BookingException;
import com.boot.bookingrestaurantapi.exceptions.InternalServerErrorException;
import com.boot.bookingrestaurantapi.exceptions.NotFoundException;
import com.boot.bookingrestaurantapi.jsons.CreateReservationRest;
import com.boot.bookingrestaurantapi.jsons.ReservationRest;
import com.boot.bookingrestaurantapi.repositories.ReservationRepository;
import com.boot.bookingrestaurantapi.repositories.RestaurantRepository;
import com.boot.bookingrestaurantapi.repositories.TurnRepository;
import com.boot.bookingrestaurantapi.services.EmailService;
import com.boot.bookingrestaurantapi.services.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);
	
	@Autowired
	ReservationRepository reservationRepository;

	@Autowired
	RestaurantRepository restaurantRepository;
	
	@Autowired
	TurnRepository turnRepository;
	
	@Autowired
	private EmailService emailService;

	public static final ModelMapper modelMapper = new ModelMapper();

	@Override
	public ReservationRest getReservationById(Long reservationId) throws BookingException {
		return modelMapper.map(getReservationEntity(reservationId), ReservationRest.class);
	}

	private Reservation getReservationEntity(Long reservationId) throws BookingException {
		return reservationRepository.findById(reservationId)
				.orElseThrow(() -> new NotFoundException("SNOT-404-2", "RESERVATION_NOT_FOUND"));
	}

	@Override
	public String createReservation(CreateReservationRest createReservationRest) throws BookingException {

		final Restaurant restaurantId = restaurantRepository.findById(createReservationRest.getRestaurantId())
				.orElseThrow(() -> new NotFoundException("RESTAURANT_NOT_FOUND", "RESTAURANT_NOT_FOUND"));

		String locator = generateLocator(restaurantId, createReservationRest);
		
		
		final Turn turn = turnRepository.findById(createReservationRest.getTurnId())
				.orElseThrow(() -> new NotFoundException("TURN_NOT_FOUND", "TURN_NOT_FOUND"));
		
		if(reservationRepository.findByTurnAndRestaurantId(turn.getName(), restaurantId.getId()).isPresent()) {
			throw new NotFoundException("RESERVATION_ALREADY_EXIST", "RESERVATION_ALREADY_EXIST");
		}
		
		//String turn = generateTurn(turnId, createReservationRest);

		final Reservation reservation = new Reservation();
		reservation.setLocator(locator);
		reservation.setPerson(createReservationRest.getPerson());
		reservation.setDate(createReservationRest.getDate());
		reservation.setRestaurant(restaurantId);
		reservation.setTurn(turn.getName());
		reservation.setName(createReservationRest.getName());
		reservation.setEmail(createReservationRest.getEmail());
		
		try {
			reservationRepository.save(reservation);
		} catch (final Exception e) {
			LOGGER.error("INTERNAL_SERVER_ERROR", e);
			throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
		}
		
		//this.emailService.processSendEmail(createReservationRest.getEmail(), "RESERVATION", createReservationRest.getName());

		return locator;
	}

	public void updateReservation(final Boolean payment, String locator) throws BookingException{
		final Reservation reservation = reservationRepository.findByLocator(locator)
				.orElseThrow(() -> new NotFoundException("CODE_LOCATOR_NOT_FOUND", "LOCATOR_NOT_FOUND"));
		reservation.setPayment(true);
		try {
			reservationRepository.save(reservation);
		} catch (final Exception e) {
			LOGGER.error("INTERNAL_SERVER_ERROR", e);
			throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
		}
	}
	
	private String generateLocator(Restaurant restaurantId, CreateReservationRest createReservationRest)
			throws BookingException {
		return restaurantId.getName() + createReservationRest.getTurnId();
	}
	
	/*private String generateTurn(Turn turnId, CreateReservationRest createReservationRest)
			throws BookingException {
		return turnId.getName() + createReservationRest.getTurnId();
	}*/

}
