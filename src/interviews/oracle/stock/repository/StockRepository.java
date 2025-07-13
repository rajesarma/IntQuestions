package interviews.oracle.stock.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StockRepository {
    static List<Map<String, Double>> userData = new ArrayList<>();

    static Map<String, Double> map = new HashMap<>();
    static {
        map.put("MS", 102D);
        map.put("GOOGLE", 102D);
        userData.add(map);
    }

    public Long getLimitValueByStockName(String stockName, Long userId) {
//        userData.stream()
//                .map(e -> e.entrySet())
//                .filter(e -> e.ge)
        return 1L;
    }
}
