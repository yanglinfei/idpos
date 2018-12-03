package com.rushay.idpos.network;

import com.rushay.idpos.consensus.ConsensusMessage;
import com.rushay.idpos.data.BlockChain;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description: 网络节点，每个网络节点和一个区块链上账户绑定
 * @author: rushay
 * @create: 2018-11-27 17:04
 **/
public class Node {
    private final static ExecutorService threadPoolExecutor = Executors.newCachedThreadPool();

    private final int id;
    private final boolean badNode;
    private BlockChain blockChain;
    private Map<Integer, Peer> peers;
    private int port;
    private ServerSocket socket;

    public Node(int id, boolean badNode, int port) {
        this.id = id;
        this.badNode = badNode;
        this.port = port;
        this.blockChain = new BlockChain();
        start();
    }

    private void start() {
        try {
            this.socket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true);
    }

    public class Peer {
        private int thisId;
        private int thisPort;
        private int dstId;
        private int dstNode;
        private Socket socket;
        private Task task;
    }

    public void broadcast(ConsensusMessage message) {

    }

    private class Task implements Runnable {
        private Peer peer;

        public Task(Peer peer) {
            this.peer = peer;
        }

        @Override
        public void run() {

        }
    }
}
