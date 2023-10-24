/**
  @author kaushi
**/
public class MyHashMap<K,V> {

    public Integer INITIAL_SIZE = 16;

    Node [] table;

    public MyHashMap() {
        table = new Node[INITIAL_SIZE];
    }

    public void put(K key, V value){

        int index = key.hashCode()% table.length;

        if(table[index] == null){

            table[index] = new Node(key,value);

        }else{

            Node previousNode = table[index];
            Node node = table[index];
            while (node != null){

                if(node.key == key){
                    node.value = value;
                    return;
                }
                previousNode = node;
                node = node.next;
            }

            Node newNode = new Node(key,value);
            previousNode.next = newNode;

        }

    }

    V get(K key){

        int index = key.hashCode()%table.length;
        Node node = table[index];

        while (node!=null){
            if(node.key.equals(key)){
                return (V)node.value;
            }
        }
        return null;
    }

    class Node<K,V> {
        K key;
        V value;
        Node next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
//        System.out.println("Hello world!");

        MyHashMap<Integer,String> map = new MyHashMap<>();
        map.put(1, "hi");
        map.put(2, "my");
        map.put(3, "name");
        map.put(4, "is");
        map.put(5, "Shrayansh");
        map.put(6, "how");
        map.put(7, "are");
        map.put(8, "you");
        map.put(9, "friends");
        map.put(10, "?");

        String value = map.get(10);
        System.out.println(value);

    }
}