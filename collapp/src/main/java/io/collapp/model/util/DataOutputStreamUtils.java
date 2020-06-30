
package io.collapp.model.util;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Date;

public final class DataOutputStreamUtils {


    public static void writeInts(DataOutputStream daos, int... e) throws IOException {
        for (int i : e) {
            daos.writeChars(Integer.toString(i));
        }
    }

    public static void writeNotNull(DataOutputStream daos, Boolean s) throws IOException {
        if (s != null) {
            daos.writeChars(Boolean.toString(s));
        }
    }

    public static void writeNotNull(DataOutputStream daos, Date s) throws IOException {
        if (s != null) {
            daos.writeChars(Long.toString(s.getTime()));
        }
    }

    public static void writeNotNull(DataOutputStream daos, String s) throws IOException {
        if (s != null) {
            daos.writeChars(s);
        }
    }

    public static void writeNotNull(DataOutputStream daos, Integer val) throws IOException {
        if (val != null) {
            daos.writeChars(Integer.toString(val));
        }
    }

    public static <T extends Enum<T>> void writeEnum(DataOutputStream daos, T e) throws IOException {
        if (e != null) {
            daos.writeChars(e.toString());
        }
    }

}
