package com.facetest.demo.设计模式.模板方法;

public class TestPaper {
    public void testQuestion1(){
        System.out.println("考试试卷一：a.1 b.2 c.3 d.4");
        System.out.println("答案：" + answer1());
    }

    public void testQuestion2(){
        System.out.println("考试试卷二：a.1 b.2 c.3 d.4");
        System.out.println("答案：" + answer2());
    }
    public void testQuestion3(){
        System.out.println("考试试卷三：a.1 b.2 c.3 d.4");
        System.out.println("答案：" + answer3());
    }
    public void testQuestion4(){
        System.out.println("考试试卷四：a.1 b.2 c.3 d.4");
        System.out.println("答案：" + answer4());
    }

    public String answer1() {
        return "";
    }

    public String answer2() {
        return "";
    }

    public String answer3() {
        return "";
    }

    public String answer4() {
        return "";
    }
}
