import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fabrizio.dinapoli on 28/7/17.
 */
public class InMemoryStockRepository implements StockRepository {
  private HashMap stock;

  @Override
  public Map findAll() {
    stock = new HashMap<>();
    stock.put("A", new ArrayList<Integer>() {{
      add(1);
      add(2);
      add(6);
      add(4);
      add(3);
    }});
    stock.put("B", new ArrayList<Integer>() {{
      add(1);
      add(5);
      add(6);
      add(1);
      add(3);
    }});
    stock.put("C", new ArrayList<Integer>() {{
      add(2);
      add(5);
      add(3);
      add(4);
      add(3);
    }});
    stock.put("D", new ArrayList<Integer>() {{
      add(3);
      add(5);
      add(6);
      add(4);
      add(3);
    }});
    stock.put("E", new ArrayList<Integer>() {{
      add(4);
      add(5);
      add(3);
      add(4);
      add(3);
    }});
    stock.put("F", new ArrayList<Integer>() {{
      add(1);
      add(5);
      add(6);
      add(4);
      add(3);
    }});
    stock.put("G", new ArrayList<Integer>() {{
      add(5);
      add(5);
      add(3);
      add(4);
      add(2);
    }});
    stock.put("H", new ArrayList<Integer>() {{
      add(1);
      add(5);
      add(6);
      add(4);
      add(3);
    }});

    return stock;
  }
}
