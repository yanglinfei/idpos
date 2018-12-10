package com.rushay.idpos.consensus;

/**
 * Created by ylf on 2018/11/26.
 */
public class ConsensusMessage {
    private ConsensusMessageType messageType;
    private MessageBody body;

    public ConsensusMessage(ConsensusMessageType messageType, long height, String hash, int signer) {
        this.messageType = messageType;
        this.body = new MessageBody(height, hash, signer);
    }

    public ConsensusMessageType getMessageType() {
        return messageType;
    }

    public MessageBody getBody() {
        return body;
    }

    public class MessageBody {
        private long height;
        private String hash;
        private int signer;

        public MessageBody(long height, String hash, int signer) {
            this.height = height;
            this.hash = hash;
            this.signer = signer;
        }

        public long getHeight() {
            return height;
        }

        public String getHash() {
            return hash;
        }

        public int getSigner() {
            return signer;
        }

        @Override
        public String toString() {
            return height + "," + hash +  "," + signer;
        }
    }
}
