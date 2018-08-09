package service.impl;

import mapper.wscl.IWsInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.IWsInfoService;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Think
 * Date: 2018-08-09
 * Time: 23:12
 */
@Service
public class WsInfoServiceImpl implements IWsInfoService {

    @Autowired
    IWsInfoMapper wsInfoMapper;

    public Map<String, String> getWsInfo(String sqxh) {
        return wsInfoMapper.getWssqBySqxh(sqxh);
    }
}
