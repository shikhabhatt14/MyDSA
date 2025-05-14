package org.example.hashing;

public class MyHashOpenAddressing {

    // Hash table implementation using open addressing (linear probing)

    int[] arr;
    int size, cap;

    public MyHashOpenAddressing(int c){
        size = 0;
        cap = c;
        arr = new int[c];
        for(int i = 0; i < c; i++){
            arr[i] = -1;
        }
    }

    int hash(int key){
        return key % cap;
    }

    public void insert(int key){
        if(size == cap){
            System.out.println("Hash table is full");
            //return false;
        }
        int index = hash(key);
        while(arr[index] != -1 && arr[index] != -2 && arr[index] != key){
            index = (index + 1) % cap;
        }
        if(arr[index] == key){
            System.out.println("Key already exists");
            //return false;
        }else {
            System.out.println("Inserting key: " + key);
            arr[index] = key;
            size++;
            //return true;
        }

    }

    public void search(int key){
        int index = hash(key);
        while(arr[index] != -1){
            if(arr[index] == key){
                System.out.println("Key found: " + key);
                //return true;
            }
            index = (index + 1) % cap;
            if(index == hash(key)){
                break;
            }
        }
        System.out.println("Key not found: " + key);
        //return false;
    }

    public void delete(int key){
        int index = hash(key);
        while(arr[index] != -1){
            if(arr[index] == key){
                System.out.println("Deleting key: " + key);
                arr[index] = -2;
                size--;
                //return true;
            }
            index = (index + 1) % cap;
            if(index == hash(key)){
                break;
            }
        }
        System.out.println("Key not found: " + key);
        //return false;
    }

    public void display(){
        for(int i = 0; i < cap; i++){
            if(arr[i] == -1){
                System.out.print("null ");
            }else if(arr[i] == -2){
                System.out.print("deleted ");
            }else{
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyHashOpenAddressing ht = new MyHashOpenAddressing(10);
        ht.insert(10);
        ht.insert(20);
        ht.insert(30);
        ht.insert(40);
        ht.insert(50);
        ht.insert(60);
        ht.insert(70);
        ht.insert(80);
        ht.insert(90);
        ht.insert(100);

        ht.search(30);
        ht.search(50);
        ht.search(110);

        ht.delete(30);
        ht.delete(50);
        ht.delete(110);

        ht.display();
    }

}
