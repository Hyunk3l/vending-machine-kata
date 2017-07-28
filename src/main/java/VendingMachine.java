import java.util.ArrayList;
import java.util.Map;

public class VendingMachine {

    private final ProductRepository productRepository;
    private final StockRepository stockRepository;
    private final PriceRepository priceRepository;
    private Map<String, ArrayList<String>> products;
    private Map<String, ArrayList<Integer>> stock;
    private Map<String, ArrayList<Double>> prices;


    public VendingMachine(ProductRepository productRepository, StockRepository stockRepository, PriceRepository priceRepository) {
        this.productRepository = productRepository;
        this.stockRepository = stockRepository;
        this.priceRepository = priceRepository;

        products = this.productRepository.findAll();
        stock = this.stockRepository.findAll();
        prices = this.priceRepository.findAll();
    }

    public String sellProduct(double money, String code) {
        Slot slot = new Slot(code);
        String row = slot.getRow();
        Integer column = slot.getColumn();

        if (!prices.containsKey(row)) {
            return "Does not exists that code";
        }

        double value = prices.get(row).get(column);
        if (value > money) {
            return "Put more money!";
        }

        int lf = stock.get(row).get(column);
        if (lf <= 0) {
            return "There are no products for code";
        }

        Integer a = stock.get(row).get(column);
        stock.get(row).set(column, a - 1);

        return products.get(row).get(column);
    }

    public double returnChange(double money, String code) {
        Slot slot = new Slot(code);
        String row = slot.getRow();
        Integer column = slot.getColumn();

        if (prices.containsKey(row)) {
            double value = prices.get(row).get(column);
            return money - value;
        } else {
            return 0;
        }
    }

    public double price(String code) {
        Slot slot = new Slot(code);
        String row = slot.getRow();
        Integer column = slot.getColumn();

        if (prices.containsKey(row)) {
            return prices.get(row).get(column);
        } else {
            return 0;
        }
    }
}
