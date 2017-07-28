import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InMemoryProductRepository implements ProductRepository {

  @Override
  public Map<String, ArrayList<String>> findAll() {
    Map products = new HashMap<>();
    products.put("A", new ArrayList<String>() {{
      add("Yellow Monster");
      add("Yellow Monster");
      add("Black Monster");
      add("White Monster");
      add("White Monster");
    }});
    products.put("B", new ArrayList<String>() {{
      add("Blue Monster");
      add("Yellow Monster");
      add("Black Monster");
      add("Black Monster");
      add("White Monster");
    }});
    products.put("C", new ArrayList<String>() {{
      add("Yellow Monster");
      add("Blue Monster");
      add("Blue Monster");
      add("Yellow Monster");
      add("White Monster");
    }});
    products.put("D", new ArrayList<String>() {{
      add("Rock Star");
      add("Rock Star");
      add("Rock Star");
      add("Rock Star");
      add("Rock Star");
    }});
    products.put("E", new ArrayList<String>() {{
      add("Red Bull");
      add("Red Bull");
      add("Black Monster");
      add("Red Bull");
      add("Red Bull");
    }});
    products.put("F", new ArrayList<String>() {{
      add("Black Burn");
      add("Black Burn");
      add("Blue Burn");
      add("Blue Burn");
      add("Blue Burn");
    }});
    products.put("G", new ArrayList<String>() {{
      add("Red Burn");
      add("Red Burn");
      add("Red Burn");
      add("Blue Burn");
      add("Blue Burn");
    }});
    products.put("H", new ArrayList<String>() {{
      add("Yellow Burn");
      add("Yellow Burn");
      add("Yellow Burn");
      add("Blue Burn");
      add("Blue Burn");
    }});

    return products;
  }
}
