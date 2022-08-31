import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TaoMoiDanhSach {
    public static QuanLyDanhBa quanLyDanhBa = new QuanLyDanhBa();

    public static void taomoiDanhSach() {
        int choose = 1;
        do {
            Menu.hienThiMenuChinh();
            Scanner scanner = new Scanner(System.in);
            do {
                if (choose > 8) {
                    System.out.println("Vui lòng nhập lựa chọn trong menu!");
                }
                try {
                    choose = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.err.println("Nhập đúng lựa chọn !");
                }
            } while (choose < 1 || choose > 8);
            switch (choose) {
                case 1:
                    quanLyDanhBa.hienThi();
                    break;
                case 2:
                    chucNangThem();
                    break;
                case 3:
                    chucNangCapNhat();
                    break;
                case 4:
                    chucNangXoa();
                    break;
                case 5:
                    chucNangTimKiem();
                    break;
                case 6:
                    try {
                        chucNangDocVaoFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                case 7:
                    try {
                        chucNangGhiVaoFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                case 8:
                    System.exit(0);
            }
        } while (true);
    }

    public static void chucNangThem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap so dien thoai: ");
        String soDienTHoai = scanner.nextLine();
        System.out.println("Nhap nhom: ");
        String nhom = scanner.nextLine();
        System.out.println("Nhap ho ten:");
        String hoTen = scanner.nextLine();
        System.out.println("Nhap gioi tinh: ");
        String gioiTinh = scanner.nextLine();
        System.out.println("Nhap dia chi: ");
        String diaChi = scanner.nextLine();
        System.out.println("Nhap ngay sinh: ");
        String ngaySinh = scanner.nextLine();
        System.out.println("Nhap thu dien tu: ");
        String email = scanner.nextLine();
        DanhBa danhBa = new DanhBa(soDienTHoai, nhom, hoTen, gioiTinh, diaChi, ngaySinh, email);
        quanLyDanhBa.them(danhBa);
    }

    public static void chucNangCapNhat() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap so dien thoai can sua: ");
        String soDienThoaiSua = scanner.nextLine();
        System.out.println("Nhap danh ba can cap nhat");
        System.out.println("Nhap so dien thoai moi: ");
        String soDienTHoai = scanner.nextLine();
        System.out.println("Nhap nhom: ");
        String nhom = scanner.nextLine();
        System.out.println("Nhap ho ten: ");
        String hoTen = scanner.nextLine();
        System.out.println("Nhap gioi tinh: ");
        String gioiTinh = scanner.nextLine();
        System.out.println("Nhap dia chi: ");
        String diaChi = scanner.nextLine();
        System.out.println("Nhap ngay sinh: ");
        String ngaySinh = scanner.nextLine();
        System.out.println("Nhap thu dien tu: ");
        String email = scanner.nextLine();
        DanhBa danhBa = new DanhBa(soDienTHoai, nhom, hoTen, gioiTinh, diaChi, ngaySinh, email);
        quanLyDanhBa.sua(soDienThoaiSua, danhBa);
    }

    public static void chucNangXoa() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so dien thoai can xoa: ");
        String soDienThoai = scanner.nextLine();
        quanLyDanhBa.xoa(soDienThoai);
    }

    public static void chucNangTimKiem() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so dien thoai can tim: ");
        String soDienThoai = scanner.nextLine();
        quanLyDanhBa.layDanhBa(soDienThoai);
    }

    public static void chucNangDocVaoFile() throws IOException {
        FileReader fr = new FileReader("phone.csv");
        BufferedReader br = new BufferedReader(fr);
        String content = br.readLine();
        while ((content = br.readLine()) != null){
            System.out.println(content + "\n");
        }
    }
    public static void chucNangGhiVaoFile() throws IOException {
        FileWriter pw = new FileWriter("phone.csv");
        BufferedWriter bw = new BufferedWriter(pw);
        bw.write(quanLyDanhBa.hienThi2());
        bw.close();
    }
}
