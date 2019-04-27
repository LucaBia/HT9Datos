/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht9;

/**
 *
 * @author WR
 */
public interface BSTInterface<Key extends Comparable<Key>, Value> {
    void put(Key key, Value val);

    Value get(Key key);
}
