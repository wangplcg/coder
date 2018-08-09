package cn.com.core.condition;

/**
 * Linux 环境类
 *
 * @author wangplcg
 * @create 2018-04-18 22:02
 */

public class LinuxListService implements ListService {
    public String showListCmd() {
        return "ls";
    }
}
