package com.tsvhlpom.user.constants;

public class FlagConstants {
    public final static String PASS = "Pass"; // 验证通过（强密码且未超过90天）
    public final static String ISWEAK = "isWeak";//弱密码 需要修改
    public final static String NEEDUPDATE = "needUpdate";//强密码，但是超过90天，需要修改密码
}
