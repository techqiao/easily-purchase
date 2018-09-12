package com.epc.common.util;

import java.util.HashSet;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>Description : DateTimeUtil
 * <p>Date : 2018-09-09 22:47
 * <p>@Author : wjq
 */
@SuppressWarnings("WeakerAccess")
public class RandomNumberGenerator {

    /**
     * 这是典型的随机洗牌算法。
     * 流程是从备选数组中选择一个放入目标数组中，将选取的数组从备选数组移除（放至最后，并缩小选择区域）
     * 算法时间复杂度O(n)
     *
     * @return 随机8为不重复数组
     */
    private static String generateNumber() {
        StringBuilder no = new StringBuilder();
        //初始化备选数组
        int[] defaultNums = new int[10];
        for (int i = 0; i < defaultNums.length; i++) {
            defaultNums[i] = i;
        }

        Random random = new Random();
        int[] nums = new int[LENGTH];
        //默认数组中可以选择的部分长度
        int canBeUsed = 10;
        //填充目标数组
        for (int i = 0; i < nums.length; i++) {
            //将随机选取的数字存入目标数组
            int index = random.nextInt(canBeUsed);
            nums[i] = defaultNums[index];
            //将已用过的数字扔到备选数组最后，并减小可选区域
            swap(index, canBeUsed - 1, defaultNums);
            canBeUsed--;
        }
        if (nums.length > 0) {
            for (int num : nums) {
                no.append(num);
            }
        }

        return no.toString();
    }

    private static final int LENGTH = 8;

    private static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static String random8BitNumber() {
        StringBuilder no = new StringBuilder();
        int num[] = new int[8];
        int c;
        for (int i = 0; i < 8; i++) {
            num[i] = new Random().nextInt(10);
            c = num[i];
            for (int j = 0; j < i; j++) {
                if (num[j] == c) {
                    i--;
                    break;
                }
            }
        }
        for (int aNum : num) {
            no.append(aNum);
        }
        return no.toString();
    }


    public static String[] chars = new String[]{"a", "b", "c", "d", "e", "f",
            "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
            "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z"};


    public static String uuid8Bit() {
        StringBuilder shortBuffer = new StringBuilder();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        System.out.println("orginal legnth = " + uuid.length());
        for (int i = 0; i < 8; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            shortBuffer.append(chars[x % 0x3E]);
        }
        return shortBuffer.toString();

    }

    public static void main(String[] args) {
        HashSet<String> set01 = new HashSet<>();
        HashSet<String> set02 = new HashSet<>();

        //测试次数
        final int TIMES = 100;
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> {
                HashSet<String> set03 = new HashSet<>();
                System.out.println("Current ThreadName" + Thread.currentThread().getName());
                //截取为8位UUID
                for (int j = 0; j < TIMES; j++) {
                    set03.add(uuid8Bit());
                }
                System.out.printf("随机生成8位数字 - 截取uuid - 测试次数 : %d,重复次数 ： %d %n", TIMES, TIMES - set03.size());

            });
        }


//        executorService.submit(() -> {
//            //测试算法1
//            for (int i = 0; i < TIMES; i++) {
//                set01.add(generateNumber());
//            }
//        });
//
//        executorService.submit(() -> {
//            //测试算法2
//            for (int i = 0; i < TIMES; i++) {
//                set02.add(random8BitNumber());
//            }
//        });


        //打印输出结果
//        System.out.printf("随机生成8位数字 - 随机算法1 - 测试次数 : %d,重复次数 ： %d %n", TIMES, TIMES - set01.size());
//        System.out.printf("随机生成8位数字 - 随机算法2 - 测试次数 : %d,重复次数 ： %d %n", TIMES, TIMES - set02.size());

    }
}
