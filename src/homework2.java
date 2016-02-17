import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class homework2 {

    void run() {
        ArrayList<String> L1 = new ArrayList<String>(Arrays.asList("01", "11", "12"));
        ArrayList<String> L2 = new ArrayList<String>(Arrays.asList("120", "011", "112"));

        System.out.println("ans1: ");
        Set<String> ans1 = rightQuotient(pow(L1, 4), L2);
        for (String o : ans1) {
            System.out.print(o + ", ");
        }
        System.out.println();

        System.out.println("ans2: ");
        Set<String> ans2 = leftQuotient(L2, pow(L1, 3));
        for (String o : ans2) {
            System.out.print(o + ", ");
        }
        System.out.println();

        System.out.println("ans3: ");
        Set<String> ans3 = leftQuotient(R(L1), pow(L2, 2));
        for (String o : ans3) {
            System.out.print(o + ", ");
        }
        System.out.println();

        System.out.println("ans4: ");
        Set<String> ans4 = rightQuotient(pow(L2, 2), L1);
        for (String o : ans4) {
            System.out.print(o + ", ");
        }
        System.out.println();


        ArrayList<String> tmp1 = new ArrayList<String>();
        tmp1.add("1");
        ArrayList<String> tmp2 = new ArrayList<String>();
        tmp2.add("12");
        ArrayList<String> L1L2 = new ArrayList<String>();
        L1L2.addAll(L1);
        L1L2.addAll(L2);

        System.out.println("ans5: ");
        Set<String> ans5 = leftQuotient(tmp1, new ArrayList<String>(rightQuotient(pow(L1L2, 2), tmp2)));
        for (String o : ans5) {
            System.out.print(o + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        new homework2().run();
    }

    ArrayList<String> pow(ArrayList<String> L, int pow) {
        ArrayList<String> res = new ArrayList<String>(L.size());
        ArrayList<String> resTmp = new ArrayList<String>();

        res.addAll(L);

        for (int ii = 1; ii < pow; ii++) {
            for (String re : res) {
                for (String aL : L) {
                    if (!resTmp.contains(re + aL)) {
                        resTmp.add(re + (aL));
                    }
                }
            }


            res.clear();
            for (String s : resTmp) {
                res.add(s);
            }
            resTmp.clear();
        }

        return res;
    }

    Set<String> leftQuotient(ArrayList<String> L1, ArrayList<String> L2) {
        Set<String> res = new HashSet<String>();

        for (String s2 : L2) {
            for (String s1 : L1) {
                if (s2.startsWith(s1)) {
                    res.add(s2.replaceFirst(s1, ""));
                }
            }
        }

        return res;
    }

    Set<String> rightQuotient(ArrayList<String> L1, ArrayList<String> L2) {
        Set<String> res = new HashSet<String>();

        for (String s1 : L1) {
            for (String s2 : L2) {
                if (s1.endsWith(s2)) {
                    res.add(s1.substring(0, s1.lastIndexOf(s2)));
                }
            }
        }

        return res;
    }

    ArrayList<String> R(ArrayList<String> L) {
        ArrayList<String> res = new ArrayList<String>();

        for (String s : L) {
            res.add(revert(s));
        }

        return res;
    }

    String revert(String s) {
        StringBuilder t = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; i--) {
            t.append(s.charAt(i));
        }
        return t.toString();
    }
}
