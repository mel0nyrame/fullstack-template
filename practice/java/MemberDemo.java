class Member {
    private int id;        // 编号
    private String name;   // 姓名
    private String role;   // 角色
        // 构造器：名字必须和类名一样，没有返回值
    Member(int id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }
        // Getter 方法
    int getId() { return id; }
    String getName() { return name; }
    String getRole() { return role; }
}
public class MemberDemo {
    public static void main(String[] args) {
        Member m1 = new Member(1, "小林", "MEMBER");
        Member m2 = new Member(2, "王老师", "TEACHER");

        System.out.println("编号：" + m1.getId() + "，成员：" + m1.getName() + "，角色：" + m1.getRole());
        System.out.println("编号：" + m2.getId() + "，成员：" + m2.getName() + "，角色：" + m2.getRole());
    }
}