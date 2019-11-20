package com.rpc;

import java.net.InetSocketAddress;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

public class Myclient {
	public static void main(String[] args) throws Exception {
		InetSocketAddress addr = new InetSocketAddress("localhost", 6666);
		Configuration conf = new Configuration();
		Bizble proxy = RPC.getProxy(Bizble.class, Bizble.versionID, addr, conf);
		String result = proxy.hello("黄老师");
		
		System.out.println("客户端的信息是:"+result);
	}
}
