package Day26Lecture;

public class MemberClass {
    private final String secret = "Not showing";
    // less than private more than protected
    String s = "Showing";

    class innerclass {
        String s = "inside in mc s";

        public void show() {
            System.out.println("member class");
            System.out.println(secret);

            // member class s show up
            System.out.println(s);

            // big class s show up
            System.out.println(MemberClass.this.s);
        }

    }

    public static void main(String[] args) {
        MemberClass m = new MemberClass();
        innerclass m1 = m.new innerclass();

        System.out.println(m1.s);
        m1.show();
    }
}
