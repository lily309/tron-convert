package org.example;

import org.apache.commons.codec.binary.Hex;
import org.tron.protos.Protocol.Transaction;
import org.tron.protos.contract.SmartContractOuterClass.TriggerSmartContract;

public class Main {

    public static void main(String[] args) throws Exception {
        byte[] rawHex = Hex.decodeHex("0a02aa2b2208bfdb0115837c796940d8c2859ed9325a8e01081f1289010a31747970652e676f6f676c65617069732e636f6d2f70726f746f636f6c2e54726967676572536d617274436f6e747261637412540a154191e9c2524a07f519e87b5a670b7f8d1415c08a63121541353e4da7c074be2ff9e3e692eaeb1e65f0f32e102224e8afa8e8000000000000000000000000353e4da7c074be2ff9e3e692eaeb1e65f0f32e1070b781829ed932900180a8d6b907");

        Transaction.raw raw = Transaction.raw.parseFrom(rawHex);
        TriggerSmartContract contract =
            raw.getContract(0).getParameter().unpack(TriggerSmartContract.class);

        System.out.println(Hex.encodeHexString(contract.getOwnerAddress().toByteArray()));
        System.out.println(Hex.encodeHexString(contract.getContractAddress().toByteArray()));
        System.out.println(Hex.encodeHexString(contract.getData().toByteArray()));
    }
}