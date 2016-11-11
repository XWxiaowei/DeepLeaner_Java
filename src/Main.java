public class Main {

    public static void main(String[] args) {
       // System.out.println("Hello World!");
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("hello");
        stringBuilder.append("word");
        stringBuilder.append("danfeng");
        stringBuilder.append("wo lai al");
        int d=stringBuilder.length();
        String s=stringBuilder.delete(d-2,d).toString();
        System.out.println("hshsh");
    }
}
