package ru.otus.homeworks.lesson21.calcExecutor;

public class CalcExecutor {
    public static Double calculate(Double val1, Double val2, char operator) {
        double result;
        switch (operator) {
            case '+':
                System.out.println("Выполняю сложение чисел " + val1 + " и " + val2);
                result = val1 + val2;
                break;
            case '-':
                System.out.println("Выполняю вычитание из " + val1 + " числа " + val2);
                result = val1 - val2;
                break;
            case '*':
                System.out.println("Выполняю умножение числа " + val1 + " на " + val2);
                result = val1 * val2;
                break;
            case '/':
                if (val2 == 0.0) {
                    throw new IllegalArgumentException("Делить на 0 нельзя");
                } else {
                    System.out.println("Выполняю деление числа " + val1 + " на " + val2);
                    result = val1 / val2;
                }
                break;
            default:
                throw new IllegalArgumentException("Приложение не рассчитано на работу с таким оператором");
        }
        return result;
    }
}
