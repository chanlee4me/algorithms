package com.thealgorithm.sort;

public class MinHeap {

    int size;
    int capacity;
    int[] heap;//存储元素

    public MinHeap(int capacity){
        this.size = 0;
        this.capacity = capacity;
        this.heap = new int[capacity];
    }
    public MinHeap(){
        this(0);
    }

    /**
     * 插入元素
     * 在数组末尾元素的下一个位置插入元素
     * @param value
     */
    public void insert(Integer value){
        //当达到阈值时，进行扩容
        if(size == capacity){
            capacity *= 2;
            int[] newHeap = new int[capacity];
            System.arraycopy(heap, 0, newHeap, 0, size);
            heap = newHeap;
        }
        heap[size++] = value;
        siftUp(size - 1);
    }

    /**
     * 删除堆顶元素
     * @return 返回被删除的堆顶元素
     */
    public int remove(){
        if(size == 0) return -1;
        int toDelete = heap[0];
        swap(0, size - 1);
        size--;
        siftDown(0);
        return toDelete;
    }
    /**
     * 上浮元素，维护小顶堆的性质
     * @param index
     */
    public void siftUp(int index){
        //当前元素的值小于父节点值，那么互换位置
        int parent = getParent(index);
        while(index > 0 && heap[index] < heap[parent]){
            swap(index, parent);
            index = parent;
            parent = getParent(index);
        }
    }

    /**
     * 下沉元素，维护小顶堆的性质
     * @param index 待维护的起始索引
     */
    public void siftDown(int index){
        int leftChild = getLeftChild(index);
        int rightChild = getRightChild(index);
        int minChildIndex = index;
        while(true){
            if(leftChild < size && heap[leftChild] < heap[minChildIndex]){
                minChildIndex = leftChild;
            }
            if(rightChild < size && heap[rightChild] < heap[minChildIndex]){
                minChildIndex = rightChild;
            }
            if(minChildIndex == index) break;

            swap(minChildIndex, index);
            index = minChildIndex;
        }
    }

    /**
     * 获取父节点索引
     * @param index
     * @return
     */
    public int getParent(int index){
        if(index <= 0) return -1;
        return (index - 1) / 2;
    }

    /**
     * 获取左孩子节点索引
     * @param index
     * @return
     */
    public int getLeftChild(int index){
        return 2 * index + 1;
    }

    /**
     * 获取右孩子节点索引
     * @param index
     * @return
     */
    public int getRightChild(int index){
        return 2 * index + 2;
    }

    /**
     * 交换数组中的两个元素
     * @param i
     * @param j
     */
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}

