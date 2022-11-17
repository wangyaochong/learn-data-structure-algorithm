package leetcode.byNumber.p200;

public class p182_数据库_DuplicateEmails {

    String answer = "select Email from Person group by Email having count(1)>1;";
}
