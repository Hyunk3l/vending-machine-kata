import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class VendingMachineShould {

    private static final String VALID_PRODUCT_CODE = "A1";
    private static final String INVALID_PRODUCT_CODE = "I1";
    private static final double VALID_PRODUCT_PRICE = 2.8;
    private static final int NO_PRICE = 0;
    private static final String VALID_PRODUCT_NAME = "Yellow Monster";

    private VendingMachine vendingMachine;

    @Before
    public void setUp() {
        vendingMachine = new VendingMachine(
            new InMemoryProductRepository(),
            new InMemoryStockRepository(),
            new InMemoryPriceRepository()
        );
    }

    @Test
    public void return_price_for_product() {
        assertThat(vendingMachine.price(VALID_PRODUCT_CODE)).isEqualTo(VALID_PRODUCT_PRICE);
    }

    @Test
    public void buy_product_with_exact_price() {
        assertThat(vendingMachine.sellProduct(VALID_PRODUCT_PRICE, VALID_PRODUCT_CODE)).isEqualTo(VALID_PRODUCT_NAME);
    }

    @Test
    public void return_no_price_for_invalid_product() {
        assertThat(vendingMachine.price(INVALID_PRODUCT_CODE)).isEqualTo(NO_PRICE);
    }

    @Test
    public void return_change_for_product() {
        double insertedPrice = 5;
        double expectedChange = insertedPrice - VALID_PRODUCT_PRICE;
        assertThat(vendingMachine.returnChange(insertedPrice, VALID_PRODUCT_CODE)).isEqualTo(expectedChange);
    }

    @Test
    public void return_no_change_for_exact_product_price() {
        assertThat(vendingMachine.returnChange(VALID_PRODUCT_PRICE, VALID_PRODUCT_CODE)).isEqualTo(NO_PRICE);
    }

    @Test
    public void return_no_change_for_non_valid_product() {
        assertThat(vendingMachine.returnChange(VALID_PRODUCT_PRICE, INVALID_PRODUCT_CODE)).isEqualTo(NO_PRICE);
    }

    @Test
    public void return_product_name() {
        assertThat(vendingMachine.sellProduct(5, VALID_PRODUCT_CODE)).isEqualTo(VALID_PRODUCT_NAME);
    }

    @Test
    public void return_error_upon_invalid_product_code() {
        assertThat(vendingMachine.sellProduct(5, INVALID_PRODUCT_CODE)).isEqualTo("Does not exists that code");
    }

    @Test
    public void return_error_upon_not_enough_money() {
        assertThat(vendingMachine.sellProduct(1, VALID_PRODUCT_CODE)).isEqualTo("Put more money!");
    }

    @Test
    public void return_error_when_trying_to_buy_out_of_stock_product() {
        vendingMachine.sellProduct(5, VALID_PRODUCT_CODE);
        vendingMachine.sellProduct(5, VALID_PRODUCT_CODE);

        assertThat(vendingMachine.sellProduct(5, VALID_PRODUCT_CODE)).isEqualTo("There are no products for code");
    }
}