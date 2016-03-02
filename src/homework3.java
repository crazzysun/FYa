import java.util.*;

public class homework3 {
    String[] tmpa = {"aba", "bad", "d", "b", "abc"};
    String[] tmpb = {"b", "ab", "ba", "dd", "c"};
    HashMap<String, String> map;
    char[] chars = {'a', 'b', 'c', 'd'};
    ArrayList<ArrayList<String>> ans;
    Set<String> used;
    Set<String> good;

    TreeMap<String, ArrayList<String>> res;


    void run() {
        map = new HashMap<String, String>();
        ini();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    String s = chars[i] + "" + chars[j] + "" + chars[k];
                    rec(s, new ArrayList<String>());
                }
            }
        }

        System.out.println(ans.size());
        System.out.println(res.size());

        for (ArrayList<String> an : res.values()) {
            for (String s : an) {
                System.out.print(s + " -> ");
            }
            System.out.println("\n");
        }
    }

    void rec(String s, ArrayList<String> strings) {
        if (s.length() > 6 || (!good.contains(s) && used.contains(s))) {
            return;
        }

        strings.add(s);

        if (s.equals("c") || good.contains(s)) {
            ans.add(strings);
            for (String string : strings) {
                good.add(string);
            }

            if (!res.containsKey(strings.get(0))) {
                res.put(strings.get(0), strings);
            }

            if (res.get(strings.get(0)).size() > strings.size()) {
                res.put(strings.get(0), strings);
            }

            return;
        }

        used.add(s);

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (map.containsKey(s.substring(i, j))) {
                    String tmp = s.substring(0, i) + map.get(s.substring(i, j)) + s.substring(j);
                    ArrayList<String> tmpArr = (ArrayList<String>) strings.clone();
                    rec(tmp, tmpArr);
                }
            }
        }
    }

    int hash(String s) {
        int t = 1;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans += t * s.charAt(i) - 'a';
            t *= 10;
        }

        return ans;
    }

    void ini() {
        for (int i = 0; i < tmpa.length; i++) {
            map.put(tmpa[i], tmpb[i]);
        }

        ans = new ArrayList<ArrayList<String>>();
        used = new HashSet<String>();
        good = new HashSet<String>();
        res = new TreeMap<String, ArrayList<String>>();
    }

    public static void main(String[] args) {
        new homework3().run();
    }
}
