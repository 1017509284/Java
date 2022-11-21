package com.zhaomeng;

/**
 * @author: zhaomeng
 * @Date: 2022/10/8 17:24
 */
// !推导lambda表达式
public class TestLambda01 {
    // !3.静态内部类
    static class Like2 implements ILike {
        @Override
        public void lambda() {
            System.out.println("i like lambda2");
        }
    }

    public static void main(String[] args) {
        // !定义一个接口 == 实现类
        ILike like = new Like();
        like.lambda();

        like = new Like2();
        like.lambda();

        // !4.局部内部类
        class Like3 implements ILike {
            @Override
            public void lambda() {
                System.out.println("i like lambda3");
            }
        }

        like = new Like3();
        like.lambda();

        // !5.匿名内部类
        like = new ILike() {
            @Override
            public void lambda() {
                System.out.println("i like lambda4");
            }
        };
        like.lambda();

        // !6.用lambda表达式简化
        like = () -> System.out.println("i like lambda6");
        like.lambda();

    }
}
// !1.定义一个函数式接口
interface ILike {
    void lambda();
}
// !2.实现类
class Like implements ILike {
    @Override
    public void lambda() {
        System.out.println("i like lambda");
    }
}

