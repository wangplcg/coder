import sun.misc.BASE64Encoder;

import javax.crypto.*;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class PBETest {
    /**
     * 定义加密方式
     * 支持以下任意一种算法
     * <p/>
     * <pre>
     * PBEWithMD5AndDES
     * PBEWithMD5AndTripleDES
     * PBEWithSHA1AndDESede
     * PBEWithSHA1AndRC2_40
     * </pre>
     */
    private final static String KEY_PBE = "PBEWithSHA1AndRC2_40";

    private final static int SALT_COUNT = 8;

    /**
     * 初始化盐（salt）
     *
     * @return
     */
    public static byte[] init() {
        return new byte[] { -19, -96, 117, -28, 87, -18, 78, 114 };
    }

    /**
     * 转换密钥
     *
     * @param key 字符串
     * @return
     */
    public static Key stringToKey(String key) {
        SecretKey secretKey = null;
        try {
            PBEKeySpec keySpec = new PBEKeySpec(key.toCharArray());
            SecretKeyFactory factory = SecretKeyFactory.getInstance(KEY_PBE);
            secretKey = factory.generateSecret(keySpec);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return secretKey;
    }

    /**
     * PBE 加密
     *
     * @param data 需要加密的字节数组
     * @param key  密钥
     * @param salt 盐
     * @return
     */
    public static byte[] encryptPBE(byte[] data, String key, byte[] salt) {
        byte[] bytes = null;
        try {
            // 获取密钥
            Key k = stringToKey(key);
            PBEParameterSpec parameterSpec = new PBEParameterSpec(salt, SALT_COUNT);
            Cipher cipher = Cipher.getInstance(KEY_PBE);
            cipher.init(Cipher.ENCRYPT_MODE, k, parameterSpec);
            bytes = cipher.doFinal(data);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return bytes;
    }

    /**
     * PBE 解密
     *
     * @param data 需要解密的字节数组
     * @param key  密钥
     * @param salt 盐
     * @return
     */
    public static byte[] decryptPBE(byte[] data, String key, byte[] salt) {
        byte[] bytes = null;
        try {
            // 获取密钥
            Key k = stringToKey(key);
            PBEParameterSpec parameterSpec = new PBEParameterSpec(salt, SALT_COUNT);
            Cipher cipher = Cipher.getInstance(KEY_PBE);
            cipher.init(Cipher.DECRYPT_MODE, k, parameterSpec);
            bytes = cipher.doFinal(data);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return bytes;
    }

    /**
     * BASE64 加密
     *
     * @param key 需要加密的字节数组
     * @return 字符串
     * @throws Exception
     */
    public static String encryptBase64(byte[] key) throws Exception {
        return (new BASE64Encoder()).encodeBuffer(key);
    }

    /**
     * 测试方法
     *
     * @param args
     */
    public static void main(String[] args) {
        // 加密前的原文
        String str = "ItsPdN9r8TNcbENANg+nGfntSdJvC64v+ndh+Wk0rxPuxWCPkORhIsMm6htK2V7Nbj/43S9R7hke" +
                "KR/oVkM73ftzIA9i4Trn2j8xxQL95vS3fqv2VA+Gbk09P1SysOrA9c24i7+qsyO5Cq7U4V5baixN" +
                "D91Cr3A0HITfZTZWK2YZew9R3SmhgEejeH3iSz3+Eo9M3vtAT9mUDekhQ1JAZrG89yWdgt2TRV9C" +
                "GEdPuMqEnFbFDaLQVeiTQ64EZGrcleLHmEULVMbb3UK9zS78fPb0mFymBpz0YuqSQIdceZ4QgWjb" +
                "8+Ue7ayFuUpYqIFxR6NpeXhLToYBa4BbRDaCbAnXPcKYRuvb0sQyW0rhOZRwFE0Dp5/RiFTuHkau" +
                "jTQQoY5b7ZzJpwJtojR/jUFDlhBCb4n1ZWy9vqRhdvQl7ZTTcOZ/15OaR+n7YzYXJw78MnmEFpqh" +
                "QtHatR4fu/UK+CLml/z3Bat96e4RIpCcEe155BM4dDpCrFbs0ae3+mz1BYS1b6aT+sutQokAKUmS" +
                "hJr1O1ZRMdWHkRDtjO7JfZAKr0zf7F5/StKYAo+pwUWrIWO42dhhtHzsypZGZ067l4g4ydH20CAg" +
               "9T2Fuvl0+IKH1W9ouOYEuyYwMrlE+NT1zA6pJ3+QSTbXN378LfmV9qqDSMnGBDdInoRociUaor1H" +
               "EGkvdjrU6Ci5G6UyvC0q+n+VwuQQ8HgW0K1OpoKMTYXeBEp1fuofq7KS33U+WBE4lcTgAKPKfZYQ" +
               "U4i1KOuM5m72n2Ca9sqQIgyN9Jw0G4+G4Kg8yDCDuMEIYnM//hM0zujJPxf38ZKc2qtP0pT5ZPia" +
               "4x9L9GLGV2lEVGT97BOiF324srQ7tZhiGJXUeXn1CjZ9NYCS+OrCydqgaCMssd5LDfeN63X/Q6tX" +
               "yzqzhps7ef2PJehKIRMIiTd5ClxdisGeoNHTN63nqNG1tI1ZCE8OYDhu2+WRRud6MgdO+X46Ep4W" +
               "FSHRSot+E6+YAmXYsZibf+aMJ9ilWEPqR8eOpKebhm+lZYOi9pc5DFakDjQtt0wK0ZQpTTBtCWlg" +
               "2Z+KMhijqNBj/lJ58M5aoV//yaNT6mbaeBAEHpc3lUDWZLyyxHrWBpjDt5yhyDhO1agN5B183apz" +
               "w4wdgR6QCIXRO+YqkDj8g+dUOoszbu6bKadr05oClUo5FjGWXG2pYuUDuIsEtolIbTkv5w9Z3ZVi" +
               "XbTcEU8z1XQM/BXEZhLSfJWieAcmVd889W//mNdtR5LWj6Ooa8RLCMVkiNFubE31j9ZWYN8HdLN+" +
               "GBrcq0dsLRb5z3jIuJ/ayiwcuj96qFkU/xG9YyrMCt7Hpa5c9Bo+3ZVE0xCzpesbB9ECGEjokUu1" +
               "xauwzdQlul7s/K46WClDis1wM714jtcTxEbeOixIyUyI2HT8+7FWMFc1zfVHyetC9L3SrtlAsKsp" +
               "GwFv/lMJxSsVvAXFdSU1xrb1TdcAOe/ID5vNe0ehJuPQdq2/QrW+wk0yO80A602/oDfPdhImw1/N" +
               "Jn62k8cslc/1v2wEzGXflsOvbOxQnszEj480jWfAO+5n8NoZOON0yjNAFjGLWTW9WHShKvmNMPtd" +
               "2tmERqJsjH5PDOisG9B8jbgH/mNuCMWX+UqBDsjvvPcY+7Y40UIkV8Pa80lEKntZXTFKzIiT0vUS" +
               "LyuyrhwiCyr186jSsY9xircTcqA+iyLR9ga35GG7p6SJgtEuALKKszz4WrapmXhkJIegKvmAGdrC" +
               "aixVfgbhJE5ROJEq4CiUccg5bao8OPO9Ly6dWIgXBwZAU2/8nm0MeBiY/kjKGcSVFGtbkju1gXe/" +
               "CvfzlJA/9qGczeSGVloMcvu4ifSqIGSkThx0kMVitm3gaqwbT+4FRkjVXPb7lWQlXi+KjPtU6fTC" +
               "/xSro5xLomXwaKdyy28w/VIVQP42dkfy65Q/sPWJx1LuZMoWzsVdmAscA9144Iex/fdSVyfELrKx" +
               "g8BYYnc93ZDzCWssysy2dDI+4p2gQNE+FfzCS0gVI1IK9iN+l0kJ3IIRYpMcVy0SdrkdWOM0fK6m" +
               "ANqJssxu8dFWv9QfoWa9+VRqKwmGfCZktwIUj+7Z9upO4ieQAz0xHQJIouhxQJ0AuXr41/dhUZNT" +
               "ZAC5OkfOA0bo48AM2F6Gdqdl+RyqouJSQ0CMbL/P/dhdEUKZahpnzZuDiAGX+iQkIaBtG9/STp13" +
               "K3xnw8z67Az3V6I9fweoaRM+ufoK9lQGeTBTpFK7AMm5LYDzJxJe65TA9ySMZ6gOLRSlXW/SF9cV" +
               "GXpJGk6k+LpdrQZIZLsHFACW8ARQE0YuhjB59Xw8V1itM4N+rf97yU8+7Lw3q+Yygx/aA1JBXEj9" +
               "BoVpnLbsw1NqBJ/zUoo3F2NqSmgI/b1nlXu6AvqBd98eAl+uxipvojXOKreonmi2aPZr/AOaPGDC" +
               "MensixIweIJ95j83/aH6D4qx7gAboI8rFZMbUtTFr8CoJG6MJw3hiYiv7kkQx1AOeqnGtESexuWd" +
               "f3p79JU9a+ZiXboKntwagvlRRNW/QGXgJNa1NHGvhSZN1ot0OHLPBYS6lwwE3WG4xQHrHLubkAz1" +
               "6OT1t2T2aTHsQBb8/04H7V0mx+4/gOA0jGScpfpGdIO/gdvnhV0RMHjvCejnp2nQfI5L1X5JI7jL" +
               "RyrcTBdZSg1sDGulsS+Uh7XxlDD6JGAawSTy4iejippYxdQ1UK6u9JVoxyXEgUNtUzLZ89d0Yc75" +
               "vWLFjfGNzgv/EfxvRecLrlMxCC7jQ83jdDjjiiNUa1X5tkBP3Ut97Y5d3NMXwp8mkv2tmNaBcCdl" +
               "JpCjC73JE6oGJZzdHQLVts2KBsKLuFK+mLBvvim1B1vqWvR8PD+eWkEGE5EMb1y2nO0JJ+j+c8Lb" +
               "6dkAFNLJsPfgCqPD956lMJCvSPfpa/DWD0sN8T9/NYs4QsZ4pW04Xjkh6Ms1Xjm34kP5ajkHy/sr" +
               "AGmR1+SzMsr+fLmd3hUJRSYVO5mOFatmQB0cNjrdN4FXePlWZ5MHBeWboqTXdbBUXpGn5B2h/akb" +
               "AbkYyYuiJ2G8Nsyh8G8XmM/MFHihlHh205gTsjh97C5ndTzOzMXNQazLJcbC8UtXZ/FkhRlFRz/w" +
               "PCuOBcj7Ul4a65NxqK2MjJ/yGvdwfwb+VLNOGJ0SPJBYrCMV+ruyxvqEUSjC4nils6amywlssemx" +
               "CqS5yao9sw7EOsk57/Yjnh8OC923d5KDFxxrEOgF37V3e0226vv4tdsFBbtdDTP7uFgJ4oBmkDY3" +
               "JmBTeythwkdgFlBrmEUzdmsgqoYwkRyBQo514JEepEvdv/qdicSheNr9NP+hVTOhUktawGHGfTU4" +
               "cptJNb+n12pZARuk86fKSQJLkksCmNFVTlh+fFQRgwryd28DBHI8vL6/Ol1qECjTno5LOiNNcUTT" +
               "ZRkD8G3ms5CY+KFwua7sGYIjP8crplkOUorsOfe721ldtzkLS1PiO6S1ydzunwC7MTpUqmdNahGq" +
               "thXObHhpJTepH44f/Ais1WzjrFHz6UyHZTN1Fy/KfyytZWjkg/N6qrAiHcP4z8nomaOJWZ7eiWjg" +
               "RQ284QkjuQ36OsZtVKFlsIhacjhb3EwXdL9dAZt+STtBicP8g4GlJXHnlG/ezh56vGBg5HrP8kgU" +
               "7pjWeQxFMmshkj5gFlBfjB7NiQQE+9HmxdnIogUGA0uAbNDnrhRFChnxcpEVry0dlrYQPLCvQnEr" +
               "KJduuoTdRmASQVX3DigMc8kmRALvHPoV/G5IipFMnpYJMxyma8TGnSvtnbsc4t1K2chGbJeasN5P" +
               "SMjf8omaXAGuZslgAFbo59dlTsDkY67Bco1MG+JSbRE3dK0GBtCPICxp8bGwAXS8LvGfxUi7/gxY" +
               "moE0k1Es6Jk5KsC3oOq1IpY4shIZTUxVL5lQag7WxivaFeAak/DGiWwHDcz+6IiLuuoeZQp30Cwh" +
               "kCYgCnyaNFT7X17hgdWt98sCXrxnqacEju31/MWAyLr00zCLJOPp59KeU5JXAr8pr6Tyiapf5CHY" +
               "95rhi5yuyRDYVTRk4d3KZUCw3O4I2fFzBKbzwGIqhSedmX+qf32xlwT2kTlFGn1wIASMbuF4JLrh" +
                "pZiY4PSM+O8EH9Mgs/EVptaWkQPJESmzGDAJYC5LWm3Tj9Ex70EEENSc";
        

        // 口令
        String key = "css";
        // 初始化盐
        byte[] salt = init();
        // 采用PBE算法加密
      // --  byte[] encData = encryptPBE(str.getBytes(), key, salt);
        // 采用PBE算法解密
        byte[] decData = decryptPBE(str.getBytes(), key, salt);
        try {
            // encStr = encryptBase64(encData);
            String decStr = new String(decData, "UTF-8");
            System.out.println("加密前：" + decStr);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
