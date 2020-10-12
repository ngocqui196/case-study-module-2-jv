import java.util.List;
import java.util.Scanner;

public class Methods {
    public static Scanner sc = new Scanner(System.in);
    private List<Product> productList;
    private ReadWriteFile readWriteFile;

    public Methods() {
        readWriteFile = new ReadWriteFile();
        productList = readWriteFile.readFile();
    }

    public boolean checkDuplication(int id) {
        for (Product product: productList) {
            if (id == product.getId()) {
                return true;
            }
        }
        return false;
    }

    public void add() {
        int id;
        do {
            System.out.println("Xin mời nhập id sản phẩm");
            id = Integer.parseInt(sc.nextLine());
        }while (checkDuplication(id));
        String name = inputName();
        long price = inputPrice();
        String manufacturer = inputManufacturer();
        int amount = inputAmount();
        String origin = inputOrigin();
        Product product = new Product(id,name,price,manufacturer,amount,origin);
        productList.add(product);
        readWriteFile.writeFile(productList);
    }

    private int inputID() {
        System.out.println("Enter id: ");
        return Integer.parseInt(sc.nextLine());
    }

    private String inputName() {
        System.out.print("Nhập tên: ");
        return sc.nextLine();
    }

    private long inputPrice() {
        System.out.println("Nhập giá: ");
        return Long.parseLong(sc.nextLine());
    }

    private String inputManufacturer() {
        System.out.print("Nhập tên hãng: ");
        return sc.nextLine();
    }

    private int inputAmount() {
        System.out.println("Nhập số lượng: ");
        return Integer.parseInt(sc.nextLine());
    }

    private String inputOrigin() {
        System.out.println("Nhập xuất xứ: ");
        return sc.nextLine();
    }
}
