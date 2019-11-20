package com.rpc;

import org.apache.hadoop.ipc.VersionedProtocol;

public interface Bizble extends VersionedProtocol {
	static final long versionID = 76766166L;
	String hello(String name);
}
