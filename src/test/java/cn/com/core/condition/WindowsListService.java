package cn.com.core.condition;

/**
 * Windows 环境类
 *
 * @author wangplcg
 * @create 2018-04-18 22:01
 */

public class WindowsListService implements ListService {
    public String showListCmd() {
        return "dir";
    }
}
