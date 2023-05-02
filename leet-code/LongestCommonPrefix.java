public class LongestCommonPrefix {

    /* AVAVABAB */
    public static String getLongestCommonPrefix(String[] strs) {
        //
        String result = "";
        String holderStr = "" + strs[0].charAt(0);
        int j = 0;

        int lengthStr0 = strs[0].length();
        int step = 1;
        while (j < strs.length) {
            //
            if (strs[j].length() >= holderStr.length()
                    && strs[j].substring(0, holderStr.length()).contains(holderStr)) {

                j++;
                if (j == strs.length) {
                    if (result.length() < holderStr.length()) {
                        result = holderStr;
                    }
                    if ((step) < lengthStr0) {
                        j = 0;
                        holderStr += strs[0].charAt(step);
                        step++;

                    }
                }

            } else {
                break;
            }
        }

        System.out.println(result);
        return result;
    }

    public static String getLPr(String[] strs) {
        //
        if (strs.length == 0)
            return "";
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {

            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);

                if (prefix.isEmpty())
                    return "";
            }

        }
        System.out.println(prefix);
        return prefix;
    }

    public static String getLgPr2(String[] strs) {
        //

        if (strs.length == 0)
            return "";

        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[i].charAt(i);

            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() == i || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    ///////////////////////////////
    /*
     * 
     * 
     */

    public static String getLgPr3(String[] strs) {
        //

        if (strs.length == 0)
            return "";
        return getLgPr3(strs, 0, strs.length - 1);

    }

    public static String getLgPr3(String[] strs, int l, int r) {
        //
        if (l == r) {
            return strs[l];
        } else {
            int mid = (l + r) / 2;
            String lgPrLeft = getLgPr3(strs, l, mid);
            String lgPrRigth = getLgPr3(strs, mid + 1, r);
            return getLgPr3(lgPrLeft, lgPrRigth);
        }
    }

    public static String getLgPr3(String left, String right) {
        int min = Math.min(left.length(), right.length());

        for (int i = 0; i < min; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                return left.substring(0, i);
            }
        }
        return left.substring(0, min);
    }

    public static String lcp(String[] strs) {
        //
        if (strs.length == 0)
            return "";

        int minLen = Integer.MAX_VALUE;

        for (String str : strs) {
            minLen = Math.min(minLen, str.length());
        }

        int low = 1;
        int high = minLen;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (isCommonPrefix(strs, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    private static boolean isCommonPrefix(String[] strs, int mid) {

        String str = strs[0].substring(0, mid);
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].indexOf(str) != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(getLgPr3(new String[] { "flower", "flow", "flogoight" }));
    }
}