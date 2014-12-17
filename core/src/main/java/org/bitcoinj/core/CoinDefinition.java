package org.bitcoinj.core;

import java.math.BigInteger;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: HashEngineering
 * Date: 8/13/13
 * Time: 7:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class CoinDefinition {


    public static final String coinName = "GroestlCoin";
    public static final String coinTicker = "GRS";
    public static final String coinURIScheme = "groestlcoin";
    public static final String cryptsyMarketId = "26";
    public static final String cryptsyMarketCurrency = "BTC";
    public static final String PATTERN_PRIVATE_KEY_START = "[56]";
    public static final String PATTERN_PRIVATE_KEY_START_COMPRESSED = "[KL]";
    public static final String PATTERN_PRIVATE_KEY_START_TESTNET = "9";
    public static final String PATTERN_PRIVATE_KEY_START_COMPRESSED_TESTNET = "c";

    public static String lowerCaseCoinName() { return coinName.toLowerCase(); }

    public enum CoinPrecision {
        Coins,
        Millicoins,
    }
    public static final CoinPrecision coinPrecision = CoinPrecision.Coins;


    public static final String BLOCKEXPLORER_BASE_URL_PROD = "https://chainz.cryptoid.info/grs/";    //blockr.io
    public static final String BLOCKEXPLORER_ADDRESS_PATH = "address.dws?";             //blockr.io path
    public static final String BLOCKEXPLORER_TRANSACTION_PATH = "tx.dws?";              //blockr.io path
    public static final String BLOCKEXPLORER_BLOCK_PATH = "block.dws?";                 //blockr.io path
    public static final String BLOCKEXPLORER_BASE_URL_TEST = BLOCKEXPLORER_BASE_URL_PROD;

    public static final String DONATION_ADDRESS = "FkknEYnex1MeZyPRnEebFK5ZBHHsFZbvaf";  //HashEngineering donation DGC address

    public static final String UNSPENT_API_URL = "http://dgc.blockr.io/api/v1/address/unspent/";
    public enum UnspentAPIType {
        BitEasy,
        Blockr,
        Abe
    };
    public static final UnspentAPIType UnspentAPI = UnspentAPIType.Blockr;

    enum CoinHash {
        SHA256,
        scrypt,
        other,
    };
    public static final CoinHash coinPOWHash = CoinHash.other;

    public static boolean checkpointFileSupport = true;
    public static int checkpointDaysBack = 21;

    public static final int TARGET_TIMESPAN = (int)(86400);  // 1 day per difficulty cycle, on average.
    public static final int TARGET_SPACING = (int)(1 * 60);  // 60 seconds per block.
    public static final int INTERVAL = TARGET_TIMESPAN / TARGET_SPACING;  //108 blocks

    public static final int getInterval(int height, boolean testNet) {
            return INTERVAL;      //108
    }
    public static final int getIntervalCheckpoints() {
            return 2016;    //1080

    }
    public static final int getTargetTimespan(int height, boolean testNet) {
            return TARGET_TIMESPAN;    //72 min
    }
    public static int getMaxTimeSpan(int value, int height, boolean testNet)
    {
            return value * 75 / 60;
    }
    public static int getMinTimeSpan(int value, int height, boolean testNet)
    {
            return value * 55 / 73;
    }
    public static int spendableCoinbaseDepth = 120; //main.h: static const int CINBASE_MATURITY
    public static final int MAX_COINS = 105000000;                 //main.h:  MAX_MONEY


    public static final Coin DEFAULT_MIN_TX_FEE = Coin.valueOf(10000);   // MIN_TX_FEE
    public static final Coin DUST_LIMIT = Coin.valueOf(10000); //main.h CTransaction::GetMinFee        0.01 coins

    public static final int PROTOCOL_VERSION = 70001;          //version.h PROTOCOL_VERSION
    public static final int MIN_PROTOCOL_VERSION = 209;        //version.h MIN_PROTO_VERSION
    public static final int INIT_PROTO_VERSION = 209;            //version.h

    public static final int BLOCK_CURRENTVERSION = 112;   //CBlock::CURRENT_VERSION
    public static final int MAX_BLOCK_SIZE = 1 * 1000 * 1000;


    public static final boolean supportsBloomFiltering = false; //Requires PROTOCOL_VERSION 70000 in the client
    public static boolean supportsIrcDiscovery() {
        return PROTOCOL_VERSION <= 70000;
    }

    public static final int Port    = 1331;       //protocol.h GetDefaultPort(testnet=false)
    public static final int TestPort = 17777;     //protocol.h GetDefaultPort(testnet=true)

    //
    //  Production
    //
    public static final int AddressHeader = 36;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS
    public static final int p2shHeader = 5;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS
    public static final boolean allowBitcoinPrivateKey = false; //for backward compatibility with previous version of digitalcoin
    public static final long PacketMagic = 0xf9beb4d4;      //0xf9, 0xbe, 0xb4, 0xd4

    //Genesis Block Information from main.cpp: LoadBlockIndex
    static public long genesisBlockDifficultyTarget = (0x1e0fffffL);         //main.cpp: LoadBlockIndex
    static public long genesisBlockTime = 1395342829L;                       //main.cpp: LoadBlockIndex
    static public long genesisBlockNonce = (220035);                         //main.cpp: LoadBlockIndex
    static public String genesisHash = "00000ac5927c594d49cc0bdb81759d0da8297eb614683d3acb62f0703b639023"; //main.cpp: hashGenesisBlock
    static public int genesisBlockValue = 0;
    static public int genesisBlockVersion = 112; //main.cpp: LoadBlockIndex
    //taken from the raw data of the block explorer

    static public String genesisTxInBytes = "04ffff001d0104325072657373757265206d75737420626520707574206f6e20566c6164696d697220507574696e206f766572204372696d6561";   //"Digitalcoin, A Currency for a Digital Age"
    static public String genesisTxOutBytes = "04678afdb0fe5548271967f1a67130b7105cd6a828e03909a67962e0ea1f61deb649f6bc3f4cef38c4f35504e51ec112de5c384df7ba0b8d578a4c702b6bf11d5f";



    static public String genesisMerkleRoot = "3ce968df58f9c8a752306c4b7264afab93149dbc578bd08a42c446caaa6628bb";


     // "Pressure must be put on Vladimir Putin over Crimea"


    //net.cpp strDNSSeed
    static public String[] dnsSeeds = new String[] {
            "groestlcoin.net",
    "groestlcoin.org",
            "193.136.98.184",
            "88.198.69.99"

    };

    public static int minBroadcastConnections = 1;   //0 for default; we need more peers.

    //
    // TestNet
    //
    public static final boolean supportsTestNet = true;
    public static final int testnetAddressHeader = 111;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS_TEST
    public static final int testnetp2shHeader = 196;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS_TEST
    public static final long testnetPacketMagic = 0x0b110907;      //0xfc, 0xc1, 0xb7, 0xdc
    public static final String testnetGenesisHash = "0x00000b94ee7f94431dad6f1c72cabc18b6923a4fa648be1002938874deb4a265";
    static public long testnetGenesisBlockDifficultyTarget = (0x1e0ffff0L);         //main.cpp: LoadBlockIndex
    static public long testnetGenesisBlockTime = 1395342913L;                       //main.cpp: LoadBlockIndex
    static public long testnetGenesisBlockNonce = (873629);                         //main.cpp: LoadBlockIndex

    //main.cpp GetBlockValue(height, fee)
    public static final Coin GetBlockReward(int height)
    {
        int COIN = 1;
        Coin nSubsidy = Coin.valueOf(15, 0);



            //return nSubsidy.shiftRight(height / subsidyDecreaseBlockCount);
        return nSubsidy;
    }

    public static int subsidyDecreaseBlockCount = 4730400;     //main.cpp GetBlockValue(height, fee)

    public static BigInteger proofOfWorkLimit = Utils.decodeCompactBits(0x1e0fffffL);  //main.cpp bnProofOfWorkLimit (~uint256(0) >> 20); // digitalcoin: starting difficulty is 1 / 2^12

    public static BigInteger [] proofOfWorkLimits = new BigInteger[] {
            proofOfWorkLimit,proofOfWorkLimit,proofOfWorkLimit,proofOfWorkLimit,proofOfWorkLimit };

    public static BigInteger getProofOfWorkLimit(int algo)
    {
        return proofOfWorkLimits[algo];
    }

    static public String[] testnetDnsSeeds = new String[] {
          "not supported"
    };
    //from main.h: CAlert::CheckSignature
    public static final String SATOSHI_KEY = "04fc9702847840aaf195de8442ebecedf5b095cdbb9bc716bda9110971b28a49e0ead8564ff0db22209e0374782c093bb899692d524e9d6a6956e7c5ecbcd68284";
    public static final String TESTNET_SATOSHI_KEY = "04302390343f91cc401d56d68b123028bf52e5fca1939df127f63c6467cdf9c8e2c14b61104cf817d0b780da337893ecc4aaff1309e536162dabbdb45200ca2b0a";

    /** The string returned by getId() for the main, production network where people trade things. */
    public static final String ID_MAINNET = "org.groestlcoin.production";
    /** The string returned by getId() for the testnet. */
    public static final String ID_TESTNET = "org.groestlcoin.test";
    /** Unit test network. */
    public static final String ID_UNITTESTNET = "com.google.groestlcoin.unittest";

    //checkpoints.cpp Checkpoints::mapCheckpoints
    public static void initCheckpoints(Map<Integer, Sha256Hash> checkpoints)
    {
        checkpoints.put( 0, new Sha256Hash(CoinDefinition.genesisHash));
        checkpoints.put( 28888, new Sha256Hash("00000000000228ce19f55cf0c45e04c7aa5a6a873ed23902b3654c3c49884502"));
        checkpoints.put( 58888, new Sha256Hash("0000000000dd85f4d5471febeb174a3f3f1598ab0af6616e9f266b56272274ef"));
        checkpoints.put(111111, new Sha256Hash("00000000013de206275ee83f93bee57622335e422acbf126a37020484c6e113c"));
    }

    //Unit Test Information
    public static final String UNITTEST_ADDRESS = "FmpNNw388tMqsDkKW6KfyksRkCVWqjBSCe";
    public static final String UNITTEST_ADDRESS_PRIVATE_KEY = "QU1rjHbrdJonVUgjT7Mncw7PEyPv3fMPvaGXp9EHDs1uzdJ98hUZ";

}
