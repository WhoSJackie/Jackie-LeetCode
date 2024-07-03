package com.wang.learning;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class User {

    private final String name="maggie";
    private int age=10;

    static{
        System.out.println("父类静态代码块");
    }
    {
        System.out.println("父类代码块");
    }
    User(){
        System.out.println("父类构造方法");
    }

    class Supplier{
        private String sName;

        Supplier(String name){
            this.sName=name;
        }

        public void getSupply(){
            System.out.println(sName);
        }

    }

    Supplier supp=new Supplier("jackie"){
        @Override
        public void getSupply(){
            System.out.println(name);//访问外部类final修饰变量
            System.out.println(age);
            super.getSupply();
        }

    };

    public void print(){
        supp.getSupply();
    }

    public static void main(String[] args) {
        User user=new User();
        user.print();
    }

}
