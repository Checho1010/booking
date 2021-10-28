package com.boot.bookingrestaurantapi.services;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.boot.bookingrestaurantapi.entities.Reservation;
import com.boot.bookingrestaurantapi.entities.Restaurant;
import com.boot.bookingrestaurantapi.entities.Turn;
import com.boot.bookingrestaurantapi.exceptions.BookingException;
import com.boot.bookingrestaurantapi.jsons.CreateReservationRest;
import com.boot.bookingrestaurantapi.repositories.ReservationRepository;
import com.boot.bookingrestaurantapi.repositories.RestaurantRepository;
import com.boot.bookingrestaurantapi.repositories.TurnRepository;
import com.boot.bookingrestaurantapi.services.impl.ReservationServiceImpl;

public class ReservationServiceTest {

	private static final Date DATE = new Date();
	
	private static final String LOCATOR = "BURGER 3";
	private static final String TURNO = "TURN_12_004";
	
	private static final Long PERSON = 30L;
	private static final Long RESTAURANT_ID = 5L;
	private static final Long RESERVATION_ID = 4L;
	private static final Long TURN_ID = 2L;

	private static final String NAME = "Chilis";
	private static final String DESCRIPTION = "Grandes tacos";
	private static final String ADDRESS = "Cumbayá";
	private static final String IMAGE = "laurl.imagen";
	private static final List<Turn> TURN_LIST = new ArrayList<Turn>();

	CreateReservationRest CREATE_RESERVATION_REST = new CreateReservationRest();
	private static final Restaurant RESTAURANT = new Restaurant();
	private static final Reservation RESERVATION = new Reservation();
	private static final Turn TURN = new Turn();

	private static final Optional<Restaurant> OPTIONAL_RESTAURANT = Optional.of(RESTAURANT);
	private static final Optional<Reservation> OPTIONAL_RESERVATION = Optional.of(RESERVATION);
	private static final Optional<Turn> OPTIONAL_TURN = Optional.of(TURN);
	
	private static final Optional<Restaurant> OPTIONAL_RESTAURANT_EMPTY = Optional.empty();
	private static final Optional<Reservation> OPTIONAL_RESERVATION_EMPTY = Optional.empty();
	private static final Optional<Turn> OPTIONAL_TURN_EMPTY = Optional.empty();

	@Mock
	private RestaurantRepository restaurantRepository;

	@Mock
	private TurnRepository turnRepository;

	@Mock
	private ReservationRepository reservationRepository;

	@InjectMocks
	private ReservationServiceImpl reservationServiceImpl;

	@Before
	public void init() throws BookingException {
		MockitoAnnotations.initMocks(this);

		RESTAURANT.setName(NAME);
		RESTAURANT.setDescription(DESCRIPTION);
		RESTAURANT.setAddress(ADDRESS);
		RESTAURANT.setId(RESTAURANT_ID);
		RESTAURANT.setImage(IMAGE);
		RESTAURANT.setTurns(TURN_LIST);

		TURN.setId(RESTAURANT_ID);
		TURN.setName(NAME);
		TURN.setRestaurant(RESTAURANT);

		CREATE_RESERVATION_REST.setDate(DATE);
		CREATE_RESERVATION_REST.setPerson(PERSON);
		CREATE_RESERVATION_REST.setRestaurantId(RESTAURANT_ID);
		CREATE_RESERVATION_REST.setTurnId(TURN_ID);
		
		RESERVATION.setDate(DATE);
		RESERVATION.setId(RESERVATION_ID);
		RESERVATION.setLocator(LOCATOR);
		RESERVATION.setPerson(PERSON);
		RESERVATION.setRestaurant(RESTAURANT);
		RESERVATION.setTurn(TURNO);
	}

	@Test
	public void CreateReservationTest() throws BookingException {
		Mockito.when(restaurantRepository.findById(RESTAURANT_ID)).thenReturn(OPTIONAL_RESTAURANT);
		Mockito.when(turnRepository.findById(TURN_ID)).thenReturn(OPTIONAL_TURN);
		Mockito.when(reservationRepository.findByTurnAndRestaurantId(TURN.getName(), RESTAURANT.getId()))
				.thenReturn(OPTIONAL_RESERVATION_EMPTY);
		
		Mockito.when(reservationRepository.save(Mockito.any(Reservation.class))).thenReturn(new Reservation());

		reservationServiceImpl.createReservation(CREATE_RESERVATION_REST);
	}
	
	@Test(expected = BookingException.class)
	public void CreateReservationFindByIdTestError() throws BookingException {
		Mockito.when(restaurantRepository.findById(RESTAURANT_ID)).thenReturn(OPTIONAL_RESTAURANT_EMPTY);
		reservationServiceImpl.createReservation(CREATE_RESERVATION_REST);
	fail();
	}
	
	@Test(expected = BookingException.class)
	public void CreateReservationTurnFindByIdTestError() throws BookingException {
		Mockito.when(restaurantRepository.findById(RESTAURANT_ID)).thenReturn(OPTIONAL_RESTAURANT);
		Mockito.when(turnRepository.findById(TURN_ID)).thenReturn(OPTIONAL_TURN_EMPTY);
		reservationServiceImpl.createReservation(CREATE_RESERVATION_REST);
	fail();
	}
	
	@Test(expected = BookingException.class)
	public void CreateReservationTurnAndRestaurantTestError() throws BookingException {
		Mockito.when(restaurantRepository.findById(RESTAURANT_ID)).thenReturn(OPTIONAL_RESTAURANT);
		Mockito.when(turnRepository.findById(TURN_ID)).thenReturn(OPTIONAL_TURN);
		Mockito.when(reservationRepository.findByTurnAndRestaurantId(TURN.getName(), RESTAURANT.getId()))
				.thenReturn(OPTIONAL_RESERVATION);
		

		reservationServiceImpl.createReservation(CREATE_RESERVATION_REST);
	fail();
	}
	
	/*@Test(expected = BookingException.class)
	public void CreateReservationInternalServerErrorTestError() throws BookingException {
		Mockito.when(restaurantRepository.findById(RESTAURANT_ID)).thenReturn(OPTIONAL_RESTAURANT);
		Mockito.when(turnRepository.findById(TURN_ID)).thenReturn(OPTIONAL_TURN);
		Mockito.when(reservationRepository.findByTurnAndRestaurantId(TURN.getName(), RESTAURANT.getId()))
				.thenReturn(OPTIONAL_RESERVATION_EMPTY);
		
		Mockito.doThrow(Exception.class).when(reservationRepository).save(Mockito.any(Reservation.class));
		
		reservationServiceImpl.createReservation(CREATE_RESERVATION_REST);
	fail();
	}*/
}

