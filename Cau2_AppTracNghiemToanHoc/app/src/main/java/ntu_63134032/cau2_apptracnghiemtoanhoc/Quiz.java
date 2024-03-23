package ntu_63134032.cau2_apptracnghiemtoanhoc;


import java.util.Random;
import java.util.Stack;

public class Quiz {
    String chuoiPhepToan;

    public Quiz(String phepToan) {
        this.chuoiPhepToan = phepToan;
    }

    public Quiz(int n){
        this.chuoiPhepToan = taoChuoiPhepToan(n);
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
    public double tinhChuoiPhepToan() {
        Stack<Double> numbers = new Stack<>();
        Stack<Character> toanTu = new Stack<>();

        for (int i = 0; i < chuoiPhepToan.length(); i++) {
            char c = chuoiPhepToan.charAt(i);
            if (Character.isDigit(c)) {
                StringBuilder sb = new StringBuilder();
                sb.append(c);
                while (i + 1 < chuoiPhepToan.length() && Character.isDigit(chuoiPhepToan.charAt(i + 1))) {
                    sb.append(chuoiPhepToan.charAt(++i));
                }
                numbers.push(Double.parseDouble(sb.toString()));
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!toanTu.empty() && uuTien(toanTu.peek()) >= uuTien(c)) {
                    apDungToanTu(numbers, toanTu);
                }
                toanTu.push(c);
            }
        }

        while (!toanTu.empty()) {
            apDungToanTu(numbers, toanTu);
        }

        return numbers.pop();
    }

    public int uuTien(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        }
        return -1;
    }

    public void apDungToanTu(Stack<Double> numbers, Stack<Character> operators) {
        double b = numbers.pop();
        double a = numbers.pop();
        char operator = operators.pop();
        double result = 0.0;
        switch (operator) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                result = a / b;
                break;
        }
        numbers.push(result);
    }

    public String getChuoiPhepToan() {
        return chuoiPhepToan;
    }
}
