package com.ciaoshen.sia4.ch04.aop_aspectj_45.aspect;

public aspect CriticAspect {
    public CriticAspect() {}

    pointcut performance() : execution(* perform(..));

    afterReturning() : performance() {
        System.out.println(criticismEngine.getCriticism());
    }

    private CriticismEngine criticismEngine;

    public void setCriticismEngine(CriticismEngine criticismEngine) {
        this.criticismEngine = criticismEngine;
    }
}
