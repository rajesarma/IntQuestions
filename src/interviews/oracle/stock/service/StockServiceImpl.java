package interviews.oracle.stock.service;

import com.test.demo.oracle.stock.model.Order;
import org.springframework.stereotype.Service;

@Service
public class StockServiceImpl implements StockService{

    @Override
    public Order buyWithMarketOption(Order order) {
        return null;
    }

    @Override
    public Order sellWithMarketOption(Order order) {
        return null;
    }

    @Override
    public Order buyWithLimitOption(Order order, String userId) {
        String stockName = order.getStockName();
        // Retrieve Limit Value from User DB by passing stockName

        return null;
    }

    @Override
    public Order sellWithLimitOption(Order order, String userId) {
        return null;
    }
}
