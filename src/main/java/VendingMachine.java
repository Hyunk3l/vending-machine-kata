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
        String column = slot.getColumn();

        if (!prices.containsKey(row)) {
            return "Does not exists that code";
        }

        double value = prices.get(row).get(Integer.valueOf(column));
        if (value <= money) {
            int lf = stock.get(row).get(Integer.valueOf(column));
            if (lf > 0) {
                Integer a = stock.get(row).get(Integer.valueOf(column));
                stock.get(row).set(Integer.valueOf(column), a - 1);

                return products.get(row).get(Integer.valueOf(column));
            } else {
                return "There are no products for code";
            }
        } else {
            return "Put more money!";
        }
    }

    public double returnChange(double money, String code) {
        Slot slot = new Slot(code);
        String row = slot.getRow();
        String column = slot.getColumn();

        if (prices.containsKey(row)) {
            double value = prices.get(row).get(Integer.valueOf(column));
            return money - value;
        } else {
            return 0;
        }
    }

    public double price(String code) {
        Slot slot = new Slot(code);
        String row = slot.getRow();
        String column = slot.getColumn();

        if (prices.containsKey(row)) {
            return prices.get(row).get(Integer.valueOf(column));
        } else {
            return 0;
        }
    }

    private class Slot {
        private String row;
        private String column;

        public Slot(String code) {
            row = "NONE";
            column = "NONE";
            for (int i = 0; i < code.length(); i++) {
                if (i == 0) {
                    row = String.valueOf(code.charAt(i));
                } else {
                    column = String.valueOf(code.charAt(i));
                }
            }
        }

        public String getRow() {
            return row;
        }

        public String getColumn() {
            return column;
        }
    }
}
