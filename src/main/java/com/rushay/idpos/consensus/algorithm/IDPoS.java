package com.rushay.idpos.consensus.algorithm;

import com.rushay.idpos.consensus.CommitMessage;
import com.rushay.idpos.consensus.ConsensusMessage;
import com.rushay.idpos.consensus.ConsensusMessageType;
import com.rushay.idpos.consensus.PrepareMessage;
import com.rushay.idpos.data.Block;
import com.rushay.idpos.data.BlockChain;
import com.rushay.idpos.network.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * 对DPOS进行改进，添加PBFT的共识步骤
 * Created by ylf on 2018/11/26.
 */
public class IDPoS {

    public static final int PBFT_N = 21;
    public static final int PBFT_F = (PBFT_N - 1) / 3;
    BlockChain blockChain;
    Node node;
    Map<String, Block> pendingBlocks = new HashMap<>();
    State state = State.NONE;
    CommitMessage commitMessage;
    PrepareMessage prepareMessage;
    Map<String, CommitMessage> commitHashCache = new HashMap<>();
    Map<String, PrepareMessage> prepareHashCache = new HashMap<>();

    public IDPoS(BlockChain blockChain, Node node) {
        this.blockChain = blockChain;
        this.node = node;
    }

    public boolean hasBlock(String hash) {
        return pendingBlocks.get(hash) != null;
    }

    public boolean isBusy() {
        return this.state == State.NONE;
    }

    public boolean addBlock(Block block, int view) {
        return true;
    }

    public void clearState() {
        this.state = State.NONE;
        this.prepareMessage = null;
        this.commitMessage = null;
        this.pendingBlocks.clear();
    }

    public void commit(String hash) {
        Block block = pendingBlocks.get(hash);
        if (block == null) {
            System.out.println("ERROR:不能提交空区块");
            return;
        }
    }

    public void processMessage(ConsensusMessage message) {
        switch (message.getMessageType()) {
            case PREPARE :
                processPrepareMessage(message);
                break;

            case COMMIT:
                processCommitMessage(message);
                break;

            default:
                break;
        }
    }

    private void processPrepareMessage(ConsensusMessage message) {

    }
    private void processCommitMessage(ConsensusMessage message) {

    }

    // 标识共识状态
    public enum State {
        NONE(1),PREPARE(2),COMMIT(4);

        int code;

        State(int code){
            this.code = code;
        }
    }
}
