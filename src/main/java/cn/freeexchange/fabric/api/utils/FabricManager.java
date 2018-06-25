package cn.freeexchange.fabric.api.utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.InvalidKeySpecException;

import org.apache.log4j.Logger;
import org.hyperledger.fabric.sdk.exception.CryptoException;
import org.hyperledger.fabric.sdk.exception.InvalidArgumentException;
import org.hyperledger.fabric.sdk.exception.TransactionException;

import cn.freeexchange.fabric.api.ca.FabricConfig;
import cn.freeexchange.fabric.api.chaincode.Chaincode;
import cn.freeexchange.fabric.api.component.Orderers;
import cn.freeexchange.fabric.api.component.Peers;

public class FabricManager {
	
	private static Logger log = Logger.getLogger(FabricManager.class);

    private ChaincodeManager manager;

    private static FabricManager instance = null;

    public static FabricManager obtain()
            throws CryptoException, InvalidArgumentException, NoSuchAlgorithmException,
            NoSuchProviderException, InvalidKeySpecException, TransactionException, 
            IOException, IllegalAccessException, InstantiationException, ClassNotFoundException,
            NoSuchMethodException, InvocationTargetException {
        if (null == instance) {
            synchronized (FabricManager.class) {
                if (null == instance) {
                    instance = new FabricManager();
                }
            }
        }
        return instance;
    }

    private FabricManager()
            throws CryptoException, InvalidArgumentException, NoSuchAlgorithmException,
            NoSuchProviderException, InvalidKeySpecException, TransactionException,
            IOException, IllegalAccessException, InstantiationException, ClassNotFoundException,
            NoSuchMethodException, InvocationTargetException {
        manager = new ChaincodeManager(getConfig());
    }

    /**
     * 获取节点服务器管理器
     * 
     * @return 节点服务器管理器
     */
    public ChaincodeManager getManager() {
        return manager;
    }

    /**
     * 根据节点作用类型获取节点服务器配置
     * 
     * @param type
     *            服务器作用类型（1、执行；2、查询）
     * @return 节点服务器配置
     */
    private FabricConfig getConfig() {
        FabricConfig config = new FabricConfig();
        config.setOrderers(getOrderers());
        config.setPeers(getPeers());
        config.setChaincode(
        		getChaincode("mychannel", "simple",
        				"github.com/lijiaocn/fabric-chaincode-example/demo", "1.0"));
        config.setChannelArtifactsPath(getChannleArtifactsPath());
        config.setCryptoConfigPath(getCryptoConfigPath());
        return config;
    }

    private Orderers getOrderers() {
        Orderers orderer = new Orderers();
        orderer.setOrdererDomainName("freeexchange.cn");
        orderer.addOrderer("orderer.freeexchange.cn", "grpcs://orderer.freeexchange.cn:7050","orderer");
        return orderer;
    }

    /**
     * 获取节点服务器集
     * 
     * @return 节点服务器集
     */
    private Peers getPeers() {
        Peers peers = new Peers();
        peers.setOrgName("Org1");
        peers.setOrgMSPID("Org1MSP");
        peers.setOrgDomainName("org1.freeexchange.cn");
        peers.addPeer("peer0.org1.freeexchange.cn", "peer0.org1.freeexchange.cn",
        		"grpcs://peer0.org1.freeexchange.cn:7051", "grpcs://peer0.org1.freeexchange.cn:7053", 
        		"http://fabricca.freeexchange.cn:7054","peer0");
        return peers;
    }

    /**
     * 获取智能合约
     * 
     * @param channelName
     *            频道名称
     * @param chaincodeName
     *            智能合约名称
     * @param chaincodePath
     *            智能合约路径
     * @param chaincodeVersion
     *            智能合约版本
     * @return 智能合约
     */
    private Chaincode getChaincode(String channelName, String chaincodeName, String chaincodePath, String chaincodeVersion) {
        Chaincode chaincode = new Chaincode();
        chaincode.setChannelName(channelName);
        chaincode.setChaincodeName(chaincodeName);
        chaincode.setChaincodePath(chaincodePath);
        chaincode.setChaincodeVersion(chaincodeVersion);
        chaincode.setInvokeWatiTime(100000);
        chaincode.setDeployWatiTime(120000);
        return chaincode;
    }

    /**
     * 获取channel-artifacts配置路径
     * 
     * @return /WEB-INF/classes/fabric/channel-artifacts/
     */
    private String getChannleArtifactsPath() {
        String directorys = FabricManager.class.getClassLoader().getResource("fabric").getFile();
        log.debug("directorys = " + directorys);
        File directory = new File(directorys);
        log.debug("directory = " + directory.getPath());

        return directory.getPath() + "/channel-artifacts/";
    }

    /**
     * 获取crypto-config配置路径
     * 
     * @return /WEB-INF/classes/fabric/crypto-config/
     */
    private String getCryptoConfigPath() {
        String directorys = FabricManager.class.getClassLoader().getResource("fabric").getFile();
        log.debug("directorys = " + directorys);
        File directory = new File(directorys);
        log.debug("directory = " + directory.getPath());

        return directory.getPath() + "/crypto-config/";
    }

}
