package ru.netology.sender;

import program_testing_Mockito.task1.ru.netology.entity.Country;
import program_testing_Mockito.task1.ru.netology.entity.Location;
import program_testing_Mockito.task1.ru.netology.geo.GeoService;
import program_testing_Mockito.task1.ru.netology.i18n.LocalizationService;
import program_testing_Mockito.task1.ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MessageSenderImplTest {
	
	LocalizationService localizationService = mock(LocalizationService.class);
	GeoService geoService = mock(GeoService.class);
	
	MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);
	
	@Test
	void testSend_messageRussian() {
		
		Location location = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
		when(geoService.byIp("172.0.32.11")).thenReturn(location);
		when(localizationService.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");
		
		Map<String, String> headers = new HashMap<>();
		headers.put("x-real-ip", "172.0.32.11");
		
		String result = messageSender.send(headers);
		assertEquals("Добро пожаловать", result);
	}
	
	@Test
	void testSend_messageEnglish() {
		
		Location location = new Location("New York", Country.USA, "10th Avenue", 32);
		when(geoService.byIp("96.44.183.149")).thenReturn(location);
		when(localizationService.locale(Country.USA)).thenReturn("Welcome");
		
		Map<String, String> headers = new HashMap<>();
		headers.put("x-real-ip", "96.44.183.149");
		
		String result = messageSender.send(headers);
		assertEquals("Welcome", result);
	}
	
	@Test
	void testSend_messageDefault() {
		
		when(localizationService.locale(Country.USA)).thenReturn("Welcome");
		
		Map<String, String> headers = new HashMap<>();
		headers.put("x-real-ip", "");
		
		String result = messageSender.send(headers);
		assertEquals("Welcome", result);
	}
	
}
