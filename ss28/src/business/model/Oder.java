package business.model;

import java.time.LocalDate;

public class Oder {
    private int idOder;
    private String customerName;
    private LocalDate orderDate;

    public Oder() {
    }

    public Oder(String customerName, int idOder, LocalDate orderDate) {
        this.customerName = customerName;
        this.idOder = idOder;
        this.orderDate = orderDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getIdOder() {
        return idOder;
    }

    public void setIdOder(int idOder) {
        this.idOder = idOder;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Oder{" +
                "customerName='" + customerName + '\'' +
                ", idOder=" + idOder +
                ", orderDate=" + orderDate +
                '}';
    }
}
