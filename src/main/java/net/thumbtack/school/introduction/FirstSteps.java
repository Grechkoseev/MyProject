package net.thumbtack.school.introduction;

public class FirstSteps {
    //Возвращает сумму чисел leftTop и rightBottom
    public int sum(int leftTop, int rightBottom) {
        return leftTop + rightBottom;
    }

    //Возвращает произведение чисел leftTop и rightBottom
    public int mul(int leftTop, int rightBottom) {
        return leftTop * rightBottom;
    }

    //Возвращает частное от деления чисел leftTop и rightBottom. Гарантируется, что rightBottom != 0
    public int div(int leftTop, int rightBottom) {
        return leftTop / rightBottom;
    }

    //Возвращает остаток от деления чисел leftTop и rightBottom. Гарантируется, что rightBottom != 0
    public int mod(int leftTop, int rightBottom) {
        return leftTop % rightBottom;
    }

    //Возвращает true, если  leftTop равен rightBottom, иначе false
    public boolean isEqual(int leftTop, int rightBottom) {
        return leftTop == rightBottom;
    }

    //Возвращает true, если  leftTop больше rightBottom, иначе false
    public boolean isGreater(int leftTop, int rightBottom) {
        return leftTop > rightBottom;
    }

    // Прямоугольник с горизонтальными и вертикальными сторонами, задан двумя точками - левой верхней (xLeft, yTop) и правой нижней (xRight, yBottom). На плоскости OXY ось X направлена вправо, ось Y - вниз.
    // Дана еще одна точка с координатами (leftTop, rightBottom). Гарантируется, что xLeft < xRight и yTop < yBottom. Метод должен возвращать true, если точка лежит внутри прямоугольника , иначе false.
    // Если точка лежит на границе прямоугольника, то считается, что она лежит внутри него
    public boolean isInsideRect(int xLeft, int yTop, int xRight, int yBottom, int leftTop, int rightBottom) {
        return leftTop >= xLeft && leftTop <= xRight && rightBottom >= yTop && rightBottom <= yBottom;
    }

    //Возвращает сумму чисел, заданных одномерным массивом array. Для пустого одномерного массива возвращает 0
    public int sum(int[] array) {
        int sum = 0;
        if (array.length == 0) {
            return 0;
        }
        for (int value : array) {
            sum += value;
        }
        return sum;
    }

    //Возвращает произведение чисел, заданных одномерным массивом array. Для пустого одномерного массива возвращает 0
    public int mul(int[] array) {
        int mul = 1;
        if (array.length == 0) {
            return 0;
        }
        for (int value : array) {
            mul *= value;
        }
        return mul;
    }

    // Возвращает минимальное из чисел, заданных одномерным массивом array.
    // Для пустого одномерного массива возвращает Integer.MAX_VALUE
    public int min(int[] array) {
        int min = Integer.MAX_VALUE;
        if (array.length == 0) {
            return min;
        }
        for (int value : array) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    // Возвращает максимальное из чисел, заданных одномерным массивом array.
    // Для пустого одномерного массива возвращает Integer.MIN_VALUE.
    public int max(int[] array) {
        int max = Integer.MIN_VALUE;
        if (array.length == 0) {
            return Integer.MIN_VALUE;
        }
        for (int value : array) {
            if (max < value) {
                max = value;
            }
        }
        return max;
    }

    // Возвращает среднее значение для чисел, заданных одномерным массивом array.
    // Для пустого одномерного массива возвращает 0.
    public double average(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        return (double) sum / array.length;
    }

    // Возвращает true, если одномерный массив array строго упорядочен по убыванию, иначе false.
    // Пустой одномерный массив считается упорядоченным.
    public boolean isSortedDescendant(int[] array) {
        if (array.length == 0) {
            return true;
        }
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] <= array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    // Возводит все элементы одномерного массива array в куб.
    public void cube(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] * array[i] * array[i];
        }
    }

    // Возвращает true, если в одномерном массиве array имеется элемент, равный value, иначе false.
    public boolean find(int[] array, int value) {
        for (int element : array) {
            if (element == value) {
                return true;
            }
        }
        return false;
    }

    // Переворачивает одномерный массив array, то есть меняет местами 0-й и последний, 1-й и предпоследний и т.д. элементы.
    public void reverse(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }

    // Возвращает true, если одномерный массив является палиндромом, иначе false. Пустой массив считается палиндромом.
    public boolean isPalindrome(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            if (array[i] != array[array.length - i - 1]) {
                return false;
            }
        }
        return true;
    }

    // Возвращает сумму чисел, заданных двумерным массивом matrix.
    public int sum(int[][] matrix) {
        int sum = 0;
        for (int[] row : matrix) {
            sum += sum(row);
        }
        return sum;
    }

    // Возвращает максимальное из чисел, заданных двумерным массивом matrix.
    // Для пустого двумерного массива возвращает Integer.MIN_VALUE.
    public int max(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        for (int[] row : matrix) {
            if (max(row) > max) {
                max = max(row);
            }
        }
        return max;
    }

    // Возвращает максимальное из чисел, находящихся на главной диагонали квадратного двумерного массива matrix.
    // Для пустого двумерного массива возвращает Integer.MIN_VALUE.
    public int diagonalMax(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        if (matrix.length == 0) {
            return max;
        }
        for (int i = 0; i < matrix.length; i++) {
            if (max < matrix[i][i]) {
                max = matrix[i][i];
            }
        }
        return max;
    }

    // Возвращает true, если все строки двумерного массива matrix строго упорядочены по убыванию, иначе false.
    // Пустая строка считается упорядоченной. Разные строки массива matrix могут иметь разное количество элементов.
    // При написании метода рекомендуется внутри него вызвать метод из п. 13.
    public boolean isSortedDescendant(int[][] matrix) {
        for (int[] row : matrix) {
            if (!isSortedDescendant(row)) {
                return false;
            }
        }
        return true;
    }
}
