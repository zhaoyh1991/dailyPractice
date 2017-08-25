package server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Created by zhaoyh on 2017/8/20.
 */
public class EchoServer {
    private final int port;

    public EchoServer(int port) {
        this.port = port;
    }
    private void start() {
        EventLoopGroup group=new NioEventLoopGroup();
        try {
        ServerBootstrap bootstrap=new ServerBootstrap();
        bootstrap.group(group).channel(NioServerSocketChannel.class).localAddress(port).childHandler(
                new ChannelInitializer<SocketChannel>() {
                    protected void initChannel(SocketChannel channel) throws Exception {
                        channel.pipeline().addLast(new EchoServerHandler());
                    }
                }
        );

          ChannelFuture channelFuture= bootstrap.bind().sync();
          channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            try {
                group.shutdownGracefully().sync();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
     new EchoServer(20000).start();
    }

}
