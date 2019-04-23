package com.ciaoshen.sia4.ch01.minstrel_113;

import com.ciaoshen.sia4.ch01.minstrel_113.Knight;

import java.io.PrintStream;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Minstrel {

    private PrintStream stream;

    public Minstrel(PrintStream stream) {
        this.stream = stream;
    }

    @Pointcut("execution(** Knight.embarkOnQuest(..))")
    public void cutOnEmbarkOnQuest() {}

    @Before("cutOnEmbarkOnQuest()")
    public void singBeforeQuest() {
        stream.println("床前明月光, 骑士握钢枪。");
    }

    @After("cutOnEmbarkOnQuest()")
    public void singAfterQuest() {
        stream.println("举头望明月，骑士归故乡。");
    }

}
