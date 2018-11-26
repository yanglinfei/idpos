package com.rushay.idpos.consensus;

/**
 * Created by ylf on 2018/11/26.
 */
public class ConsensusMessage {
    public static final int INIT = 0x01;
    public static final int PREPARE = 0x02;
    public static final int COMMIT = 0x04;
    public static final int BLOCK = 0x08;

}
