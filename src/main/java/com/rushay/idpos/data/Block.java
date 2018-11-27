package com.rushay.idpos.data;/**
 * Created by ylf on 2018/11/26.
 */

import com.google.common.collect.Collections2;
import com.rushay.idpos.transaction.Transaction;
import com.rushay.idpos.util.CryptologyUtil;

import java.util.List;

/**
 * @description: 区块数据结构
 * @author: rushay
 * @create: 2018-11-26 17:45
 **/
public class Block {
    private int height;
    private long timeStamp;
    private int size;
    private List<Transaction> transactions;
    private String preHash;
    private String hash;
    private String merkleRoot;


    public Block(int height , List<Transaction> transactions, String preHash)
            throws BlockConstructorException {
        if (transactions == null || transactions.isEmpty()) {
            throw new BlockConstructorException();
        }
        this.height = height;
        this.transactions = transactions;
        this.size = transactions.size();
        this.preHash = preHash;
        this.timeStamp = System.currentTimeMillis();

        this.calculateHash();
    }

    private String calculateHash() {
        String calculatedHash = CryptologyUtil.applySha256(
                preHash +
                        Long.toString(timeStamp)  +

        );
        return calculatedHash;
    }
    private String getMerkleRoot(List<Transaction> transactions) {

    }


    public class BlockConstructorException extends Exception {

    }
}
