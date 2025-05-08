package module5;
@SuppressWarnings({"deprecation"})
public class Demo1_AnnotionDemo {

    public static void main(String[] args) {
        NormalClass nc = new NormalClass();

        // 能正常使用，但是不推荐
        nc.test();
    }

}


class NormalClass {

    @Deprecated
    private int i;

    // 标记这个方法已经过时了，不建议使用，在未来的新版本发布的时候，可能会删除这个方法
    @Deprecated
    public void test(){
        System.out.println("test");
    }
}
