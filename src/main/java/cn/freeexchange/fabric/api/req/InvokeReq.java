package cn.freeexchange.fabric.api.req;

import java.util.List;

public class InvokeReq {
	
	private String action;
	private String affiliation; //联盟
	private List<PeerIdentity> peers;	//endorse peer location
	
	private String chaincode;		//chaincode name
	private String channel;			//channel
	
	private String funcName;		//funcName
	
	private String[] args;			//func args

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getAffiliation() {
		return affiliation;
	}

	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}

	public List<PeerIdentity> getPeers() {
		return peers;
	}

	public void setPeers(List<PeerIdentity> peers) {
		this.peers = peers;
	}

	public String getChaincode() {
		return chaincode;
	}

	public void setChaincode(String chaincode) {
		this.chaincode = chaincode;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getFuncName() {
		return funcName;
	}

	public void setFuncName(String funcName) {
		this.funcName = funcName;
	}

	public String[] getArgs() {
		return args;
	}

	public void setArgs(String[] args) {
		this.args = args;
	}

}
