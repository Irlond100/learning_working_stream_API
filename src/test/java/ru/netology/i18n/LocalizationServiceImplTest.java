package ru.netology.i18n;

import program_testing_Mockito.task1.ru.netology.entity.Country;
import program_testing_Mockito.task1.ru.netology.i18n.LocalizationServiceImpl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LocalizationServiceImplTest {
	
	LocalizationServiceImpl localizationService = new LocalizationServiceImpl();
	
	@Test
	public void testLocaleRussia() {
		String result = localizationService.locale(Country.RUSSIA);
		assertEquals("Добро пожаловать", result);
	}
	
	@Test
	public void testLocaleUSA() {
		String result = localizationService.locale(Country.USA);
		assertEquals("Welcome", result);
	}
}
