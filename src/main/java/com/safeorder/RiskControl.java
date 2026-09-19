package com.safeorder;

public class RiskControl {

    public boolean validate(Order order) {

        if (order == null) {
            return false;
        }

        if (order.getSymbol() == null) {
            return false;
        }

        if (order.getPrice() < 0) {
            return false;
        }

        // Defecto intencional:
        // no se valida que la cantidad sea mayor que cero.
        return true;
    }

    public boolean exceedsLimit(Order order) {

        if (order == null) {
            return true;
        }

        // Defecto intencional:
        // no existe un límite real de cantidad.
        if (order.getQuantity() > 1000000) {
            return true;
        }

        return false;
    }
}
