/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collectiontester;

/**
 *
 * @author INatZ
 */
public class LinkedNode {
    private Object element;
    private LinkedNode next;
    public LinkedNode(Object e, LinkedNode n) {
        element = e;
        next = n;
    }
}

