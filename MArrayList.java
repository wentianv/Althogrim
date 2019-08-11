package com.zt.althogrim.array;

/**
 * @Auther: ASUS
 * @Date: 2019/7/15 11:05
 * @Description:
 */
public class MArrayList<T>{

    private static final int DEFAULT_CAPACITY=10;
    private int size;
    private Object[] elements;

    public MArrayList(){
        this(DEFAULT_CAPACITY);
    }

    public MArrayList(int initCapacity){
        if(initCapacity > 0){
            elements = new Object[initCapacity];
        }else{
            throw new RuntimeException("初始化数组大小要大于0");
        }
    }
    //如果数组元素个数已经超过 数组长度length;那么扩展该数组,使数组容量加倍
    private void ensureCapacity() {
        if(size +1 > elements.length){
            Object[] newEle = new Object[size*2+1];
            for(int i=0; i < size;i++){
                newEle[i] = elements[i];
            }
            elements = newEle;
        }
    }

    public void add(T element){
        add(size,element);
    }

    /**
     * @param index 数组下标
     * @param element
     */
    public void add(int index,T element){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("数组访问越界index:"+index);
        }
        // 判断数组是否需要扩容
        ensureCapacity();
        for(int i=size;i>index;i--){
            elements[i] = elements[i-1];
        }
        elements[index] = element;
        size++;
    }

    public void remove(T element){
        for(int i=0;i<size;i++){
            if(elements[i] == element){
                remove(i);
            }
        }
    }

    public void remove(int index){
        checkRange(index);
        // 后面的元素向前移动覆盖
        for(int i=index;i<size-1;i++){
            elements[i]=elements[i+1];
        }
        elements[size-1]=null;
        size--;
    }



    @SuppressWarnings("unchecked")
    public T get(int index){
        checkRange(index);
        return (T) elements[index];
    }

    public void checkRange(int index){
        if(index<0 || index >= size){
            throw new RuntimeException("数组访问越界index:"+index);
        }
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size ==0;
    }

    public static void main(String[] args){
        MArrayList<Integer> list = new MArrayList(1);
        list.add(0);
        System.out.println(list.size+" "+list.elements.length);

        list.add(1);
        System.out.println(list.size+" "+list.elements.length);

        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.toArray();

        list.add(9);
        list.toArray();
        System.out.println(list.size+" "+list.elements.length);

        list.add(10);
        System.out.println(list.size+" "+list.elements.length);
        list.toArray();


//        System.out.println(list.get(2));

    }

    private void toArray() {
        for(int i=0;i<elements.length;i++){
            System.out.print(elements[i]+"\t");
        }
        System.out.println();
    }
}
