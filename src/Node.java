/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author James Dunlap
 */
public class Node {
    int data;
    Node left;
    Node right;

    Node(int d, Node lt, Node rt)
    {
       data = d;
       left = lt;
       right = rt;
    }
}
