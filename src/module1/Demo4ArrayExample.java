package module1;

import java.util.Arrays;

/**
 * 使用数组，必须明确数组的长度
 * 要注意，使用的时候不要数据越界
 */
public class Demo4ArrayExample {
    public static void main(String[] args) {
        // 1. 一维数据

        // 先声明，后申请内存空间
        int[] array1;
        array1 = new int[10]; // 开辟内存空间（10个int那么大的内存空间），默认值都是0
        for (int i : array1) {
            System.out.print(i + ",");
        }
        int[] array2 = new int[5];// 开辟5个int大小的内存空间，默认值都是0

        // 声明数组的同时，对数据中的值进行初始化
        // 动态初始化
        int[] array3 = new int[]{10, 20, 30, 40, 50};
        // 静态初始化
        int[] array4 = {10, 20, 30, 40, 50};
        System.out.println();
        System.out.println("array3 = " + Arrays.toString(array3));

        // 访问数组中的元素，采用数组的索引下标
        System.out.println("array3[2] = " + array3[2]); // 30
        array3[0] = 100;
        System.out.println("array3 = " + Arrays.toString(array3));

        System.out.println("array3.length = " + array3.length);

        for (int i = 0; i < array3.length; i++) {
            System.out.println(array3[i]);
        }
        // 数据越界： Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 5
//        System.out.println("array3[5] = " + array3[5]);

        // 2. 多维数组

        System.out.println("===== 多维数组 ======");
        int[][] matrix1 = new int[][]{{6, 2, 3}, {4, 1, 6}, {8, 7, 9}}; // 3行3列的矩阵
        /*
        1 2 3
        4 5 6
        7 8 9
         */
        int[] line1 = matrix1[0];

        // 获取5
        System.out.println("matrix1[1][1] = " + matrix1[1][1]);


        // 二维数组遍历：（使用嵌套for循环）
        for (int[] line : matrix1) {
            for (int element : line) {
                System.out.print(element + "\t");
            }
            System.out.println();
        }

        for (int[] line : matrix1) {
            Arrays.sort(line);
        }
//        Arrays.sort(matrix1);
        System.out.println("排序后：");
        for (int[] line : matrix1) {
            for (int element : line) {
                System.out.print(element + "\t");
            }
            System.out.println();
        }

        // 数组填充
        int[] fillArray = new int[10];
        Arrays.fill(fillArray, 6);
        System.out.println("fillArray = " + Arrays.toString(fillArray));

    }
}
