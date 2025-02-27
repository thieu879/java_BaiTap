public class Bt4 {
    public static void main(String[] args) {
        String[] names = {
                "Nguyễn Văn An", "Trần Thị Bích", "Lê Hoàng Nam", "Phạm Minh Đức",
                "Hoàng Lan Chi", "Đỗ Thùy Dương", "Bùi Thanh Tùng", "Vũ Hải Yến"
        };
        int[] ages = {20, 22, 19, 25, 21, 23, 24, 26};
        String[] countries = {
                "Việt Nam", "Nhật Bản", "Hàn Quốc", "Mỹ",
                "Anh", "Đức", "Pháp", "Canada"
        };

        System.out.println("+-----------------+------+-----------+");
        System.out.println("| Họ và Tên      | Tuổi | Quốc gia  |");
        System.out.println("+-----------------+------+-----------+");

        for (int i = 0; i < names.length; i++) {
            System.out.printf("| %-15s | %-4d | %-9s |\n", names[i], ages[i], countries[i]);
        }

        System.out.println("+-----------------+------+-----------+");
    }
}
