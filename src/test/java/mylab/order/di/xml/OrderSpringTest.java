package mylab.order.di.xml;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:mylab-order-di.xml")
public class OrderSpringTest {
	@Autowired
	ShoppingCart shoppingcart;
	@Autowired
	OrderService orderService;

	@Test
	void orderTest() {
		System.out.println(shoppingcart);
		assertEquals(9500, shoppingcart.getTotalPrice());
		System.out.println(orderService);
	}
}
