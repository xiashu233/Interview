package com.facetest.demo.Java基础;

import java.io.*;

public class ThrowableDemo implements Serializable {

    public static void main(String[] args) throws IOException {
        // try块用来捕捉异常 后面跟零或多个catch块 如果没有catch块则必须跟上一个 finally
        OutputStream out = null;
        try{
            int[] a = new int[2];
            System.out.println(a[5]);
            out = new FileOutputStream("D://te是是是xt.xls");

        }
        // catch 块相似于 switch 的 case 结构，可以声明多个 catch 分支，从上往下判断 只执行一次
        catch (ArrayIndexOutOfBoundsException e){
            // 输出异常详细信息
            e.printStackTrace();
            // e.getMessage() 返回异常的简要描述
            System.out.println(e.getMessage());
            // e.toString() 返回异常的详细信息
            System.out.println(e.toString());
            // 返回异常的本地化信息 如果子类没有重写该方法 则默认返回父类的
            System.out.println(e.getLocalizedMessage());

        }catch (FileNotFoundException fe){
            fe.printStackTrace();
            return;
        }
        // finally 模块的意义就是try 结构中必须会执行的一个模块 通常用于关闭资源等
        // 当 try 或 catch 模块执行了 return 命令的时候，依然会在 return 之前执行 finally 模块的语句
        finally {
            if (out!=null){
                out.close();
            }

        }
    }
}
