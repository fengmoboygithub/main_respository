package com.company.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Encrypt 对象
 * 调用 传入加密类型 如：SHA-256、SHA-512、MD5等 并传入要加密的文本信息或文件，分别得到该加密类型下被加密的 hash 串。
 * @author  yangyc
 */
public class Encrypt {
    public static Logger logger = LoggerFactory.getLogger(Encrypt.class);
    /**
     * 传入文本内容，返回 SHA-256 串
     *
     * @param strText
     * @return
     */
    public static String hashToSha256(final String strText) {
        return hashForText(strText, "SHA-256");
    }

    /**
     * 传入文本内容，返回 SHA-512 串
     *
     * @param strText
     * @return
     */
    public static String hashToSha512(final String strText) {
        return hashForText(strText, "SHA-512");
    }

    /**
     * 传入文本内容，返回 MD5 串
     *
     * @param strText
     * @return
     */
    public static String hashToMd5(final String strText) {
        return hashForText(strText, "MD5");
    }

    /**
     * 传入文件，返回 SHA-256 串
     *
     * @param file
     * @return
     */
    public static String hashToSha256(final File file) {
        return shaForFile(file, "SHA-256");
    }

    /**
     * 传入文件，返回 SHA-512 串
     *
     * @param file
     * @return
     */
    public static String hashToSha512(final File file) {
        return shaForFile(file, "SHA-512");
    }

    /**
     * 传入文件，返回 MD5 串
     *
     * @param file
     * @return
     */
    public static String hashToMd5(final File file) {
        return shaForFile(file, "MD5");
    }

    /**
     * 字符串 hash 加密
     *
     * @param strText  传入的文本
     * @param strType
                        HASH加密
                        CRC-16
                        CRC-32
                        MD2
                        MD4
                        MD5
                        SHA1
                        SHA224
                        SHA256
                        SHA384
                        SHA512
                        SHA512/224
                        SHA512/256
                        SHA3-224
                        SHA3-256
                        SHA3-384
                        SHA3-512
                        Keccak-224
                        Keccak-256
                        Keccak-384
                        Keccak-512
                        Shake-128
                        Shake-256

     * @return
     */
    private static String hashForText(final String strText, final String strType) {
        // 返回值
        String strResult = null;

        // 是否是有效字符串
        if (strText != null && strText.length() > 0) {
            try {
                //加密开始
                // 创建加密对象 并傳入加密类型
                MessageDigest messageDigest = MessageDigest.getInstance(strType);
                // 传入要加密的字符串
                messageDigest.update(strText.getBytes());
                // 得到返回结果
                strResult = toHexString(messageDigest.digest());
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                logger.error("加密字符文本出错", e);
            }
        }

        return strResult;
    }

    /**
     * 文件 SHA 加密
     *
     * @param file  传入的文件句柄
     * @param strType
            文件HASH加密
            CRC-16
            CRC-32
            MD2
            MD4
            MD5
            SHA1
            SHA224
            SHA256
            SHA384
            SHA512
            SHA512/224
            SHA512/256
            SHA3-224
            SHA3-256
            SHA3-384
            SHA3-512
            Keccak-224
            Keccak-256
            Keccak-384
            Keccak-512
            Shake-128
            Shake-256
     * @return
     */
    private static String shaForFile(final File file, final String strType) {
        // 返回值
        String strResult = null;

        // 是否是有效字符串
        if (file != null) {
            try {
                //加密开始
                // 创建加密对象 并傳入加密类型
                MessageDigest messageDigest = MessageDigest.getInstance(strType);

                InputStream fis = new FileInputStream(file);
                byte buffer[] = new byte[1024];
                for (int numRead = 0; (numRead = fis.read(buffer)) > 0; ) {
                    // 传入要加密字节
                    messageDigest.update(buffer, 0, numRead);
                }
                fis.close();
                // 得到返回结果
                strResult = toHexString(messageDigest.digest());
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("加密文件出错", e);
            }
        }

        return strResult;
    }

    /**
     * 将 byte 转化为 string
     * @param byteBuffer
     * @return
     */
    private static String toHexString(byte byteBuffer[]) {
        // 将 byte 转化为 string
        StringBuffer strHexString = new StringBuffer();
        // 遍历 byte buffer
        for (int i = 0; i < byteBuffer.length; i++) {
            String hex = Integer.toHexString(0xff & byteBuffer[i]);
            if (hex.length() == 1) {
                strHexString.append('0');
            }
            strHexString.append(hex);
        }
        // 返回结果
        return strHexString.toString();
    }
}
