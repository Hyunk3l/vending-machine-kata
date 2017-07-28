public class Application {

    public static void main(String[] args) {
        VendingMachine vm = new VendingMachine(new InMemoryProductRepository(), new InMemoryStockRepository(), new InMemoryPriceRepository());

        System.out.println("Price for A1: " + vm.price("A1"));
        System.out.println("Buy for A1: " + vm.sellProduct(5,"A1"));
        System.out.println("Change for A1: " + vm.returnChange(5, "A1"));

        System.out.println("Buy for A1: " + vm.sellProduct(5,"A1"));
        System.out.println("Buy for A1: " + vm.sellProduct(5,"A1"));
        System.out.println("Buy for A1: " + vm.sellProduct(5,"A1"));
    }

}
