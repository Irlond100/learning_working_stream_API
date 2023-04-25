import code_testing_and_Unit_tests.task1.Calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CalculatorTest {
	
	Calculator calculator = new Calculator();
	
	@Test
	void additionTrue() {
		int res = calculator.plus.apply(2, 3);
		assertEquals(5, res);
	}
	
	@Test
	void multiplicationTrue() {
		double res = calculator.multiply.apply(2, 3);
		assertEquals(6, res);
	}
	
	@Test
	void multiplicationFail() {
		double res = calculator.multiply.apply(2, 3);
		assertNotEquals(2, res);
	}
	
	@Test
	void additionFail() {
		int res = calculator.plus.apply(2, 3);
		assertNotEquals(6, res);
	}
	
	@Test
	void divisionFail() {
		int res = calculator.devide.apply(18, 3);
		assertNotEquals(6, res);
	}
	
}