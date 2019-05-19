package com.ciaoshen.sia4.ch04.aop_before_after_43.concert;

// aspectj
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.JoinPoint;


@Aspect
public class Audience {

    @Pointcut("execution(* com.ciaoshen.sia4.ch04.aop_before_after_43.concert.Performance.perform(int)) " +
              "&& args(id)")
    public void performance(int id) {}

    @Before("performance(id)")
    public void announcement(int id) {
        System.out.println("下面是郭德纲《你字系列》专场第" + id + "个节目: ");
    }

    @AfterReturning("performance(id)")
    public void onStage(JoinPoint point, int id) {
        String performance = ( (Performance) point.getTarget() ).whatsOnStage();
        System.out.println("    >>>" + performance);
        System.out.println("        ~~~吁吁吁吁吁吁吁吁~~~");
    }

}
