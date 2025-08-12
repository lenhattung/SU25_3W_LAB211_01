
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author tungi
 */
public class Order implements Serializable{

    private String orderId;
    private String customerCode;
    private String menuId;
    private int numberOfTables;
    private Date eventDate;

    public Order() {
    }

    public Order(String orderId, String customerCode, String menuId, int numberOfTables, Date eventDate) {
        this.orderId = orderId;
        this.customerCode = customerCode;
        this.menuId = menuId;
        this.numberOfTables = numberOfTables;
        this.eventDate = eventDate;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public int getNumberOfTables() {
        return numberOfTables;
    }

    public void setNumberOfTables(int numberOfTables) {
        this.numberOfTables = numberOfTables;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    @Override
    public String toString() {
        return "Order{" + "orderId=" + orderId + ", customerCode=" + customerCode + ", menuId=" + menuId + ", numberOfTables=" + numberOfTables + ", eventDate=" + eventDate + '}';
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Order other = (Order) obj;
        if (this.numberOfTables != other.numberOfTables) {
            return false;
        }
        if (!Objects.equals(this.orderId, other.orderId)) {
            return false;
        }
        if (!Objects.equals(this.customerCode, other.customerCode)) {
            return false;
        }
        if (!Objects.equals(this.menuId, other.menuId)) {
            return false;
        }
        return Objects.equals(this.eventDate, other.eventDate);
    }

}
