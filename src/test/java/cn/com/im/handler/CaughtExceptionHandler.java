package cn.com.im.handler;

import cn.com.im.entity.ExceptionPacket;
import cn.com.im.execption.IMBusinessException;
import cn.com.im.execption.IMSysException;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Description:
 * User: wangpl
 * Date: 2019-08-12
 * Time: 17:04
 */

public class CaughtExceptionHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ExceptionPacket exceptionPacket = new ExceptionPacket();
        cause.printStackTrace();
        if (cause instanceof IMSysException) {
            IMSysException exception = (IMSysException)cause;
            exceptionPacket.setMsg(exception.getMessage());
            exceptionPacket.setType(0);
            System.out.println("系统出现异常" +  cause.getMessage());
        } else if (cause instanceof IMBusinessException) {
            IMBusinessException exception = (IMBusinessException)cause;
            exceptionPacket.setMsg(exception.getMessage());
            exceptionPacket.setMsgCode(exception.getMsgCode());
            exceptionPacket.setType(1);
            System.out.println("系统出现异常" +  cause.getMessage());
        } else {
            exceptionPacket.setMsg(cause.getMessage());
            exceptionPacket.setMsgCode(9999);
            exceptionPacket.setType(9);
            System.out.println("系统出现异常" +  cause.getMessage());
        }
        ctx.channel().writeAndFlush(exceptionPacket);
    }
}