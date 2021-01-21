import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneManager implements Serializable {
    Scanner sc = new Scanner(System.in);

    private final ArrayList<ListPhone> listPhones = new ArrayList<>();

    public ArrayList<ListPhone> getListPhone() {
        return listPhones;
    }

    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    public void csvFile() {
        String fileName = "listPhone.csv";
        writeCsvFile(fileName);
    }

    public void writeCsvFile(String fileName) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileName);
            for (ListPhone listPhone : getListPhone()) {
                fileWriter.append(listPhone.getNumberPhone());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(listPhone.getGroup());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(listPhone.getName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(listPhone.getGender());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(listPhone.getAddress());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(listPhone.getDateOfBirth());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(listPhone.getEmail());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }

            System.out.println("Lưu thành công");

        } catch (Exception e) {
            System.out.println("lỗi");
            e.printStackTrace();
        } finally {
            try {
                assert fileWriter != null;
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("lỗi");
                e.printStackTrace();
            }
        }
    }

    public void readContactFromFileCSV() {
        String line = null;
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("listPhone.csv");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assert fileReader != null;
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        while (true) {
            try {
                if ((line = bufferedReader.readLine()) == null) break;
            } catch (IOException exception) {
                System.out.println(exception);
            }
            assert line != null;
            String[] temp = line.split(COMMA_DELIMITER);
            String numberPhone = temp[0];
            String phoneBook = temp[1];
            String name = temp[2];
            String sex = temp[3];
            String address = temp[4];
            String dateOfBirth = temp[5];
            String email = temp[6];
            getListPhone().add(new ListPhone(name, numberPhone, address, email, dateOfBirth, phoneBook, sex));
        }
        try {
            bufferedReader.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        for (ListPhone p : getListPhone()) {
            System.out.println(p.toString());
        }
    }

    public void addPhone() {
        int a = 0;
        do {
            System.out.println("1: Thêm");
            System.out.println("2: Quay lại");
            try {
                a = Integer.parseInt(sc.nextLine());
                if (a == 1) {
                    ListPhone listPhone = new ListPhone();
                    boolean check = false;
                    do {
                        System.out.println("nhập sdt");
                        String s = "[0-9]{9}";
                        String line = sc.nextLine();
                        Pattern pattern = Pattern.compile(s);
                        Matcher matcher = pattern.matcher(line);
                        if (matcher.find()) {
                            listPhone.setNumberPhone(line);
                            check = true;
                        } else {
                            System.out.println("Bạn đã nhập sai , nhập lại");
                        }
                    } while (!check);

                    System.out.println("nhập nhóm ");
                    String nhom = sc.nextLine();
                    listPhone.setGroup(nhom);
                    System.out.println("nhập tên");
                    String name = sc.nextLine();
                    listPhone.setName(name);
                    System.out.println("Nhập giới tính ");
                    String sex = sc.nextLine();
                    listPhone.setGender(sex);
                    System.out.println("nhập địa chỉ ");
                    String address = sc.nextLine();
                    listPhone.setAddress(address);
                    System.out.println("nhập ngày tháng năm sinh ");
                    String date = sc.nextLine();
                    listPhone.setDateOfBirth(date);
                    boolean check1 = false;
                    do {
                        System.out.println("nhập địa chỉ email ");
                        String s = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
                        String line = sc.nextLine();
                        Pattern pattern = Pattern.compile(s);
                        Matcher matcher = pattern.matcher(line);
                        if (matcher.find()) {
                            check1 = true;
                            listPhone.setEmail(line);
                        } else {
                            System.out.println("Bạn đã nhập sai , nhập lại");
                        }
                    } while (!check1);
                    getListPhone().add(listPhone);
                }
            } catch (NullPointerException | NumberFormatException e) {
                System.out.println("Nhập lại");
            }
        } while (a != 2);
    }

    public void showPhone() {
        for (ListPhone listPhone : getListPhone()) {
            System.out.println(listPhone.toString());
        }
    }

    public void deletePhone() {
        System.out.println("Nhập sđt cần xóa");
        String sdt = sc.nextLine();
        int a = 0;
        for (int i = 0; i < getListPhone().size(); i++) {
            if (getListPhone().get(i).getNumberPhone().equals(sdt)) {
                getListPhone().remove(i);
                System.out.println("Đã xóa");
                a++;
            }
        }
        if (a == 0) {
            System.out.println("Không tìm thấy");
        }
    }

    public void editPhone() {
        System.out.println("Nhập sđt cần sửa");
        String sđt = sc.nextLine();
        int a = 0;
        for (int i = 0; i < getListPhone().size(); i++) {
            if (getListPhone().get(i).getNumberPhone().equals(sđt)) {
                System.out.println("Nhập lại thông tin");
                System.out.println("Nhập nhóm");
                String nhom = sc.nextLine();
                listPhones.get(i).setGroup(nhom);
                System.out.println("Nhập tên");
                String name = sc.nextLine();
                listPhones.get(i).setName(name);
                System.out.println("Nhập giới tính");
                String gt = sc.nextLine();
                listPhones.get(i).setGender(gt);
                System.out.println("Nhập địa chỉ");
                String dc = sc.nextLine();
                listPhones.get(i).setAddress(dc);
                boolean check1 = false;
                do {
                    System.out.println("nhập địa chỉ email ");
                    String s = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
                    String line = sc.nextLine();
                    Pattern pattern = Pattern.compile(s);
                    Matcher matcher = pattern.matcher(line);
                    if (matcher.find()) {
                        check1 = true;
                        listPhones.get(i).setEmail(line);
                    } else {
                        System.out.println("Bạn đã nhập sai , nhập lại");
                    }
                } while (!check1);
                System.out.println("Sửa thành công");
                a++;
                break;
            }
        }
        if (a == 0) {
            System.out.println("Không tìm thấy");
        }
    }

    public void searchPhone() {
        System.out.println("Nhập sđt cần tìm");
        String sđt = sc.nextLine();
        int a = 0;
        for (int i = 0; i < getListPhone().size(); i++) {
            if (getListPhone().get(i).getNumberPhone().contains(sđt)){
                System.out.println(getListPhone().get(i).toString());
                a++;
                break;
            }
        }if (a == 0 ){
            System.out.println("Không tìm thấy");
        }
    }
}