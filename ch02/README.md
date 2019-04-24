# Spring in Action - 4th Edition - Chapter 2 Notes

![spring-context](https://img.shields.io/badge/spring--context-5.1.6-brightgreen.svg) ![spring-test](https://img.shields.io/badge/spring--test-5.1.6-brightgreen.svg) ![aspectj](https://img.shields.io/badge/aspectjweaver-1.9.3-brightgreen.svg) ![junit](https://img.shields.io/badge/junit-4.12-brightgreen.svg) ![mokito](https://img.shields.io/badge/mokito--core-2.23.4-brightgreen.svg) ![hamcrest](https://img.shields.io/badge/hamcrest--core-1.3-brightgreen.svg)

### 2.2 XML自动装配的例子
尝试用XML文件来启动spring的组件自动扫描功能。

#### 代码地址：<https://github.com/helloShen/spring-in-action-4th-edition-demo/tree/master/ch02>
`xml_autowired_22`包结构如下，
```
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── ciaoshen
    │   │           └── sia4
    │   │               └── ch02
    │   │                   └── xml_autowired_22
    │   │                       └── soundsystem
    │   │                           ├── CompactDisc.java
    │   │                           └── SixPense.java
    │   └── resources
    │       ├── application.properties
    │       └── xml_autowired_22
    │           └── soundsystem.xml
    └── test
        └── java
            └── com
                └── ciaoshen
                    └── sia4
                        └── ch02
                            └── xml_autowired_22
                                └── soundsystem
                                    └── CDPlayerTest.java
```

bean组件，比如`SixPense`类都用`@Component`注解标注。这样，开启spring组件自动扫描之后，被`@Component`注解标注过的组件都会被加载。XML配置文件`soundsystem.xml`放在`src/main/resources/`目录下，这个路径默认包含在gradle的`sourceSets.main.runtimeClasspath`路径集合里。为了不搞混，增设了`xml_autowired_22`一级子目录。

注意，书上用`@ContextConfiguration`注解类的时候括号里给出的是`@ContextConfiguration(classes=CDPlayerConfig.class)`配置类名称。这里是用XML配置要改成`@ContextConfiguration("classpath:/xml_autowired_22/soundsystem.xml")`XML配置文件的路径。注意路径前要加上`classpath:`前缀。

测试类`CDPlayerTest`类用JUnit的`@RunWith`注解标注过之后，gradle的`build`任务会自动运行测试。注意这里用到的Runner是`spring-test`包下的`SpringJUnit4ClassRunner`。

### 2.2 Annotation自动装配的例子
`annotation_autowired_22`包结构如下，
```
└── src
    ├── main
    │   └── java
    │       └── com
    │           └── ciaoshen
    │               └── sia4
    │                   └── ch02
    │                       └── annotation_autowired_22
    │                           └── soundsystem
    │                               ├── CDPlayerConfig.java
    │                               ├── CompactDisc.java
    │                               └── SixPense.java
    └── test
        └── java
            └── com
                └── ciaoshen
                    └── sia4
                        └── ch02
                            └── annotation_autowired_22
                                └── soundsystem
                                    └── CDPlayerTest.java
```    

和`xml_autowired_22`包类似。只是`src/main/resources/`包下的`soundsystem.xml`配置文件改成`soundsystem/CDPlayerConfig.java`配置类。关键就是`spring-context`包下的`@Configuration`注解和`@ComponentScan`注解。
