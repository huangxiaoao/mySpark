package com.rpc;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;
import org.apache.hadoop.ipc.RPC.Builder;
import org.apache.hadoop.ipc.RPC.Server;

public class MyService {
	public static void main(String[] args) throws Exception, Exception {
		
		Configuration conf = new Configuration();
		Builder builder = new RPC.Builder(conf);
		builder.setBindAddress("localhost").setPort(6666).setProtocol(Bizble.class).setInstance(new Biz());
		Server server = builder.build();
		server.start();
		System.out.println("服务器启动了");
	}
}
