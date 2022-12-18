package _20010310077_Baran_Karatas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class _20010310077_App {
    _20010310077_Heap heap;

    public static void main(String[] args) throws InterruptedException {
        _20010310077_App app = new _20010310077_App();
        app.start(2500, 5000);
    }

    public void start(int heapSize, int resizedHeapSize) {
        readFileAndCreateHeap(heapSize, resizedHeapSize);
        System.out.println("Heapda bulunan kayit sayisi " + heap.getHeapSize());
        newLine();
        heap.printRecord(heap.deletWithKey(7756591263l));
        System.out.print(" ---------> Kayit silinidi");
        newLine();
        System.out.println("Heapda bulunan kayit sayisi " + heap.getHeapSize());
        newLine();

        System.out.println("Heapdaki en buyuk kayit cikartildi");
        heap.printRecord(heap.returnTopRecordOfHeap());
        newLine();
        System.out.println("43 nolu indexde bulunan kayit silindi");
        heap.printRecord(heap.deletWithIndex(43));
        newLine();
        System.out.println("Hep icerisinde 9377761894 tc sine ait kayit bulundu");
        heap.printRecord(heap.search(9377761894l));
        newLine();
        System.out.println("Heap agacinin seviye sayisi : " + heap.getNumberOfLevels(resizedHeapSize));

    }

    public void readFileAndCreateHeap(int heapSize, int resizedHeapSize) {
        try {
            File txtFile = new File("kayit_dosyasi.txt");
            Scanner reader = new Scanner(txtFile);
            heap = new _20010310077_Heap(heapSize);
            fillHeap(0, heapSize, reader, heap, false);
            System.out.println(
                    "Insert() metodu kullanilarak dosyadaki ilk " + heapSize + " kayit veri yapisina eklenmiştir.");
            fillHeap(heapSize, resizedHeapSize, reader, heap, true);
            System.out.println(
                    "Insert() metodu kullanilarak dosyadaki ikinci " + (resizedHeapSize - heapSize)
                            + " kayit veri yapisina eklenmiştir.");

            reader.close();
            newLine();
        } catch (FileNotFoundException e) {
            System.out.println("Dosya okunamadi.");
            e.printStackTrace();
        }

    }

    public void fillHeap(int from, int to, Scanner reader, _20010310077_Heap heap, boolean resize) {
        if (resize == true)
            heap.resize(to);
        int count = from;
        while (count < to && reader.hasNextLine()) {
            String[] lines = reader.nextLine().split(",");
            heap.insert(new _20010310077_Record(Long.decode(lines[0]), lines[1], lines[2]));
            count++;
        }

    }

    public void newLine() {
        System.out.println("\n");
    }
}
