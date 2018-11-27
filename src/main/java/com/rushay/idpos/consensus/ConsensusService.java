package com.rushay.idpos.consensus;

import com.rushay.idpos.contract.ContractVerify;
import com.rushay.idpos.transaction.Transaction;

/**
 *
 * Created by ylf on 2018/11/26.
 */
public class ConsensusService {
    private ConsensusContext consensusContext;
    private ContractVerify contractVerify;


    private boolean addTransaction(Transaction transaction) {
        return true;
    }
}
