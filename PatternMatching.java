public class PatternMatching {

    static int e1(String s1, String s2) {
        for (int i = 0; i <= s1.length()-s2.length(); i++) {
            boolean eq = true;
            for (int j = 0; j < s2.length(); j++) {
                if (eq && s1.charAt(i+j) != s2.charAt(j)) {
                    eq = false;
                    break;
                }
            }
            if (eq) {
                return i;
            }
        }

        return s1.length();
    }

    private static long hash(String s, int M) {
        long h = 0;
        for (int j = 0; j < M; j++)
            h = (h * 25 + s.charAt(j)) % 2147483647;
        return h;
    }

    static int e2(String txt, String pat) {
        int M = pat.length();
        int N = txt.length();
        long patHash = hash(pat, M);

        for (int i = 0; i <= N - M; i++) {
            long txtHash = hash(txt.substring(i, i+M), M);
            if (patHash == txtHash)
                return i; // ocorrência? colisão?
        }
        return N; // nenhuma ocorrência
    }

    public static void main(String[] args) {
        String s1 = "ABCDCBDCBDACBDABDCBADF";
        String s2 = "ADF";
        System.out.println(e2(s1, s2));
    }
}