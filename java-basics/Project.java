public class Project {
    int id;
    String name;
    int total;
    int frozen;
    int used;

    public Project(int id, String name, int total) {
        this.id = id;
        this.name = name;
        this.total = total;
        this.frozen = 0;
        this.used = 0;
    }

    int available() {
        return total - frozen - used;   
    }

    void printState() {
        System.out.println("可用 " + available() + " | 冻结 " + frozen + " | 已使用 " + used);
    }

    boolean apply(int amount) {
        if (amount <= 0) {
            return false;
        }

        if (amount > available()) {
            return false;
        }

        frozen = frozen + amount;
        return true;
    }
    
}