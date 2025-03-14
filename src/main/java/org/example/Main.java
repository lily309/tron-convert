package org.example;

import org.apache.commons.codec.binary.Hex;
import org.tron.protos.Protocol.Transaction;
import org.tron.protos.contract.SmartContractOuterClass.TriggerSmartContract;

public class Main {

    public static void main(String[] args) throws Exception {
        byte[] rawHex = Hex.decodeHex("0a02c9592208d722a5ee5f1e8c3a40e891d8cbd8325a72081f126e0a31747970652e676f6f676c65617069732e636f6d2f70726f746f636f6c2e54726967676572536d617274436f6e747261637412390a1541628463d7252bd289923fa98a3f6c5fae2cd3ee691215412c7c9963111905d29eb8da37d28b0f53a7bb5c2818c096b10222041249c58b70f4cad4cbd83290018084af5f");

        Transaction.raw raw = Transaction.raw.parseFrom(rawHex);
        TriggerSmartContract contract =
            raw.getContract(0).getParameter().unpack(TriggerSmartContract.class);

        System.out.println(Hex.encodeHexString(contract.getOwnerAddress().toByteArray()));
        System.out.println(Hex.encodeHexString(contract.getContractAddress().toByteArray()));
        System.out.println(Hex.encodeHexString(contract.getData().toByteArray()));
        System.out.println(contract.getCallValue());
        System.out.println(contract.getTokenId());
        System.out.println(contract.getCallTokenValue());
    }
}