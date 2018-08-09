package mapper.wscl;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Think
 * Date: 2018-08-09
 * Time: 22:54
 */

public interface IWsInfoMapper {
    /**
     * 获取文书申请情况信息
     */
    Map<String, String> getWssqBySqxh(String sqxh);
}