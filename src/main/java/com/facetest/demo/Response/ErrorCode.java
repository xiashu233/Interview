package com.facetest.demo.Response;


/**
 * 充分仿照阿里巴巴开发手册
 * 错误产生来源分为 A/B/C，A 表示错误来源于用户，比如参数错误，用户安装版本过低，用户支付
 * 超时等问题；B 表示错误来源于当前系统，往往是业务逻辑出错，或程序健壮性差等问题；C 表示错误来源
 * 于第三方服务，比如 CDN 服务出错，消息投递超时等问题；四位数字编号从 0001 到 9999，大类之间的步长间距预留 100
 *
 */
public enum ErrorCode {

    //枚举字段以逗号隔开，结尾是分号，必须写在前面
    OK("0000","请求成功"),
    User_Already_Exists("A0111","用户名已存在"),
    Error_Exception("B0000","系统异常"),
    System_TimeOut("B0100","系统超时"),
    Redis_Key_Not_Found("C0110","Redis的key未查询到"),
    ;



    private  String code;
    private  String msg;

    ErrorCode(String code, String msg){
        this.code=code;
        this.msg=msg;

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ErrorCode{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
