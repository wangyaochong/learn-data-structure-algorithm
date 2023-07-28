package 机考准备.面试专用.一面;

public class LifeCycle {
     // 静态属性         2
    private static String staticField = getStaticField();
    // 静态方法块     1
    static {
        System.out.println(staticField);
        System.out.println("静态方法块初始化");
        System.out.println("Static Patch Initial");
    }
    // 普通属性         3
    private String field = getField();
    // 普通方法块     4
    {
        System.out.println(field);
        System.out.println("普通方法块初始化");
        System.out.println("Field Patch Initial");
    }
    // 构造函数        5
    public LifeCycle() {
        System.out.println("构造函数初始化");
        System.out.println("Structure Initial ");
    }

    public static String getStaticField() {
        String statiFiled = "Static Field Initial";
        System.out.println("静态属性初始化");
        return statiFiled;
    }

    public static String getField() {
        String filed = "Field Initial";
        System.out.println("普通属性初始化");
        return filed;
    }

    public static void main(String[] argc) {
        new LifeCycle();
    }
}
