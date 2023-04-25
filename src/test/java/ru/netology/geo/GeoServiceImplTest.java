package ru.netology.geo;

import program_testing_Mockito.task1.ru.netology.entity.Country;
import program_testing_Mockito.task1.ru.netology.entity.Location;
import program_testing_Mockito.task1.ru.netology.geo.GeoServiceImpl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static program_testing_Mockito.task1.ru.netology.geo.GeoServiceImpl.LOCALHOST;
import static program_testing_Mockito.task1.ru.netology.geo.GeoServiceImpl.MOSCOW_IP;
import static program_testing_Mockito.task1.ru.netology.geo.GeoServiceImpl.NEW_YORK_IP;

class GeoServiceImplTest {
	
	GeoServiceImpl service = new GeoServiceImpl();
	
	@Test
	void byIpTest1() {
		Location actual = service.byIp(LOCALHOST);
		
		assertNull(actual.getCountry());
		assertNull(actual.getCity());
		assertNull(actual.getStreet());
		assertEquals(actual.getBuiling(), 0);
	}
	
	@Test
	void byIpTest2() {
		Location result = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
		Location actual = service.byIp(MOSCOW_IP);
		
		assertEquals(actual.getCountry(),result.getCountry());
		assertEquals(actual.getCity(),result.getCity());
		assertEquals(actual.getStreet(),result.getStreet());
		assertEquals(actual.getBuiling(),result.getBuiling());
	}
	@Test
	void byIpTest3() {
		Location result = new Location("New York", Country.USA, " 10th Avenue", 32);
		Location actual = service.byIp(NEW_YORK_IP);
		
		assertEquals(actual.getCountry(),result.getCountry());
		assertEquals(actual.getCity(),result.getCity());
		assertEquals(actual.getStreet(),result.getStreet());
		assertEquals(actual.getBuiling(),result.getBuiling());
	}
	
	
}
