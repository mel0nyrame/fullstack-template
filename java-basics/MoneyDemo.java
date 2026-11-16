public class MoneyDemo {
    public static void main(String[] args) {
        int total = 1000;
        int available = 1000;
        int frozen = 0;
        int used = 0;
        System.out.println("可用 " + available + "  冻结 " + frozen + "  已使用 " + used);
        frozen = 600;
        available = total - frozen - used;
        System.out.println("提交 600 → 可用 " + available + "  冻结 " + frozen + "  已使用 " + used);
        frozen = 500;
        available = total - frozen - used;
        System.out.println("提交 500 → 可用 " + available + "  冻结 " + frozen + "  已使用 " + used);
        frozen = 0;
        used = 460;
        available = total - frozen - used;
        System.out.println("提交 460 → 可用 " + available + "  冻结 " + frozen + "  已使用 " + used);
        if (total == available + frozen + used) {
        System.out.println("守恒 ✅");
} else {
        System.out.println("守恒 ❌");
}

    }
}