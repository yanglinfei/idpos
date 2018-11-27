package com.rushay.idpos.contract;

import com.rushay.idpos.transaction.Transaction;

/**
 * Created by ylf on 2018/11/26.
 */
public interface ContractVerify {
    /**
     * 交易验证方法，为应对多种场景，故抽象出一个接口
     * @param transaction
     * @return
     */
    boolean check(Transaction transaction);
}
