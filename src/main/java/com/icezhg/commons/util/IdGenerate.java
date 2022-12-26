package com.icezhg.commons.util;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.time.Clock;
import java.time.Instant;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by zhongjibing on 2022/12/26.
 */
public final class IdGenerate {

    private static final char[] DICT = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E',
            'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V'};

    private static final AtomicLong COUNTER = new AtomicLong(0);

    private static final String EMPTY = "";

    private static final String MAC_ADDR;

    static {
        byte[] macAddr;
        try {
            macAddr = NetworkInterface.getByInetAddress(InetAddress.getLocalHost()).getHardwareAddress();
        } catch (Exception e) {
            macAddr = new byte[]{0, 0, 0, 0, 0, 0};
        }

        StringBuilder builder = new StringBuilder();
        for (byte b : macAddr) {
            if (b >= 0) {
                builder.append(leftPad(Integer.toBinaryString(b), 8));
            } else {
                builder.append(right(Integer.toBinaryString(b), 8));
            }
        }
        MAC_ADDR = builder.toString();
    }


    public static String nextId() {
        String value = timestamp() + MAC_ADDR + sequence();
        char[] buf = new char[26];
        for (int i = 0; i < buf.length; i++) {
            buf[i] = DICT[Integer.parseInt(value.substring(i * 5, i * 5 + 5), 2)];
        }
        return new String(buf);
    }

    private static String timestamp() {
        Instant now = Instant.now(Clock.systemUTC());
        long timestamp = now.getEpochSecond() * 1000 * 1000 * 1000 + now.getNano();
        return leftPad(Long.toBinaryString(timestamp), 64);
    }

    private static String sequence() {
        return leftPad(Long.toBinaryString(COUNTER.getAndIncrement() & 0x7fff), 18);
    }

    public static String right(final String str, final int len) {
        if (len < 0) {
            return EMPTY;
        }
        if (str.length() <= len) {
            return str;
        }
        return str.substring(str.length() - len);
    }

    private static String leftPad(final String str, final int size) {
        final int pads = size - str.length();
        if (pads <= 0) {
            return str; // returns original String when possible
        }
        return zeros(pads) + str;
    }

    private static String zeros(final int repeat) {
        if (repeat <= 0) {
            return EMPTY;
        }
        final char[] buf = new char[repeat];
        Arrays.fill(buf, '0');
        return new String(buf);
    }
}
