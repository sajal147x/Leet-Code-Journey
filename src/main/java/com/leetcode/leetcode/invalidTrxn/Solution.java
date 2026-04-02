package com.leetcode.leetcode.invalidTrxn;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public class Transaction{
        public String name;
        public int amount;
        public int timestamp;
        public String city;
    }

    public List<String> invalidTransactions(String[] transactions) {
        int n = transactions.length;
        boolean[] invalid = new boolean[n];
        Transaction[] parsed = new Transaction[n];

        // parse transactions
        for (int i = 0; i < n; i++) {
            String[] split = transactions[i].split(",");
            Transaction txn = new Transaction();
            txn.name = split[0];
            txn.timestamp = Integer.parseInt(split[1]);
            txn.amount = Integer.parseInt(split[2]);
            txn.city = split[3];

            parsed[i] = txn;

            if (txn.amount > 1000) {
                invalid[i] = true;
            }
        }

        // compare
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (parsed[i].name.equals(parsed[j].name) &&
                    !parsed[i].city.equals(parsed[j].city) &&
                    Math.abs(parsed[i].timestamp - parsed[j].timestamp) <= 60) {

                    invalid[i] = true;
                    invalid[j] = true;
                }
            }
        }

        // build result
        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (invalid[i]) {
                result.add(transactions[i]);
            }
        }

        return result;
    }
}
