package dev.chu.androidinterview.access_modifier;

public class CallAccessModifier {
    private AccessModifier tac0 = new AccessModifier();
    protected AccessModifier tac1 = new AccessModifier();
    public AccessModifier tac2 = new AccessModifier();
    AccessModifier tac3 = new AccessModifier();

    public void main() {
        tac0.test01 = 30;
        tac0.print01();
        tac0.test02 = 40;
        tac0.print02();
        tac0.test03 = 50;
        tac0.print03();

        tac0.toString();
    }
}
