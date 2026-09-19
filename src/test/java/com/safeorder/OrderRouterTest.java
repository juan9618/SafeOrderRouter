package com.safeorder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class OrderRouterTest {

    @Test
    void shouldSendNormalOrder() {
        OrderRouter router = new OrderRouter();

        Order order = new Order("ABC", 100, 10);

        assertEquals("SENT", router.route(order));
    }

    @Test
    void shouldRejectNullOrder() {
        OrderRouter router = new OrderRouter();

        assertEquals("ERROR", router.route(null));
    }

    @Test
    void shouldReviewHighValueOrder() {
        OrderRouter router = new OrderRouter();

        Order order = new Order("XYZ", 6000, 10);

        assertEquals("MANUAL_REVIEW", router.route(order));
    }
}
