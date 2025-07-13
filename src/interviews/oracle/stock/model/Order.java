package interviews.oracle.stock.model;

import java.io.Serializable;
import java.time.LocalDate;


public class Order implements Serializable {
    private Long userId;
    private String stockName;
    private Long quantity;
    private Double buyingValue;
    private Double sellingValue;
    private LocalDate buyingDate;
    private LocalDate sellingDate;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Double getBuyingValue() {
        return buyingValue;
    }

    public void setBuyingValue(Double buyingValue) {
        this.buyingValue = buyingValue;
    }

    public Double getSellingValue() {
        return sellingValue;
    }

    public void setSellingValue(Double sellingValue) {
        this.sellingValue = sellingValue;
    }

    public LocalDate getBuyingDate() {
        return buyingDate;
    }

    public void setBuyingDate(LocalDate buyingDate) {
        this.buyingDate = buyingDate;
    }

    public LocalDate getSellingDate() {
        return sellingDate;
    }

    public void setSellingDate(LocalDate sellingDate) {
        this.sellingDate = sellingDate;
    }
}
