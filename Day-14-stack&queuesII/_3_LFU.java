// LFU

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;



class LFUCache 
{
    private Map<Integer,Node> keyNode;
    private Map<Integer,DLList> freqMap;
    private int maxSize; // capacity of LFU cache
    private int minFreq; // placeholder to keep track of min frequency
    private int curSize; // current size of LFU cache

    public LFUCache(int capacity)
    {
        this.maxSize=capacity;
        this.curSize=0;
        this.minFreq=0;
        keyNode=new HashMap<>();
        freqMap=new HashMap<>();
    }

    public int get(int key)
    {
        if(keyNode.containsKey(key)){
            Node node=keyNode.get(key);
            updateFreqListMap(node);
            return node.value;
        }
        return -1;
    }
    public void put(int key,int value)
    {
        if(maxSize==0) return;

        if(keyNode.containsKey(key)){
            Node node=keyNode.get(key);
            node.value=value;
            updateFreqListMap(node);
        }else{
            if(curSize==maxSize){
                DLList minFreqList=freqMap.get(minFreq);
                keyNode.remove(minFreqList.tail.prev.key);
                minFreqList.removeNode(minFreqList.tail.prev);
                curSize--;
            }
            curSize++;
            minFreq=1;
            Node newNode=new Node(key,value);
            keyNode.put(key,newNode);
            DLList curList=freqMap.getOrDefault(1,new DLList());
            curList.addFront(newNode);
            freqMap.put(1,curList);
        }
    }
    private void updateFreqListMap(Node node){
        int curFreq=node.freq;
        DLList curList=freqMap.get(curFreq);
        curList.removeNode(node);

        if(curFreq==minFreq && curList.size==0){
            minFreq++;
        }

        node.freq++;
        DLList newList=freqMap.getOrDefault(node.freq,new DLList());
        newList.addFront(node);
        freqMap.put(node.freq,newList);
    }

    class Node{
        int key,value,freq;
        Node prev,next;

        Node(int key,int value){
            this.key=key;
            this.value=value;
            this.freq=1;
        }
    }
    class DLList{
        Node head,tail;
        int size;

        DLList(){
            head=new Node(0,0);
            tail=new Node(0,0);
            head.next=tail;
            tail.prev=head;
            size=0;
        }

        void addFront(Node node){
            Node temp=head.next;
            head.next=node;
            node.prev=head;
            node.next=temp;
            temp.prev=node;
            size++;
        }
        void removeNode(Node node){
            Node prevNode=node.prev;
            Node nextNode=node.next;
            prevNode.next=nextNode;
            nextNode.prev=prevNode;
            size--;
        }
    }
}
public class _3_LFU {
    public static void main(String[] args) {
        LFUCache lfu=new LFUCache(2);
        lfu.put(1,1);
        lfu.put(2,2);
        System.out.println(lfu.get(1));
        lfu.put(3,3);
        System.out.println(lfu.get(2));
        lfu.put(4,4);
        System.out.println(lfu.get(1));
        System.out.println(lfu.get(3));
        System.out.println(lfu.get(4));
    }
}