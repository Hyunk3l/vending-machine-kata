import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InMemoryPriceRepository implements PriceRepository {

  private HashMap prices;

  @Override
  public Map<String, ArrayList<Double>> findAll() {

    prices = new HashMap<>();
    prices.put("A", new ArrayList<Double>() {{
      add(2.80);
      add(2.80);
      add(2.90);
      add(3.0);
      add(3.0);
    }});
    prices.put("B", new ArrayList<Double>() {{
      add(2.90);
      add(2.80);
      add(2.90);
      add(2.90);
      add(3.0);
    }});
    prices.put("C", new ArrayList<Double>() {{
      add(2.80);
      add(2.80);
      add(3.00);
      add(2.80);
      add(3.0);
    }});
    prices.put("D", new ArrayList<Double>() {{
      add(2.50);
      add(2.50);
      add(2.50);
      add(2.50);
      add(2.60);
    }});
    prices.put("E", new ArrayList<Double>() {{
      add(3.50);
      add(3.50);
      add(3.50);
      add(3.50);
      add(3.50);
    }});
    prices.put("F", new ArrayList<Double>() {{
      add(3.0);
      add(3.0);
      add(3.0);
      add(3.0);
      add(3.0);
    }});
    prices.put("G", new ArrayList<Double>() {{
      add(3.0);
      add(3.0);
      add(3.0);
      add(3.0);
      add(3.0);
    }});
    prices.put("H", new ArrayList<Double>() {{
      add(3.0);
      add(3.0);
      add(3.0);
      add(3.0);
      add(3.0);
    }});

    return prices;
  }
}
