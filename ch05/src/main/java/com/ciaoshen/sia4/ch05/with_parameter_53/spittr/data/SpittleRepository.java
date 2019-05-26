package com.ciaoshen.sia4.ch05.with_parameter_53.spittr.data;

// my project package
import com.ciaoshen.sia4.ch05.with_parameter_53.spittr.Spittle;
// java util
import java.util.List;

/**
 * 5.2节的例子完全没有实际数据
 * 只定义了SpittleRepository这一个接口。
 * 测试的时候靠Mockito模拟一个实现SpittleRepository接口的实例。
 */
public interface SpittleRepository {

    public List<Spittle> findSpittles(long max, int count);

    public Spittle findOne(long id);

}
