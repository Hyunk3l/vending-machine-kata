import java.util.ArrayList;
import java.util.Map;

public interface ProductRepository {

  Map<String, ArrayList<String>> findAll();
}
