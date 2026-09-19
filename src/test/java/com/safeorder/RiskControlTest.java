package com.safeorder;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class RiskControlTest {

    @Test
    void shouldRejectNullOrder() {
        RiskControl control = new RiskControl();

        assertFalse(control.validate(null));
    }

    @Test
    void shouldRejectNegativePrice() {
        RiskControl control = new RiskControl();

        Order order = new Order("ABC", -10, 10);

        assertFalse(control.validate(order));
    }

    @Test
    void shouldAcceptNormalOrder() {
        RiskControl control = new RiskControl();

        Order order = new Order("ABC", 100, 10);

        assertTrue(control.validate(order));
    }
}
