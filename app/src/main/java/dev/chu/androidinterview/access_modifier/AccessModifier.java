package dev.chu.androidinterview.access_modifier;

public class AccessModifier {
    private int test00 = 10;

    protected int test01 = 100;

    public int test02 = 1000;

    int test03 = 10000;

    private void print00() {
        System.out.println("public test00 = "+test00+ ", test01 = "+test01+ ", test02 = "+test02+ ", test03 = "+test03);
    }

    protected void print01() {
        System.out.println("public test00 = "+test00+ ", test01 = "+test01+ ", test02 = "+test02+ ", test03 = "+test03);
    }

    public void print02() {
        System.out.println("public test00 = "+test00+ ", test01 = "+test01+ ", test02 = "+test02+ ", test03 = "+test03);
    }

    void print03() {
        System.out.println("public test00 = "+test00+ ", test01 = "+test01+ ", test02 = "+test02+ ", test03 = "+test03);
    }

    @Override
    public String toString() {
        print00();
        return "TestAccessController{" +
                "test00=" + test00 +
                ", test01=" + test01 +
                ", test02=" + test02 +
                ", test03=" + test03 +
                '}';
    }
}
