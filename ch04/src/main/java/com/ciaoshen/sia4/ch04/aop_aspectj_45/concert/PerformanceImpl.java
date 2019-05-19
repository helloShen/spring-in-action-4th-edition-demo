package com.ciaoshen.sia4.ch04.aop_aspectj_45.concert;

// java util
import java.util.Random;

public class PerformanceImpl implements Performance {

    private static final Random R = new Random();
    private static final String[] WORDS = new String[]{"Wa", "Ta", "Xi", "Te", "Ko", "Ni", "Ji", "Ka"};
    private static final int SIZE = WORDS.length;

    public void perform() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) sb.append(WORDS[R.nextInt(SIZE)]);
        System.out.println(sb);
    }

}
