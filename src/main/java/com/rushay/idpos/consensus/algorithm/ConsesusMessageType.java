package com.rushay.idpos.consensus.algorithm;

/**
 * Created by ylf on 2018/11/26.
 */
public enum ConsesusMessageType {
    INIT(0x01), PREPARE(0x02), COMMIT(0x04), BLOCK(0x08);

    ConsesusMessageType(int type) {
        this.type = type;
    }
    public int type;

    public int getType() {
        return type;
    }
}
