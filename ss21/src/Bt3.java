public class Bt3 {
    public static void main(String[] args) {
        try{
            checkAge(15);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("Bye bye");
        }
    }
    public static void checkAge(int age) {
        if(age < 18) {
            throw new IllegalArgumentException("Bạn chưa đủ 18 tuổi!");
        }
        System.out.println("Chào mừng bạn!");
    }
}
