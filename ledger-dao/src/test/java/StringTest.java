import org.junit.Test;

/**
 * @description:
 * @author: pengzhen@cmhit.com
 * @create: 2019-12-07 10:08
 **/
public class StringTest {

    @Test
    public void test(){
        String a = "service.sys.impl";
        String b=a.replace(".","/");
        System.out.println(b);
    }
}
