package hello.core.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//import org.springframework.beans.factory.DisposableBean;
//import org.springframework.beans.factory.InitializingBean;
//implements InitializingBean, DisposableBean
public class NetworkClient {
    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    //서비스 시작 시 호출
    public void connect() {
        System.out.println("connect: " + url);
    }

    public void call(String message) {
        System.out.println("call: " + url + " message = " + message);
    }

    //서비스 종료 시 호출
    public void disconnect() {
        System.out.println("close: " + url);
    }

    @PostConstruct
    public void init() {
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메세지");
    }

    @PreDestroy
    public void close() {
        disconnect();
    }

    // 프로퍼티들이 세팅이 끝나면 (의존관계 주입이 끝나면) 호출해주겠다
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("NetworkClient.afterPropertiesSet");
//        connect();
//        call("초기화 연결 메세지");
//    }
    // 빈이 종료될때 호출
//    @Override
//    public void destroy() throws Exception {
//        disconnect();
//    }
}
