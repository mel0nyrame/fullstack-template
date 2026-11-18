public class Project {
    int id;
    String name;
    int total;
    int frozen;
    int used;
    State state;

    public Project(int id, String name, int total) {
        this.id = id;
        this.name = name;
        this.total = total;
        this.state = State.DRAFT;
        this.frozen = 0;
        this.used = 0;
    }

    int available() {
        return total - frozen - used;   
    }

    void printState() {
        System.out.println("状态 " + state + " | 可用 " + available() + " | 冻结 " + frozen + " | 已使用 " + used);
    }

    boolean apply(int amount) {
        if (state != State.DRAFT) {
            return false;
        }
        if (amount <= 0) {
            return false;
        }

        if (amount > available()) {
            return false;
        }

        frozen = frozen + amount;
        state = State.PENDING_L1;
        return true;
    }

    boolean approve(int amount) {
        if (state != State.PENDING_L1) {
            return false;
        }
        if (amount <= 0 || amount > frozen) {
            return false;
        }
        frozen = amount;
        state = State.APPROVED;
        return true;
    }

    boolean settle(int actual) {
        if (state != State.APPROVED) {
            return false;
        }
        if (actual < 0 || actual > frozen) {
            return false;
        }
        used += actual;
        frozen = 0;
        state = State.SETTLED;
        return true;
    }
}