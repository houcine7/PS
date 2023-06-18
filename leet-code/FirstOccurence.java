public class FirstOccurence {

    public static int findFirstOccurence(String haystack, String needle) {

        int index = 0;
        int n = haystack.length();
        int m = needle.length();

        while (index + m <= n) {
            if (haystack.substring(index, index + m).equals(needle)) {
                return index;
            } else {
                index++;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        System.out.println(findFirstOccurence("budjhfsatsaddfjhdj", "sad"));

    }

}
