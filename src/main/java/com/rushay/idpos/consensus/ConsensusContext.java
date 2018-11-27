package com.rushay.idpos.consensus;

import com.rushay.idpos.transaction.Transaction;

import java.security.KeyPair;
import java.util.List;

/**
 * Created by ylf on 2018/11/26.
 */
public class ConsensusContext {
    private List<Transaction> transactions;
    private List<String> signature;
    private String preHash;
    private int state;
    private KeyPair keyPair;
}
