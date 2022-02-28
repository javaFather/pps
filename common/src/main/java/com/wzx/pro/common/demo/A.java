package com.wzx.pro.common.demo;

 class A {
     public A() {
         System.out.println("A 构造方法");
     }
     static {
         System.out.println("A static");
     }
 }
    class B extends A{
        public B() {
            System.out.println("B 构造方法");
        }
        static{
            System.out.println("B static");
        }
    }
    class C extends B{
        public C() {
            System.out.println("C 构造方法");
        }
        private static D d = new D();
        static{
            System.out.println("C static");
        }
    }
    class D{
        public D() {
            System.out.println("D 构造方法");
        }
        static{
            System.out.println("D static");
        }
    }




