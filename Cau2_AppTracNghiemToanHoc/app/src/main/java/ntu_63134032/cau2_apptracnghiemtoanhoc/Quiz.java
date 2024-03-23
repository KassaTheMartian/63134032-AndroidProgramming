package ntu_63134032.cau2_apptracnghiemtoanhoc;


import java.util.Random;
import java.util.Stack;

public class Quiz {
    String chuoiPhepToan;

    public Quiz(String phepToan) {
        this.chuoiPhepToan = phepToan;
    }

    public Quiz(){

    }

    public String taoChuoiPhepToan(int n){
        Random rand = new Random();
        StringBuilder builder = new StringBuilder();
        // Tạo số đầu tiên
        builder.append(rand.nextInt(10)); // Tạo số ngẫu nhiên từ 0 đến 9

        // Tạo n-1 phép toán và số kèm theo
        for (int i = 0; i < n - 1; i++) {
            // Chọn ngẫu nhiên một toán tử từ +, -, *, /
            char operator = "+-*/".charAt(rand.nextInt(4));
            // Thêm toán tử vào chuỗi
            builder.append(" ").append(operator).append(" ");
            // Thêm số tiếp theo vào chuỗi
            builder.append(rand.nextInt(10)); // Tạo số ngẫu nhiên từ 0 đến 9
        }

        return builder.toString();
    }
}
