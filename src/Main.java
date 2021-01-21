import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

public class Main implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        PhoneManager phoneManager = new PhoneManager();
        int index = 0;
        do {
            System.out.println("--chương trình quản lý danh bạ-- ");
            System.out.println("chọn chức năng");
            System.out.println("1 : Thêm mới ");
            System.out.println("2 : Xem danh bạ");
            System.out.println("3 : Cập nhật");
            System.out.println("4 : Tóa ");
            System.out.println("5 : Tìm kiếm");
            System.out.println("6: Đọc từ file");
            System.out.println("7: Ghi vào file");
            System.out.println("8 : exit ");
            try {
                index = Integer.parseInt(sc.nextLine());
                switch (index) {
                    case 1:
                        phoneManager.addPhone();
                        break;
                    case 2:
                        phoneManager.showPhone();
                        break;
                    case 3:
                        phoneManager.editPhone();
                        break;
                    case 4:
                        phoneManager.deletePhone();
                        break;
                    case 5:
                        phoneManager.searchPhone();
                        break;
                    case 6:
                        phoneManager.readContactFromFileCSV();
                    case 7:
                        phoneManager.csvFile();
                }
            } catch (Exception e) {
                System.out.println("Mời nhập lại  ");
            }
        } while (index != 8);
    }

}
