package mytest.hw机试;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HJ19 {

    static class ErrorInfo {
        String shortFileName;
        String fullFileName;
        Integer lineNum;
        Integer count = 1;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> input = new ArrayList<>();
        while (in.hasNextLine()) {
            String one = in.nextLine();
            if (one == null || one.trim().length() == 0 || one.trim().equals("\n")) {
                break;
            }
            input.add(one);
        }

        List<ErrorInfo> list = new ArrayList<>();
        for (String one : input) {
            ErrorInfo errorInfo = new ErrorInfo();
            String[] s = one.split(" ");
            String fullFileName = s[0];
            String lineNum = s[1];
            String[] split = fullFileName.split("\\\\");
            errorInfo.fullFileName = fullFileName;
            String shortFileName = split[split.length - 1];
            if (shortFileName.length() >= 16) {
                errorInfo.shortFileName = shortFileName.substring(shortFileName.length() - 16);
            } else {
                errorInfo.shortFileName = shortFileName;
            }
            errorInfo.lineNum = Integer.parseInt(lineNum);
            for (ErrorInfo info : list) {
                if (info.shortFileName.equals(errorInfo.shortFileName) && info.lineNum.equals(errorInfo.lineNum)) {
                    info.count++;
                    errorInfo.count = 100;
                }
            }
            if (errorInfo.count != 100) {
                list.add(errorInfo);
            }
        }
        if (list.size() >= 8) {
            list = list.subList(list.size() - 8, list.size());
        }
        for (ErrorInfo errorInfo : list) {
            System.out.println(errorInfo.shortFileName + " " + errorInfo.lineNum + " " + errorInfo.count);
        }
    }
}
//D:\cfmwafhhgeyawnool 649
//D:\zwtymj\xccb\ljj\cqzlyaszjvlsjmkwoqijggmybr 645

/*


D:\zwtymj\xccb\ljj\cqzlyaszjvlsjmkwoqijggmybr 645
E:\je\rzuwnjvnuz 633
C:\km\tgjwpb\gy\atl 637
F:\weioj\hadd\connsh\rwyfvzsopsuiqjnr 647
E:\ns\mfwj\wqkoki\eez 648
D:\cfmwafhhgeyawnool 649
E:\czt\opwip\osnll\c 637
G:\nt\f 633
F:\fop\ywzqaop 631
F:\yay\jc\ywzqaop 631
D:\zwtymj\xccb\ljj\cqzlyaszjvlsjmkwoqijggmybr 645


 */