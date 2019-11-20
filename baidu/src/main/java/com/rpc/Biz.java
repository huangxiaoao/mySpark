package com.rpc;

import java.io.IOException;

import org.apache.hadoop.ipc.ProtocolSignature;

public class Biz implements Bizble {

	public long getProtocolVersion(String protocol, long clientVersion) throws IOException {
		return versionID;
	}

	public ProtocolSignature getProtocolSignature(String protocol, long clientVersion, int clientMethodsHash)
			throws IOException {
		return new ProtocolSignature();
	}

	public String hello(String name) {
		return "hello"+name;
	}

}
