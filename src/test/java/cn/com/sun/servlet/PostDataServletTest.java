package cn.com.sun.servlet;

import cn.com.sun.commons.dto.ManagerPerson;
import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Hessian序列化调用测试类
 *
 * @author wangplcg
 * @create 2018-08-14 13:53
 */
public class PostDataServletTest {

    public static String urlName = "http://localhost:8080/hessianSerial";

    /**
     * 发送hessian请求测试
     *
     */
    @Test
    public void sendPost() throws IOException {
        // 序列化
        ManagerPerson managerPerson = new ManagerPerson();
        managerPerson.setAge((byte)20);
        managerPerson.setId("610321199612131814");
        managerPerson.setIdName("王沛林");
        managerPerson.setEmail("1173083839@qq.com");
        managerPerson.setCodeArea("1101111");

        // 序列化
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        Hessian2Output h2o = new Hessian2Output(os);

        h2o.startMessage();
        h2o.writeObject(managerPerson);
        h2o.writeString("I am client.");
        h2o.completeMessage();
        h2o.close();

        byte[] buffer = os.toByteArray();
        os.close();

        ByteArrayEntity byteArrayEntity = new ByteArrayEntity(buffer,
                ContentType.create("x-application/hessian", "UTF-8"));

        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(urlName);
        post.setEntity(byteArrayEntity);
        CloseableHttpResponse response = client.execute(post);

        System.out.println("response status:\n"
                + response.getStatusLine().getStatusCode());
        HttpEntity body = response.getEntity();
        InputStream is = body.getContent();
        Hessian2Input h2i = new Hessian2Input(is);
        h2i.startMessage();

        ManagerPerson person2 = (ManagerPerson) h2i.readObject();
        System.out.println("response:\n" + person2.toString());
        System.out.println(h2i.readString());

        h2i.completeMessage();
        h2i.close();
        is.close();
    }
}
