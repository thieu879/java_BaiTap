package Bt6;

public class TestMoveablePoint {
    public static void main(String[] args) {
        MoveablePoint moveablePoint = new MoveablePoint(1,2,1,2);
        System.out.println(moveablePoint.toString());
        moveablePoint.move();
        System.out.println("Sau khi di chuyển: "+moveablePoint.toString());
        moveablePoint.setxSpeed(2);
        moveablePoint.setySpeed(1);
        moveablePoint.move();
        System.out.println("Sau khi thay đổi tốc độ di chuyển: "+moveablePoint.toString());
    }
}
