package cn.com.sun.servlet;

import cn.com.sun.commons.dto.ManagerPerson;
import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Hessian 测试接收对象
 *
 * @author wangplcg
 * @create 2018-08-14 13:40
 */

@Slf4j
public class PostDataServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // 处理请求
        ServletInputStream sis = req.getInputStream();
        Hessian2Input h2i = new Hessian2Input(sis);

        h2i.startMessage();
        ManagerPerson person = (ManagerPerson) h2i.readObject();
        log.debug("receive:\n" + person.toString());
        log.debug(h2i.readString());
        h2i.completeMessage();
        h2i.close();
        sis.close();

        ManagerPerson managerPerson = new ManagerPerson();
        managerPerson.setAge((byte)20);
        managerPerson.setId("610321199612131814");
        managerPerson.setIdName("王沛林");
        managerPerson.setEmail("1173083839@qq.com");
        managerPerson.setCodeArea("1101111");

        // 发送响应
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("x-application/hessian");

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        Hessian2Output h2o = new Hessian2Output(bos);

        h2o.startMessage();
        h2o.writeObject(managerPerson);
        h2o.writeString("I am server.");
        h2o.completeMessage();
        h2o.close();

        ServletOutputStream sos = resp.getOutputStream();
        sos.write(bos.toByteArray());
        sos.flush();
        bos.close();
        sos.close();
    }

}
