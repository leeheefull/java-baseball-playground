package calculator;

import calculator.service.StringCalculator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CalculatorMain {

    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.print("계산기: ");
            String input = br.readLine();
            System.out.print("결과 > " + new StringCalculator().getResult(input));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
