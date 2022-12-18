package _20010310077_Baran_Karatas;

public class _20010310077_Heap {

    private _20010310077_Record[] heap;
    private int heapSize;
    private int size;
    private int level;

    public _20010310077_Heap(int size) {
        System.out.println("Kapasitesi " + size + " olan veri yapisi olusturulmustur");
        this.heap = new _20010310077_Record[size];
        this.heapSize = 0;
        this.level = 1;
        this.size = size;

    }

    private int parent(int index) {

        return (index - 1) / 2;

    }

    private int left(int index) {

        return (2 * index) + 1;

    }

    private int right(int index) {

        return (2 * index) + 2;

    }

    public int getHeapSize() {

        return this.heapSize;
    }

    public int getNumberOfLevels(int heapSize) {

        if (parent(heapSize) != 0) {
            level++;
            getNumberOfLevels(parent(heapSize));
        }

        return level;
    }

    public void resize(int size) {
        if (this.size >= size)
            System.out.println("Mevcut boyuttan daha büyük bir deger giriniz.");
        else {
            System.out.println(
                    "Resize() metodu kullanilarak veri yapisinin boyutu " + (size / (float) this.size)
                            + " katina cikarilmistir.");
            _20010310077_Record[] copyHeap = this.heap;
            this.heap = new _20010310077_Record[size];
            for (int i = 0; i < copyHeap.length; i++) {
                this.heap[i] = copyHeap[i];
            }

        }
    }

    public _20010310077_Record search(long tc) {
        for (int i = 0; i < heapSize; i++) {
            if (heap[i].getId() == tc)
                return heap[i];
        }
        return null;
    }

    public void insert(_20010310077_Record newRecord) {

        heap[heapSize] = newRecord;
        upify(heapSize);
        heapSize++;

    }

    public _20010310077_Record returnTopRecordOfHeap() {
        _20010310077_Record topRecord = heap[0];
        swap(heapSize - 1, 0);
        heapSize--;
        downify(0);

        return topRecord;

    }

    private void upify(int index) {
        if (index == 0)
            return;
        if (heap[index].getId() > heap[parent(index)].getId()) {
            swap(index, parent(index));
            upify(parent(index));
        }
    }

    private void downify(int index) {

        int left = left(index);
        int right = right(index);
        int largest;
        if (index >= (heapSize / 2) && index <= heapSize)
            return;
        if (left <= heapSize && heap[left].getId() > heap[index].getId())
            largest = left;

        else
            largest = index;
        if (right <= heapSize && heap[right].getId() > heap[largest].getId())
            largest = right;

        if (largest != index) {
            swap(largest, index);
            downify(largest);

        }
    }

    private void swap(int first, int second) {
        _20010310077_Record temp = heap[second];
        heap[second] = heap[first];
        heap[first] = temp;
    }

    public _20010310077_Record deletWithKey(long tc) {
        int index = findCurrentIndex(tc);
        _20010310077_Record temp = heap[index];
        swap(heapSize - 1, index);
        heapSize--;
        downify(index);

        return temp;

    }

    public _20010310077_Record deletWithIndex(int index) {
        _20010310077_Record temp = heap[index];
        swap(heapSize - 1, index);
        heapSize--;
        downify(index);

        return temp;
    }

    private int findCurrentIndex(long tc) {

        int count = -1;
        for (_20010310077_Record x : heap) {
            count++;
            if (x.getId() == tc) {
                return count;
            }
        }
        return -1;
    }

    public void printRecord(_20010310077_Record record) {
        record.getInfo();

    }

    public void printHeap() {

        for (int i = 0; i < heapSize; i++) {
            System.out.print(heap[i].getId() + ",");

        }
        System.out.println("\n");
    }

}
