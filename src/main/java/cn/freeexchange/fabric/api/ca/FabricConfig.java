package cn.freeexchange.fabric.api.ca;

import java.io.File;

import org.apache.log4j.Logger;

import cn.freeexchange.fabric.api.chaincode.Chaincode;
import cn.freeexchange.fabric.api.component.Orderers;
import cn.freeexchange.fabric.api.component.Peers;
import cn.freeexchange.fabric.api.utils.ChaincodeManager;

public class FabricConfig {

    private static Logger log = Logger.getLogger(FabricConfig.class);

    /** 节点服务器对象 */
    private Peers peers;
    /** 排序服务器对象 */
    private Orderers orderers;
    /** 智能合约对象 */
    private Chaincode chaincode;
    /** channel-artifacts所在路径：默认channel-artifacts所在路径/xxx/WEB-INF/classes/fabric/channel-artifacts/ */
    private String channelArtifactsPath;
    /** crypto-config所在路径：默认crypto-config所在路径/xxx/WEB-INF/classes/fabric/crypto-config/ */
    private String cryptoConfigPath;
    private boolean registerEvent = false;

    public FabricConfig() {
        cryptoConfigPath = getChannlePath() + "/crypto-config/";
    }

    /**
     * 默认fabric配置路径
     */
    private String getChannlePath() {
        String directorys = ChaincodeManager.class.getClassLoader().getResource("fabric").getFile();
        log.debug("directorys = " + directorys);
        File directory = new File(directorys);
        log.debug("directory = " + directory.getPath());

        return directory.getPath();
    }

    public Peers getPeers() {
        return peers;
    }

    public void setPeers(Peers peers) {
        this.peers = peers;
    }

    public Orderers getOrderers() {
        return orderers;
    }

    public void setOrderers(Orderers orderers) {
        this.orderers = orderers;
    }

    public Chaincode getChaincode() {
        return chaincode;
    }

    public void setChaincode(Chaincode chaincode) {
        this.chaincode = chaincode;
    }

    public String getCryptoConfigPath() {
        return cryptoConfigPath;
    }

    public void setCryptoConfigPath(String cryptoConfigPath) {
        this.cryptoConfigPath = cryptoConfigPath;
    }

    public boolean isRegisterEvent() {
        return registerEvent;
    }

    public void setRegisterEvent(boolean registerEvent) {
        this.registerEvent = registerEvent;
    }

	public String getChannelArtifactsPath() {
		return channelArtifactsPath;
	}

	public void setChannelArtifactsPath(String channelArtifactsPath) {
		this.channelArtifactsPath = channelArtifactsPath;
	}

}