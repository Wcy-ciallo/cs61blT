public class TriangleDrawer {
    public static void drawTriangle() {
        int SIZE = 5;
        int col = 1;
        while(col <= SIZE) {
            int i = 1;
            while(i <= col) {
                System.out.print('*');
                i++;
            }
            col++;
            System.out.println();
        }
        

    }

    public static void main(String[] args) {
        drawTriangle();
    }
}
