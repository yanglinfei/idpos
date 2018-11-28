package com.rushay.idpos.data;

import com.rushay.idpos.transaction.Transaction;
import com.rushay.idpos.util.CryptologyUtil;

import java.util.*;

/**
 * @description: Merkle树
 * @author: rushay
 * @create: 2018-11-27 21:23
 **/
public class MerkleTree {
    private Set<String> tree;
    private String root;

    public MerkleTree(Map<String, Transaction> transactions) {
        tree = new HashSet<>(transactions.keySet());
        root = "";
    }

    public String buildTree() {
        if (tree.isEmpty()) {
            return null;
        }

        List<String> tempTxs = new ArrayList<>();
        tempTxs.addAll(tree);

        List<String> newTxs = getNewTxList(tempTxs);
        while (newTxs.size() > 1) {
            newTxs = getNewTxList(newTxs);
        }

        root = newTxs.get(0);
        return root;
    }

    private List<String> getNewTxList(List<String> tree) {
        List<String> newTxs = new ArrayList<>(tree.size());
        int index = 0;
        while (index < tree.size()) {
            String left = tree.get(index);
            index++;

            String right = "";
            if (index != tree.size()) {
                right = tree.get(index);
            }
            newTxs.add(CryptologyUtil.applySha256(left + right));
            index++;
        }
        return newTxs;
    }
}
