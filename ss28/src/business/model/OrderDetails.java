package business.model;

public class OrderDetails {
    private int detailId;
    private Oder orderId;
    private String productName;
    private int quantity;

    public OrderDetails() {
    }

    public OrderDetails(int detailId, Oder orderId, String productName, int quantity) {
        this.detailId = detailId;
        this.orderId = orderId;
        this.productName = productName;
        this.quantity = quantity;
    }

    public int getDetailId() {
        return detailId;
    }

    public void setDetailId(int detailId) {
        this.detailId = detailId;
    }

    public Oder getOrderId() {
        return orderId;
    }

    public void setOrderId(Oder orderId) {
        this.orderId = orderId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "detailId=" + detailId +
                ", orderId=" + orderId +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
