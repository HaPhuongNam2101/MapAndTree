import java.util.Map;
import java.util.Scanner;

public class MenuStudent {
        StudentManager studentManager = new StudentManager();
        Scanner inputNumber = new Scanner(System.in);
        Scanner inputSting = new Scanner(System.in);

    public void showMenuStudent() {
        int choice;
        do {
            System.out.println("===== Quản lý sinh viên =====");
            System.out.println("1. Thêm mới sinh viên");
            System.out.println("2. Sửa thông tin sinh viên");
            System.out.println("3. Xóa sinh viên");
            System.out.println("4. Tìm kiếm sinh viên theo Id");
            System.out.println("5. Danh sách sinh viên theo tên gần đúng");
            System.out.println("6. Sinh viên có điểm trung bình cao nhất");
            System.out.println("7. Hiển thị tất cả sinh viên");
            System.out.println("0. Thoát chương trình");
            System.out.print("Nhập lựa chọn: ");
            choice = inputNumber.nextInt();
            inputNumber.nextLine();
            switch (choice) {
                case 1:
                    showMenuAdd();
                    break;
                case 2:
                    showMenuEdit();
                    break;
                case 3:
                    showMenuRemove();
                    break;
                case 4:
                    showSearchByIdMenu();
                    break;
                case 5:
                    showSearchByNameMenu();
                    break;
                case 6:
                    showTopStudentMenu();
                    break;
                case 7:
                    showMenuList();
                    break;
                case 0:
                    System.out.println("Thoát chương trình ");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ ");
            }
        } while (choice != 0);
    }
    private void showMenuAdd(){
        System.out.println("===== Thêm mới sinh viên =====");
        System.out.println("Nhập tên sinh viên: ");
        String name = inputSting.nextLine();
        System.out.print("Nhập giới tính : ");
        String gender = inputNumber.nextLine();
        System.out.print("Nhập điểm Toán: ");
        double scoreMath = inputNumber.nextDouble();
        System.out.print("Nhập điểm Văn: ");
        double scoreLiterature = inputNumber.nextDouble();
        System.out.print("Nhập điểm Anh: ");
        double scoreEnglish = inputNumber.nextDouble();
        Student student = new Student(name, gender, scoreMath,scoreLiterature,scoreEnglish);
        studentManager.saveStudent(student);
        System.out.println("Thêm sinh viên thành công ");
    }
    private void showMenuEdit(){
        System.out.println(" ===== Sửa sinh viên =====");
        System.out.println("Nhập mã sinh viên cần sửa ");
        int idEdit = inputNumber.nextInt();
        System.out.println("Nhập tên sinh viên: ");
        String name = inputNumber.nextLine();
        System.out.println("Nhập giới tính: ");
        String gender = inputNumber.nextLine();
        System.out.println("Nhập điểm toán: ");
        double scoreMath = inputNumber.nextDouble();
        System.out.print("Nhập điểm Văn mới: ");
        double scoreLiterature = inputNumber.nextDouble();
        System.out.print("Nhập điểm Anh mới: ");
        double scoreEnglish = inputNumber.nextDouble();
        Student student = new Student(idEdit,name, gender, scoreMath,scoreLiterature,scoreEnglish);
    }
    private void showMenuRemove(){
        System.out.println("===== Xóa sinh viên =====");
        System.out.println("Nhập mã sinh viên cần xóa: ");
        int idDelete = inputNumber.nextInt();
        studentManager.deleteStudent(idDelete);
        System.out.println("Xóa sinh viên thành công ");
    }
    private void showSearchByIdMenu(){
        System.out.println("===== Tìm kiếm sinh viên theo Id =====");
        System.out.println("Nhập mã sinh viên cần tìm: ");
        int idSearch = inputNumber.nextInt();
        Student student = studentManager.getStudent(idSearch);
        if (student != null) {
            System.out.println(student);
        }else {
            System.out.println("Không tìm thấy sinh viên có mã " + idSearch);
        }
    }
    private void showSearchByNameMenu(){
        System.out.println("===== Tìm kiếm sinh viên với tên gần đúng =====");
        System.out.println("Nhập tên sinh viên cần tìm: ");
        String searchName = inputNumber.nextLine();
        Map<Integer, Student> listStudent = studentManager.getStudentByName(searchName);
        if (listStudent.isEmpty()) {
            System.out.println("Không tìm thấy sinh viên có tên gần đúng ");
        }else {
            for (Student student : listStudent.values()) {
                System.out.println(student);
            }
        }
    }
    private void showTopStudentMenu(){
        System.out.println("===== Sinh viên có điểm trung bình cao nhất ===== ");
        Student topStudent = studentManager.getMaxAvg();
        if (topStudent != null) {
            System.out.println("Sinh viên có điểm trung bình cao nhất: ");
            System.out.println(topStudent);
        }else {
            System.out.println("Không có sinh viên nào trong danh sách ");
        }
    }
    private void showMenuList() {
        System.out.println("===== Danh sách sinh viên =====");
        for (Student student : studentManager.getAllStudents().values()) {
            System.out.println(student);
        }
    }
}
