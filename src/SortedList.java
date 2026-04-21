public class SortedList {
    private String[] data;
    private int size;

    public SortedList() {
        data = new String[10];
        size = 0;
    }

    public int binarySearch(String target) {
        int low = 0;
        int high = size - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = data[mid].compareToIgnoreCase(target);

            if (cmp == 0) return mid;
            else if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }
        return -(low + 1);
    }

    public int add(String value) {
        if (size == data.length) {
            String[] bigger = new String[data.length * 2];
            for (int i = 0; i < size; i++) bigger[i] = data[i];
            data = bigger;
        }

        int result = binarySearch(value);
        int insertAt = (result >= 0) ? result + 1 : -(result + 1);

        for (int i = size; i > insertAt; i--) data[i] = data[i - 1];
        data[insertAt] = value;
        size++;
        return insertAt;
    }

    public String search(String target) {
        int result = binarySearch(target);
        if (result >= 0)
            return "\"" + target + "\" FOUND at index " + result;
        else
            return "\"" + target + "\" NOT FOUND. Would be at index " + -(result + 1);
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++)
            sb.append("[").append(i).append("] ").append(data[i]).append("\n");
        return sb.toString();
    }
}
