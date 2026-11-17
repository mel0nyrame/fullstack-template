public class ProjectDemo {
    public static void main(String[] args) {
        Project p = new Project(1, "传感器项目", 1000);
        System.out.println("项目 " + p.id + " " + p.name + " 总预算 " + p.total);
        p.printState();
        if (p.apply(600)) {
            System.out.println("申请 600 → 成功");
        } else {
            System.out.println("申请 600 → 失败");
        }
        p.printState();

        if (p.apply(500)) {
            System.out.println("申请 500 → 成功");
        } else {
            System.out.println("申请 500 → 失败（经费不足）");
        }
        p.printState();

        if (p.apply(-100)) {
            System.out.println("申请 -100 → 成功");
        } else {
            System.out.println("申请 -100 → 失败");
        }
        p.printState();
    }

}
