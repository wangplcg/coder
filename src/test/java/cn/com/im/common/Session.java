package cn.com.im.common;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Description:
 * User: wangpl
 * Date: 2019-08-12
 * Time: 22:10
 */
@Data
@AllArgsConstructor
public class Session {

    private String userId;

    private String userName;

}