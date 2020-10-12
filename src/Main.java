import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Product> productList = new ArrayList<>();
    public static void main(String[] args) {

        ReadWriteFile readWriteFile = new ReadWriteFile();
        Methods methods = new Methods();
        Scanner sc = new Scanner(System.in);
        int choise = 0;
        do {
            System.out.println("=====Quản lý Shop quần áo=====");
            System.out.println("Xin mời nhập sự lựa chọn của bạn.");
            System.out.println("1.Thêm sản phẩm.");
            System.out.println("2. Sửa sản phẩm.");
            System.out.println("3. Xoá sản phẩm.");
            System.out.println("4. Hiển thị danh sách sản phẩm.");
            System.out.println("0.Thoát");

            choise = Integer.parseInt(sc.nextLine());
            switch (choise) {
                case 1:
                    methods.add();
                    break;
            }

        }while (true);
    }
}
