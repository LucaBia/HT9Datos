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
public class BSTFactory {
    public static BSTInterface createBST(String tree){

        switch (tree) {
            case "rbt": return new RedBlackBST<>();
            case "splay": return new SplayBST<>();
            default: return new RedBlackBST<>();
        }

    }
}
