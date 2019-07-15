package cn.com.algorithm.recall;

/**
 * Description:
 * User: wangpl
 * Date: 2019-07-14
 * Time: 13:55
 */

public class RegexTest {
    private boolean isMatched;

    private char[] pattern;

    private int pLen;

    public RegexTest(char[] pattern, int pLen) {
        this.pattern = pattern;
        this.pLen = pLen;
    }

    public boolean matched(char[] text, int tlen) {
        isMatched = false;
        rmatch(0, 0, text, tlen);
        return isMatched;
    }

    private void rmatch(int ti, int pj, char[] text, int tlen) {
        if (isMatched) return; // 感觉十分必要  防止后面被修改的危险
        if (pj == pLen) {
            if (ti == tlen) {
                isMatched = true;
            }
            return;
        }

        if (pattern[pj] == '*') {
            for (int k = 0; k <= tlen - ti; ++k) {
                rmatch(ti + k, pj + 1, text, tlen);
            }
        } else if (pattern[pj] == '?') {
            rmatch(ti, pj + 1, text, tlen);
            rmatch(ti + 1, pj + 1, text, tlen);
        } else if (ti < tlen && pattern[pj] == text[ti]) {
            rmatch(ti + 1, pj + 1, text, tlen);
        }
    }


    public static void main(String[] args) {
        RegexTest regexTest = new RegexTest("*abc".toCharArray(), 4);

        String str = "qwewqeqabc";
        boolean matched = regexTest.matched(str.toCharArray(), str.length());
        System.out.println(matched);
    }
}