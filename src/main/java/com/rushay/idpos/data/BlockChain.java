package com.rushay.idpos.data;/**
 * Created by ylf on 2018/11/27.
 */

import com.rushay.idpos.network.Node;
import com.rushay.idpos.transaction.Transaction;

import java.util.List;
import java.util.Map;

/**
 * @description: 保存区块链的结构
 * @author: rushay
 * @create: 2018-11-27 17:02
 **/
public class  BlockChain {
    private Block genesis;
    private Node node;
    private Map<String, Transaction> pendingTransactions;
    private List<Block> chain;

    public boolean hasTransaction(String hash) {
        for (Block block : chain) {
            if (block.hasTransaction(hash)) {
                return true;
            }
        }
        return pendingTransactions.get(hash) == null;
    }

    public boolean addTransaction(Transaction transaction) {
        if (hasTransaction(transaction.getHash())) {
            return false;
        }
        pendingTransactions.put(transaction.getHash(), transaction);
        return true;
    }

    public boolean validteTransaction(Transaction transaction) {
        return false;
    }


    public boolean validteBlock(Block block) {
        return false;
    }

    public Block createBlock() {
        Block block = null;
        try {
            block = new Block(chain.size() + 1, pendingTransactions, chain.get(chain.size() - 1).getHash());
        } catch (Block.BlockConstructorException e) {
            e.printStackTrace();
        }

        return block;
    }
}
