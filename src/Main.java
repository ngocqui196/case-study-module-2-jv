import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void showMenu() {
        System.out.println("=====Quản lý Shop quần áo=====");
        System.out.println("Xin mời nhập sự lựa chọn của bạn.");
        System.out.println("1.Thêm sản phẩm.");
        System.out.println("2. Sửa sản phẩm.");
        System.out.println("3. Xoá sản phẩm.");
        System.out.println("4. Hiển thị danh sách sản phẩm.");
        System.out.println("5. Hiển thị thông tin theo tên.");
        System.out.println("6. Sắp xếp sản phẩm theo ID.");
        System.out.println("7. Sắp xếp sản phẩm theo tên.");
        System.out.println("0.Thoát");
    }
    public static List<Product> productList = new ArrayList<>();
    public static void main(String[] args) {

        ReadWriteFile readWriteFile = new ReadWriteFile();
        Methods methods = new Methods();
        Scanner sc = new Scanner(System.in);
        String choise = "";
        do {
            showMenu();
            choise = sc.nextLine();
            switch (choise) {
                case "1":
                    methods.add();
                    break;
                case "2":
                    methods.edit();
                    break;
                case "3":
                    methods.deleteProduct();
                case "4":
                    methods.displayList();
                    break;
                case "5":
                    methods.displayProductByName();
                    break;
                case "6":
                    methods.sortProductByID();
                    break;
                case "7":
                    methods.sortProductByName();
                    break;
                case "0":
                    System.exit(-1);
                    break;
                default:
                    System.out.println("Không có lựa chọn này dành cho bạn.");
            }

        }while (true);
    }
}
