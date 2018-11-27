package com.rushay.idpos.data;/**
 * Created by ylf on 2018/11/27.
 */

import com.rushay.idpos.network.Node;
import com.rushay.idpos.transaction.Transaction;

import java.util.List;

/**
 * @description: 保存区块链的结构
 * @author: rushay
 * @create: 2018-11-27 17:02
 **/
public class  BlockChain {
    private Block genesis;
    private Node node;
    private List<Transaction> pendingTransactions;
    private List<Block> chain;
}
