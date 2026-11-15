public class Member {
    int id;
    String name;
    String role;

    public Member(int id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    String describe() {
        return id + " 号 " + name + "（" + role + "）";
    }
}