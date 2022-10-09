import java.util.Collections;
import java.util.List;

public class empyList {

//    * Collections.emptyList()
//
//    빈 리스트를 넘겨줄때는  매번 new 로 새로 생성하기보다 되도록이면 Collections.emptyList() 사용하기.
//
//            아래처럼, static final이라서 매번 생성 안됨. 메모리 절약
//    https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=kbh3983&logNo=221514873885

    public static final List EMPTY_LIST = Collections.emptyList();
    public static final <T> List<T> emptyList() {
        return (List<T>) EMPTY_LIST;
    }
}
