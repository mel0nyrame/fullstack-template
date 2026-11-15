public class MemberDemo {
    public static void main(String[] args) {
        Member m1 = new Member(1, "张三", "成员");
        Member m2 = new Member(2, "李四", "老师");

        System.out.println(m1.describe());
        System.out.println(m2.describe());
    }
}