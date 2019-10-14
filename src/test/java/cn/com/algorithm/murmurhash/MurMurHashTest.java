package cn.com.algorithm.murmurhash;

import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import org.junit.Test;

import java.nio.charset.Charset;

/**
 * Description:
 * User: wangpl
 * Date: 2019-08-01
 * Time: 19:16
 */

public class MurMurHashTest {

    @Test
    public void testMurMurHash() {
        HashFunction hashFunction = Hashing.murmur3_128();
        String wangChhdshdsajkdhkjsa = hashFunction.hashString("wangChhdshdsajkdhkjsa", Charset.forName("UTF-8")).toString();
        System.out.println(wangChhdshdsajkdhkjsa);



    }
}
