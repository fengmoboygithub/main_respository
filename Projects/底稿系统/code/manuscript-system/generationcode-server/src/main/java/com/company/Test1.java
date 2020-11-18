package com.company;

import java.math.BigDecimal;
import java.util.Scanner;

public class Test1 {
    /**
     * 男性的身体脂肪公式
     *  参数a = 腰围-公分 x 0.74
     *  参数b = <wbr> (体重-公斤 x 0.082) + 44.74
     *  身体脂肪总重量-公斤= a - b
     *  体脂率(身体脂肪百分比) = (身体脂肪总重量÷ 体重) x 100%
     *
     *  
     * @param args
     */
    public static void main(String[] args) {
//        System.out.println("计算男性身体脂肪公式：");
//        Scanner in = new Scanner(System.in);
//        System.out.println("请输入腰围(公分)：");
//        //腰围
//        BigDecimal waistline = in.nextBigDecimal();
//        //体重
//        System.out.println("请输入体重(公斤)：");
//        BigDecimal weight = in.nextBigDecimal();
//        //a
//        BigDecimal a = waistline.multiply(new BigDecimal(0.74));
//        //b
//        BigDecimal b = new BigDecimal(44.74).add(weight.multiply(new BigDecimal(0.082)));
//
//        System.out.println(String.format("a：%f  b：%f", a, b));
//        //身体脂肪总重量(公斤)
//        BigDecimal BMI = a.subtract(b);
//        System.out.println(String.format("身体脂肪总重量(公斤)：%f", BMI));
//        //体脂率(身体脂肪百分比)
//        BigDecimal BF = (BMI.divide(weight, 2, BigDecimal.ROUND_HALF_UP)).multiply(new BigDecimal(100));
//
//        System.out.println(String.format("体脂率(身体脂肪百分比)：%f%%", BF));

        System.out.println("node1".substring(4));
    }
}
