package designpattern.strategy;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

public class DiscounterStrategySample {

	public static void main(String[] args) {
		List<DiscounterStrategy> discountList = Arrays.asList(new ChristmasDiscounter(), new NewYearDiscounter());
		DiscounterStrategy combinedDiscounter = discountList.stream().reduce(v -> v, DiscounterStrategy::combine);
		BigDecimal totalDsicount = combinedDiscounter.applyDiscount(BigDecimal.valueOf(100.0));
		System.out.println(totalDsicount);

	} 

}

/**
 * It is defining the strategy and contract of discount.
 * 
 * @author prashant.srivastava
 */
interface DiscounterStrategy {
	BigDecimal applyDiscount(BigDecimal amount);
	/**
	 * Apply chaining of discounts on total amount.
	 * @param nextDescount
	 * @return DiscounterStrategy final discounted object.
	 */
	default DiscounterStrategy combine(DiscounterStrategy nextDescount) {
		return value -> nextDescount.applyDiscount(this.applyDiscount(value));
	}
}

class ChristmasDiscounter implements DiscounterStrategy {
	@Override
	public BigDecimal applyDiscount(BigDecimal amount) {
		return amount.multiply(BigDecimal.valueOf(0.9));
	}

}

class NewYearDiscounter implements DiscounterStrategy {
	@Override
	public BigDecimal applyDiscount(BigDecimal amount) {
		return amount.multiply(BigDecimal.valueOf(0.3));
	}
}