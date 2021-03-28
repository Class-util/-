package Day02;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:吴博
 * Date:2020 12 28
 * Time:22:47
 */
public class MyArrayList {
    private int[] elem;
    private int usedSize;

    public MyArrayList(){
        this.elem = new int[5];
    }
    public  MyArrayList(int n){
        this.elem = new int[n];
    }

    //打印顺序表
    public void display(){
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i] + " ");
        }
        System.out.println("\n");
    }
    //判断是否满
    public boolean isFull(){
        //System.out.println("顺序表以满");
        return this.usedSize == this.elem.length;
    }
    //扩容
    public void resize(){
        this.elem = Arrays.copyOf(this.elem,2 * this.elem.length);
    }
    //在post位置新增元素
    public void add(int pos,int data){
        if (isFull()){
            System.out.println("顺序表以满");
            resize();
            return;
        }
        if(pos < 0 || pos > usedSize){
            System.out.println("插入位置不合法");
            return;
        }
        for (int i = this.usedSize-1; i >= pos ; i--) {
            this.elem[i+1] = this.elem[i];
        }
        this.elem[pos] = data;
        this.usedSize++;
    }
    //默认插入最后一个位置
    public void add(int data){
        if (isFull()) {
            System.out.println("顺序表以满");
            resize();
        }
        this.usedSize++;
        this.elem[usedSize-1] = data;
    }
    //判定是否包含某个元素
    public boolean contains(int toFind){
        for (int i = 0; i < usedSize; i++) {
            if(toFind == this.elem[i])
                return true;
        }
        return false;
    }
    //查找某个元素对应的位置
    public int search(int toFind){
        for (int i = 0; i < usedSize; i++) {
            if(toFind == this.elem[i])
                return i;
        }
        return -1;
    }
    //获取pos位置的元素
    public int getPos(int pos){
        if(pos < 0 || pos >= this.usedSize){
            System.out.println("插入位置不合法");
            return -1;
        }
        return this.elem[pos];
    }
    //给pos位置的元素设为value
    public void setPos(int pos ,int value){
        if(pos < 0 || pos >= this.usedSize){
            System.out.println("插入位置不合法");
            return ;
        }
        this.elem[pos] = value;
    }
    //删除第一次出现的关键字Key
    public void remove(int toRemove){
        int search = search(toRemove);
        if(search == -1){
            System.out.println("元素不存在");
            return ;
        }
        for (int i = search; i < this.usedSize-1; i++) {
            this.elem[i] = this.elem[i+1];
        }
        this.usedSize--;
    }
    //获取顺序表长度
    public int size(){
        return this.usedSize;
    }
    //清空顺序表
    public void clear(){
        this.usedSize = 0;
    }
}
