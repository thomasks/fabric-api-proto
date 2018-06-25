package cn.freeexchange.fabric.api.component;

/**
 * 节点服务器对象
 * */
public class Peer {
	
	//当前指定的组织节点域名
	private String peerName;	//peer0.org1.example.com
	
	//当前指定的组织节点事件域名
	private String peerEventHubName;	//peer0.org1.example.com
	
	//当前指定的组织节点访问地址
	private String peerLocation;		//grpcs://110.131.116.21:7051
	
	//当前指定的组织节点事件监听访问地址
	private String peerEventHubLocation;	//grpcs://110.131.116.21:7053
	
	//当前指定的组织节点ca访问地址
	private String caLocation;		// http://110.131.116.21:7054
	
	//当前peer是否增加Event事件处理 
	private boolean addEventHub = false;
	
	//当前节点的路径
	private String peerLocalDir;

	public Peer(String peerName, String peerEventHubName, String peerLocation, String peerEventHubLocation,
			String caLocation,String peerLocalDir) {
		this.peerName = peerName;
		this.peerEventHubName = peerEventHubName;
		this.peerLocation = peerLocation;
		this.peerEventHubLocation = peerEventHubLocation;
		this.caLocation = caLocation;
		this.peerLocalDir = peerLocalDir;
	}

	public String getPeerName() {
		return peerName;
	}

	public void setPeerName(String peerName) {
		this.peerName = peerName;
	}

	public String getPeerEventHubName() {
		return peerEventHubName;
	}

	public void setPeerEventHubName(String peerEventHubName) {
		this.peerEventHubName = peerEventHubName;
	}

	public String getPeerLocation() {
		return peerLocation;
	}

	public void setPeerLocation(String peerLocation) {
		this.peerLocation = peerLocation;
	}

	public String getPeerEventHubLocation() {
		return peerEventHubLocation;
	}

	public void setPeerEventHubLocation(String peerEventHubLocation) {
		this.peerEventHubLocation = peerEventHubLocation;
	}

	public String getCaLocation() {
		return caLocation;
	}

	public void setCaLocation(String caLocation) {
		this.caLocation = caLocation;
	}

	public boolean isAddEventHub() {
		return addEventHub;
	}

	 public void addEventHub(boolean addEventHub) {
		 this.addEventHub = addEventHub;
	 }

	public String getPeerLocalDir() {
		return peerLocalDir;
	}

	public void setPeerLocalDir(String peerLocalDir) {
		this.peerLocalDir = peerLocalDir;
	}
	
}
