public class SearchAlgorithms {

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == target) return i;
        return -1;
    }

    public static int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    public static int jumpSearch(int[] arr, int target) {
        int step = (int) Math.sqrt(arr.length), prev = 0;
        while (prev < arr.length && arr[Math.min(step, arr.length) - 1] < target) {
            prev = step;
            step += (int) Math.sqrt(arr.length);
            if (prev >= arr.length) return -1;
        }
        while (prev < Math.min(step, arr.length)) {
            if (arr[prev] == target) return prev;
            prev++;
        }
        return -1;
    }

    public static int interpolationSearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high && target >= arr[low] && target <= arr[high]) {
            if (arr[high] == arr[low]) return (arr[low] == target) ? low : -1;
            int pos = low + ((target - arr[low]) * (high - low)) / (arr[high] - arr[low]);
            if (arr[pos] == target) return pos;
            if (arr[pos] < target) low = pos + 1;
            else high = pos - 1;
        }
        return -1;
    }
}
