package com.boot.bookingrestaurantapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.boot.bookingrestaurantapi.exceptions.BookingException;
import com.boot.bookingrestaurantapi.jsons.CreateReservationRest;
import com.boot.bookingrestaurantapi.jsons.ReservationRest;
import com.boot.bookingrestaurantapi.responses.BookingResponse;
import com.boot.bookingrestaurantapi.services.ReservationService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, methods = RequestMethod.POST)
@RestController
@RequestMapping(path = "/booking-restaurant" + "/v1/reservation")
public class ReservationController {

	@Autowired
	ReservationService reservationService;

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "createReservation", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public BookingResponse<String> createReservation(@RequestBody CreateReservationRest createReservationRest)
			throws BookingException {
		return new BookingResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
				reservationService.createReservation(createReservationRest));
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "{" + "reservationId" + "}"
			, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public BookingResponse<ReservationRest> getReservationById(@PathVariable Long reservationId)
			throws BookingException {
		return new BookingResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
				reservationService.getReservationById(reservationId));
	}

}
