package com.boot.bookingrestaurantapi.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.boot.bookingrestaurantapi.entities.Board;
import com.boot.bookingrestaurantapi.entities.Reservation;
import com.boot.bookingrestaurantapi.entities.Restaurant;
import com.boot.bookingrestaurantapi.entities.Turn;
import com.boot.bookingrestaurantapi.exceptions.BookingException;
import com.boot.bookingrestaurantapi.jsons.RestaurantRest;
import com.boot.bookingrestaurantapi.repositories.RestaurantRepository;
import com.boot.bookingrestaurantapi.services.impl.RestaurantServiceImpl;

public class RestaurantServiceTest {

	private static final Long RESTAURANT_ID = 1L;
	private static final String NAME = "CHIFA";
	private static final String DESCRIPTION = "Comida china";
	private static final String ADDRESS = "Versalles y Carrión";
	private static final String IMAGE = "https://i.pinimg.com/originals/b4/25/52/b4255218c9d48caa4b559084665a9e2c.jpg";

	public static final Restaurant RESTAURANT = new Restaurant();
	public static final List<Turn> TURN_LIST = new ArrayList<>();
	public static final List<Board> BOARD_LIST = new ArrayList<>();
	public static final List<Reservation> RESERVATION_LIST = new ArrayList<>();

	@Mock
	RestaurantRepository restaurantRepository;

	@InjectMocks
	RestaurantServiceImpl restaurantServiceImpl;

	@Before
	public void init() throws BookingException {
		MockitoAnnotations.initMocks(this);

		RESTAURANT.setName(NAME);
		RESTAURANT.setDescription(DESCRIPTION);
		RESTAURANT.setAddress(ADDRESS);
		RESTAURANT.setId(RESTAURANT_ID);
		RESTAURANT.setImage(IMAGE);
		RESTAURANT.setTurns(TURN_LIST);
		RESTAURANT.setBoards(BOARD_LIST);
		RESTAURANT.setReservations(RESERVATION_LIST);
	}

	@Test
	public void getRestaurantByIdTest() throws BookingException {
		Mockito.when(restaurantRepository.findById(RESTAURANT_ID)).thenReturn(Optional.of(RESTAURANT));
		restaurantServiceImpl.getRestaurantById(RESTAURANT_ID);
	}

	@Test(expected = BookingException.class)
	public void getRestaurantByIdTestError() throws BookingException {
		Mockito.when(restaurantRepository.findById(RESTAURANT_ID)).thenReturn(Optional.empty());
		restaurantServiceImpl.getRestaurantById(RESTAURANT_ID);
		fail();
	}

	@Test
	public void getRestaurantsTest() throws BookingException {
		final Restaurant restaurant = new Restaurant();
		Mockito.when(restaurantRepository.findAll()).thenReturn(Arrays.asList(restaurant));
		final List<RestaurantRest> response = restaurantServiceImpl.getRestaurants();
		assertNotNull(response);
		assertFalse(response.isEmpty());
		assertEquals(response.size(), 1);
	}
}
