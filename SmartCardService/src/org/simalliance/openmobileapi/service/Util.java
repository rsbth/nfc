/*
 * Copyright (C) 2011, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/*
 * Contributed by: Giesecke & Devrient GmbH.
 */

package org.simalliance.openmobileapi.service;

public class Util {

    public static final byte END = -1;

    public static byte[] mergeBytes(byte[] array1, byte[] array2) {
        byte[] data = new byte[array1.length + array2.length];
        int i = 0;
        for (; i < array1.length; i++)
            data[i] = array1[i];
        for (int j = 0; j < array2.length; j++)
            data[j + i] = array2[j];
        return data;
    }

    public static byte[] getMid(byte[] array, int start, int length) {
        byte[] data = new byte[length];
        System.arraycopy(array, start, data, 0, length);
        return data;
    }

    public static String bytesToString(byte[] bytes) {
        if(bytes == null)
            return "";
        StringBuffer sb = new StringBuffer();
        for (byte b : bytes) {
            sb.append(String.format("%02x ", b & 0xFF));
        }
        String str = sb.toString();
        if (str.length() > 0) {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }

    public static String bytesToString(byte[] array,int offset,int length,
                                    String prefix) {
    if (array==null) return null;
    if (length==-1) length=array.length-offset;

    StringBuffer buffer=new StringBuffer();
    for (int ind=offset;ind<offset+length;ind++)
        buffer.append(prefix+Integer.toHexString(
                       0x100+(array[ind] & 0xFF)).substring(1));
    return buffer.toString();
    }

    public static byte[] hexStringToBytes(String s) {
        if (s == null || s.length() == 0) return null;
        int len = s.length();
        if (len % 2 != 0) {
            s = '0' + s;
            len++;
        }
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }
}
