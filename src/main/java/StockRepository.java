import java.util.ArrayList;
import java.util.Map;

public interface StockRepository {

  Map<String, ArrayList<Integer>> findAll();
}
