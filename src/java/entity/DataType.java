package entity;

import com.grpc.serverstream.IP;
import com.grpc.serverstream.Name;

public class DataType {
	private Name name;
	private IP ip;
	
	public DataType(Name name, IP ip) {
		super();
		this.name = name;
		this.ip = ip;
	}
	public Name getName() {
		return name;
	}
	public void setName(Name name) {
		this.name = name;
	}
	public IP getIp() {
		return ip;
	}
	public void setIp(IP ip) {
		this.ip = ip;
	}
	
}
