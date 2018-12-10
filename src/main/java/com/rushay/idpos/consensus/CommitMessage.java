package com.rushay.idpos.consensus;

/**
 * @description:
 * @author: rushay
 * @create: 2018-12-03 09:41
 **/
public class CommitMessage extends ConsensusMessage {
    public CommitMessage(ConsensusMessageType messageType, long height, String hash, int signer) {
        super(messageType, height, hash, signer);
    }
}
