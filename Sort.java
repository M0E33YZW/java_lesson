public class Sort {
    // 文字列配列をコピーする
    public static String[] copyArray(String[] array) {
        int len = array.length;
        String[] result = new String[len];
        for (int i = 0; i < len; i++) {
            result[i] = array[i];
        }
        return result;
    }

    // 文字列配列を表示する
    public static void printArray(String head, String[] array) {
        System.out.print(head);
        System.out.print("[");
        if (array.length > 0) {
            System.out.print(array[0]);
            int len = array.length;
            for (int i = 1; i < len; i++) {
                System.out.print(" ");
                System.out.print(array[i]);
            }
        }
        System.out.println("]");
    }

    // バブルソート1（交換しなくなるまでループ）
    public static void bubbleSort1(String[] array) {
        int len = array.length - 1;
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < len; i++) {
                // compareTo: 文字列を比較 大きいと 正、等しいと 0、小さいと 負 を返す
                if (array[i].compareTo(array[i + 1]) > 0) {
                    String tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                    swapped = true;
                }
            }
        }
    }

    // バブルソート2（先頭から完成させていく）
    public static void bubbleSort2(String[] array) {
        int len = array.length - 1;
        for (int i = 0; i < len; i++) {
            for (int j = len; j > i; j--) {
                if (array[j].compareTo(array[j - 1]) < 0) {
                    // System.out.print("[");
                    // System.out.print(array[j]);
                    // System.out.print("：");
                    // System.out.print(array[j - 1]);
                    // System.out.print("]");
                    String tmp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    // バブルソート3（末尾から完成させていく）
    public static void bubbleSort3(String[] array) {
        int len = array.length - 1;
        while (len > 0) {
            for (int i = 0; i < len; i++) {
                if (array[i].compareTo(array[i + 1]) > 0) {
                    // System.out.print("[");
                    // System.out.print(array[i]);
                    // System.out.print("：");
                    // System.out.print(array[i + 1]);
                    // System.out.print("]");
                    String tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                }
            }
            len--;
        }
    }

    // 選択ソート
    public static void selectionSort(String[] array) {
        int len = array.length - 1;
        for (int i = 0; i < len; i++) {
            int minIndex = i;
            for (int j = i + 1; j <= len; j++) {
                if (array[minIndex].compareTo(array[j]) > 0) {
                    minIndex = j;
                }
            }
            String tmp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = tmp;
        }      
    }

    // メイン
    public static void main(String[] args) throws Exception { //void 戻値無し, args 文字列の配列
        // 文字列配列
        printArray("Before   : ", args);

        // バブルソート1
        String[] bubble1Array = copyArray(args);
        bubbleSort1(bubble1Array);
        printArray("Bubble 1 : ", bubble1Array);

        // バブルソート2
        String[] bubble2Array = copyArray(args);
        bubbleSort2(bubble2Array);
        printArray("Bubble 2 : ", bubble2Array);

        // バブルソート3
        String[] bubble3Array = copyArray(args);
        bubbleSort3(bubble3Array);
        printArray("Bubble 3 : ", bubble3Array);

        // 選択ソート
        String[] selectionArray = copyArray(args);
        selectionSort(selectionArray);
        printArray("Selection: ", selectionArray);
    }
}