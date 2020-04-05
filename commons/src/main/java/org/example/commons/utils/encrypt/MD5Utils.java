package org.example.commons.utils.encrypt;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.util.StringUtils;

public class MD5Utils {

    public static String getMD5Hex(String data) {
        Preconditions.checkArgument(StringUtils.hasText(data), "Data to md5 is empty.");
        return DigestUtils.md5Hex(data);
    }

    public static boolean isEquals(String data, String md5) {
        Preconditions.checkArgument(StringUtils.hasText(md5), "Md5 is empty.");
        return getMD5Hex(data).equalsIgnoreCase(md5);
    }
}
