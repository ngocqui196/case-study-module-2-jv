import java.util.Collections;
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
        int id = 0;
        do {
            try {
                System.out.print("Xin mời nhập id sản phẩm: ");
                id = Integer.parseInt(sc.nextLine());
            }catch (NumberFormatException e) {
                System.out.println("Sai số, xin mời nhập lại.");
            }
        }while (checkDuplication(id) || id == 0);
        String name = inputName();
        long price = inputPrice();
        String manufacturer = inputManufacturer();
        int amount = inputAmount();
        String origin = inputOrigin();
        Product product = new Product(id,name,price,manufacturer,amount,origin);
        productList.add(product);
        readWriteFile.writeFile(productList);
    }

    // Hiển thị thông tin teo tên
    public void displayProductByName() {
        String name = inputName();
        for (Product product :
                productList) {
            if (name.equals(product.getName())) {
                System.out.println(product.toString());
            }
        }

    }
    // Sửa thông tin sản phẩm
    public void edit() {
        int id = inputID();
        for (Product product :
                productList) {
            if (id == product.getId()) {
                String name = inputName();
                long price = inputPrice();
                String manufaturer = inputManufacturer();
                int amount = inputAmount();
                String origin = inputOrigin();
                product.setName(name);
                product.setPrice(price);
                product.setManufacturer(manufaturer);
                product.setAmount(amount);
                product.setOrigin(origin);
            }
        }
        readWriteFile.writeFile(productList);
    }
    // Xoá sản phẩm theo ID
    public void deleteProduct() {
        int id = inputID();
        productList.removeIf(product -> id == product.getId());
        readWriteFile.writeFile(productList);
    }

    // Hiển thị danh sách sản phẩm
    public void displayList() {
        System.out.printf("%5s | %20s | %15s | %10s | %10s | %10s | ", "ID", "Tên sản phẩm","Tên hãng","Số lượng","Giá cả","Xuất xứ");
        System.out.println("--------------------------------------------------------------------------------------");
        for (Product pro : productList) {
//            System.out.println(pro.toString());
            System.out.printf("%5d | ", pro.getId());
            System.out.printf("%20s | ", pro.getName());
            System.out.printf("%15s | ", pro.getManufacturer());
            System.out.printf("%7d | ", pro.getAmount());
            System.out.printf("%10s | ", pro.getPrice());
            System.out.printf("%10s | ", pro.getOrigin());
            System.out.println();
        }
    }

    // Sắp xếp sản phẩm theo ID
    public void sortProductByID() {
        Collections.sort(productList,new SorstProductByID());
        readWriteFile.writeFile(productList);
    }

    // Sắp xếp sản phẩm theo tên.
    public void sortProductByName() {
        Collections.sort(productList,new SortProductByName());
        readWriteFile.writeFile(productList);
    }

    private int inputID() {
        System.out.print("Nhập ID: ");
        while (true) {
            try {
                int iD = Integer.parseInt(sc.nextLine());
                return iD;
            } catch (NumberFormatException e) {
                System.out.println("Nhập sai kiểu số. Xin mời nhập lại.");
            }
        }
    }

    private String inputName() {
        System.out.print("Nhập tên: ");
        while (true) {
            try{
                String name = sc.nextLine();
                if (name.equals("")) {
                    throw new NoNextLine();
                }
                return name;
            }catch (NoNextLine e) {
                System.out.println("Không được để trống.");
            }
        }

    }

    private long inputPrice() {
        System.out.print("Nhập giá: ");
        while (true) {
            try {
                long price = Long.parseLong(sc.nextLine());
                return price;
            } catch (NumberFormatException e) {
                System.out.println("Nhập sai kiểu số. Xin mời nhập lại.");
            }
        }
    }

    private String inputManufacturer() {
        System.out.print("Nhập tên hãng: ");
        while (true) {
            try{
                String manufacturer = sc.nextLine();
                if (manufacturer.equals("")) {
                    throw new NoNextLine();
                }
                return manufacturer;
            }catch (NoNextLine e) {
                System.out.println("Không được để trống.");
            }
        }
//        return sc.nextLine();
    }

    private int inputAmount() {
        System.out.print("Nhập số lượng: ");
        while (true) {
            try {
                int amount = Integer.parseInt(sc.nextLine());
                return amount;
            } catch (NumberFormatException e) {
                System.out.println("Nhập sai kiểu số. Xin mời nhập lại.");
            }
        }
    }

    private String inputOrigin() {
        System.out.print("Nhập xuất xứ: ");
        while (true) {
            try{
                String origin = sc.nextLine();
                if (origin.equals("")) {
                    throw new NoNextLine();
                }
                return origin;
            }catch (NoNextLine e) {
                System.out.println("Không được để trống.");
            }
        }
//        return sc.nextLine();
    }
}
