package com.zhaomeng.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @author: zhaomeng
 * @Date: 2022/10/26 16:49
 */
public class People {
    // !如果显示指定了Autowired的required属性为false，说明这个对象可以为null
    // !如果一个class注入了两个bean，如：cat11，cat22，那么可以通过@Qualifier来显示指定注入哪个bean
    // !也可以用@Resource注解，然后用name属性指定bean

    /**
     * @Autowired和@Resource的区别和差异
     * 1. 都是用来自动装配的，都可以放在属性字段上
     * 2. @Autowired通过bytype的方式实现，而且必须要求这个对象存在
     * 3. @Resource默认通过byname的方式实现，如果找不到名字，则继续通过bytype查找，如果两个都找不到的情况下面就报错【常用】
     * 4. 执行顺序不同，@Autowired先类型后名字（需要@Qualifier配合），@Resource先名字后类型
     */
    @Autowired
    @Qualifier(value = "cat222")
    private Cat cat;
    @Autowired
    private Dog dog;

    private String name;

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "People{" +
                "cat=" + cat +
                ", dog=" + dog +
                ", name='" + name + '\'' +
                '}';
    }
}
