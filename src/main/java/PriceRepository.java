import java.util.ArrayList;
import java.util.Map;

public interface PriceRepository {

  Map<String, ArrayList<Double>> findAll();
}
