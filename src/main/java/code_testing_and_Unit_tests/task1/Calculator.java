package code_testing_and_Unit_tests.task1;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Calculator {
	
	static Supplier<Calculator> instance = Calculator::new;
	
	public BinaryOperator<Integer> plus = (x, y) -> x + y;
	public BinaryOperator<Integer> minus = (x, y) -> x - y;
	public BinaryOperator<Integer> multiply = (x, y) -> x * y;
	public BinaryOperator<Integer> devide = (x, y) -> {
		if (y != 0) {
			return x / y;
		} else {
			throw new ArithmeticException("Ошибка! На 0 делить нельзя.");
		}
	};
	
	UnaryOperator<Integer> pow = x -> x * x;
	UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;
	
	Predicate<Integer> isPositive = x -> x > 0;
	
	Consumer<Integer> println = System.out::println;
	
}
