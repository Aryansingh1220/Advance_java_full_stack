package weeklyCaseStudy1;

import javax.persistence.*;

@Entity
public class PurchaseOrder {

    @Id
    private long id;

    private String orderDate;
    private double totalAmount;

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getOrderDate() { return orderDate; }
    public void setOrderDate(String orderDate) { this.orderDate = orderDate; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
}
