package com.zhm.example.kt_learn191218.internet;


import android.text.TextUtils;
import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class SHA1Utils {

    /**
     * 使用SHA-1加密密码
     *
     * @param original
     * @return
     * @author
     */
    public static String generate(String original) {
        if (TextUtils.isEmpty(original)) {
            throw new IllegalArgumentException("请输入要加密的内容");
        }
        String encryptText = null;
        try {
            MessageDigest m = MessageDigest.getInstance("sha-1");
            m.update(original.getBytes("UTF8"));
            byte s[] = m.digest();
            return hex(s);
        } catch (NoSuchAlgorithmException e) {
            Log.e("SHA1Utils", "no such algorithm.");
        } catch (UnsupportedEncodingException e) {
            Log.e("SHA1Utils", "no such algorithm.");
        }
        return encryptText;
    }

    /**
     * 验证存储密码是否与输入加密的密码一致
     *
     * @param original
     * @param stored
     * @return
     */
    public static boolean validate(String original, String stored) {
        if (TextUtils.isEmpty(original) || TextUtils.isEmpty(stored)) {
            return false;
        }
        String verify = generate(original);
        Log.i("SHA1Utils", "====stored=" + stored + ";verify" + verify);
        return stored.equals(verify);
    }

    /**
     * 返回十六进制字符串
     *
     * @param str
     * @return
     */
    private static String hex(byte[] str) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length; ++i) {
            sb.append(Long.toHexString((str[i] & 0xFF) | 0x100).substring(1, 3));
        }
        return swapeToUpper(sb.toString());
    }

    /**
     * 将加密结果返回为大写串，与old系统保持一致
     *
     * @param arr
     * @return
     */
    private static String swapeToUpper(String arr) {
        if (TextUtils.isEmpty(arr)) {
            return arr;
        }

        char[] buffer = arr.toCharArray();
        for (int i = 0; i < buffer.length; i++) {
            char tmp = buffer[i];
            if (Character.isLowerCase(tmp)) {
                buffer[i] = Character.toUpperCase(tmp);
            }
        }
        return new String(buffer);
    }
}
