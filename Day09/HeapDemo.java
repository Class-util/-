package Day09;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:吴博
 * Date:2021 01 30
 * Time:16:32
 */
public class HeapDemo {
    public int[] elem;
    public int usedSize;

    public HeapDemo(){
        this.elem = new int[10];
    }
    public void creatBigHeap(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            this.elem[i] = arr[i];
            this.usedSize++;
        }
        for (int i = (this.usedSize - 1 - 1) / 2; i >= 0; i--) {
            adjust(i,this.usedSize);
        }
    }

    public void adjust(int parent, int len){
        int child = 2 * parent + 1;
        //child < len有左孩子
        while(child < len){
            if(child + 1 < len && this.elem[child] < this.elem[child + 1]){
                child++;
            }
            //child指向最大值
            if(this.elem[child] > this.elem[parent]){
                int tmp = this.elem[child];
                this.elem[child] = this.elem[parent];
                this.elem[parent] = tmp;
                parent = child;
                child = 2 * parent + 1;
            }else {
                break;
            }
        }
    }
    public void show() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i] + " ");
        }
    }

    public void adjustUp(int child){
        int parent = (child - 1) / 2;

        while(child > 0){
            if(this.elem[child] > this.elem[parent]){
                int tmp = this.elem[child];
                this.elem[child] = this.elem[parent];
                this.elem[parent] = tmp;
                child = parent;
                parent = (child - 1) / 2;
            }else {
                break;
            }
        }
    }

    public void push(int val){
        if(isFull()){
            this.elem = Arrays.copyOf(this.elem,2 * this.elem.length);
        }
        this.elem[usedSize] = val;
        this.usedSize++;
        adjustUp(this.usedSize - 1);
    }

    public boolean isFull(){
        return this.usedSize == this.elem.length;
    }

    public boolean isEmpty(){
        return this.usedSize == 0;
    }

    public int poll(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        int ret = this.elem[0];
        int tmp = this.elem[0];
        this.elem[0] = this.elem[usedSize -1];;
        this.elem[usedSize -1] = tmp;
        this.usedSize--;
        adjust(0,this.usedSize);
        return ret;
    }

}
