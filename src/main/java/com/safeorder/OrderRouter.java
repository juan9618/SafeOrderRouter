package com.safeorder;

public class OrderRouter {

    private final RiskControl riskControl;

    public OrderRouter() {
        this.riskControl = new RiskControl();
    }

    public String route(Order order) {

        if (order == null) {
            return "ERROR";
        }

        if (!riskControl.validate(order)) {
            return "REJECTED";
        }

        if (riskControl.exceedsLimit(order)) {
            return "REJECTED";
        }

        // Código deliberadamente repetido
        if (order.getSymbol().equals("ABC")) {
            System.out.println("Checking market for ABC");
            System.out.println("Preparing order for ABC");
        }

        if (order.getSymbol().equals("XYZ")) {
            System.out.println("Checking market for XYZ");
            System.out.println("Preparing order for XYZ");
        }

        if (order.getPrice() > 10000) {
            System.out.println("High value order");

            if (order.getQuantity() > 500) {
                System.out.println("Large high value order");
                return "REJECTED";
            } else {
                return "MANUAL_REVIEW";
            }

        } else if (order.getPrice() > 5000) {
            return "MANUAL_REVIEW";

        } else {
            return "SENT";
        }
    }
}
