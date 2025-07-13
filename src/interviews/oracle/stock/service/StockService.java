package interviews.oracle.stock.service;

import com.test.demo.oracle.stock.model.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface StockService {
    public Order buyWithMarketOption(Order order);
    public Order sellWithMarketOption(Order order);
    public Order buyWithLimitOption(Order order, String userId);
    public Order sellWithLimitOption(Order order, String userId);

}
