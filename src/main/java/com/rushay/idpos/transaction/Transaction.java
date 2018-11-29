package com.rushay.idpos.transaction;

import com.rushay.idpos.util.CryptologyUtil;

/**
 * Created by ylf on 2018/11/26.
 */
public class Transaction {
    private String hash;
    private long timeStamp;
    private String recipient;
    private String sender;
    private String message;

    public Transaction( String recipient, String sender, String message) {
        this.timeStamp = System.currentTimeMillis();
        this.recipient = recipient;
        this.sender = sender;
        this.message = message;
        this.hash = calculateHash();
    }

    public String getHash() {
        return hash;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getSender() {
        return sender;
    }

    private String calculateHash() {
        String calculatedHash = CryptologyUtil.applySha256(
                Long.toString(timeStamp)  +
                        recipient + sender + message);
        return calculatedHash;
    }
}
