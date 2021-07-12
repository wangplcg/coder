package cn.com;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * @Classname MatrixTest
 * @Description TODO
 * @Date 2021/6/13 23:46
 * @Created by think
 */
public class MatrixTest {

    private static int boxX = 1;
    private static int boxY = 0;

    public static void main(String[] args) {
        routes(0, 0, Lists.newArrayList());
    }

    public static void routes(int x, int y, List<String> routes) {
        if (boxX == x && y == boxY) {
            return;
        }
        if ((x > 5 || y > 4) || (x < 0 || y < 0)) {
            return;
        }
        String index = x + "#" + y;
        if (routes.contains(index)) {
            return;
        }
        routes.add(index);
        if (routes.size() == 29) {
            System.out.println(JSONObject.toJSON(routes));
        }
        routes(x + 1, y, Lists.newArrayList(routes));
        routes(x, y + 1, Lists.newArrayList(routes));
        routes(x - 1, y, Lists.newArrayList(routes));
        routes(x, y - 1, Lists.newArrayList(routes));
    }
}
