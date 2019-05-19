package com.ciaoshen.sia4.ch04.aop_around_43.concert;

// aspectj
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;


@Aspect
public class Audience {

    @Pointcut("execution(* com.ciaoshen.sia4.ch04.aop_around_43.concert.Performance.perform(int)) " +
              "&& args(id)")
    public void performance(int id) {}

    @Around("performance(id)")
    public void around(ProceedingJoinPoint point, int id) {
        try {
            System.out.println("下面是郭德纲《你字系列》专场第" + id + "个节目: ");
            point.proceed();
            String performance = ( (Performance) point.getTarget() ).whatsOnStage();
            System.out.println("    >>>" + performance);
            System.out.println("        ~~~吁吁吁吁吁吁吁吁~~~");
        } catch (Throwable e) {
            System.out.println("下去~下去~下去~我们要退票~");
        }
    }

}
