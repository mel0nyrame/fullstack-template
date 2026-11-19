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
        if (p.apply(100)) {
            System.out.println("申请 100 → 成功");
        } else {
            System.out.println("申请 100 → 失败 (不是草稿状态)");
        }
        p.printState();


        if (p.apply(500)) {
            System.out.println("申请 500 → 成功");
        } else {
            System.out.println("申请 500 → 失败（经费不足）");
        }
        p.printState();

        if (p.approve(500)) {
        System.out.println("批准 500 → 成功");
        } else {
        System.out.println("批准 500 → 失败");
        }
        p.printState();


        if (p.apply(-100)) {
            System.out.println("申请 -100 → 成功");
        } else {
            System.out.println("申请 -100 → 失败");
        }
        p.printState();


        Project p2 = new Project(2, "测试项目", 1000);
        p2.apply(600);
        if (p2.approve(700)) {
            System.out.println("批准 700 → 成功");
        } else {
            System.out.println("批准 700 → 失败");
        }
        p2.printState();

        if (p2.approve(0)) {
            System.out.println("批准 0 → 成功");
        } else {
            System.out.println("批准 0 → 失败");
        }
        p2.printState();


        Project p3 = new Project(3, "结算测试", 1000);
        p3.apply(600);
        p3.approve(500);
        p3.printState();

        if (p3.settle(460)) {
            System.out.println("结算 460 → 成功");
        } else {
            System.out.println("结算 460 → 失败");
        }
        p3.printState();

        if (p3.settle(100)) {
            System.out.println("再次结算 → 成功");
        } else {
            System.out.println("再次结算 → 失败(已结束)");
        }
        p3.printState();


        Project p4 = new Project(4, "测试拒绝项目", 1000);
        if(p4.apply(600)){
            System.out.println("申请 600 → 成功");
        }
        p4.printState();
        if(p4.reject("")){
            System.out.println("拒绝（理由为空）→ 成功");
        }else{
            System.out.println("拒绝（理由为空）→ 失败");
        }
        if(p4.reject("预算取消")){
            System.out.println("拒绝（理由：预算取消）→ 成功");
        }
        p4.printState();


        Project p5 = new Project(5, "测试取消项目", 1000);
        p5.apply(600);
        p5.approve(500);
        System.out.println("申请 600 → 批准 500");

        p5.printState();
        if(p5.cancel("不需要了")){
            System.out.println("取消（理由：不需要了）→ 成功");
        }
        p5.printState();

    }

}
