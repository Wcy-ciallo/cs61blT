public class TriangleDrawer2 {
    public static void drawTriangle() {
        int SIZE = 5;
        for(int i = 1; i <= SIZE; i++) {
            for(int j = 1; j <= i; j++) {
                System.out.print('*');
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        drawTriangle();
    }
}
