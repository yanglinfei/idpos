package com.rushay.idpos.consensus;

/**
 * @description:
 * @author: rushay
 * @create: 2018-12-03 09:40
 **/
public class PrepareMessage extends ConsensusMessage {
    public PrepareMessage(ConsensusMessageType messageType, long height, String hash, int signer) {
        super(messageType, height, hash, signer);
    }
}
