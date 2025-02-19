/*
 * Copyright (c) 2013, OpenCloudDB/MyCAT and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software;Designed and Developed mainly by many Chinese 
 * opensource volunteers. you can redistribute it and/or modify it under the 
 * terms of the GNU General Public License version 2 only, as published by the
 * Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 * 
 * Any questions about this component can be directed to it's project Web address 
 * https://code.google.com/p/opencloudb/.
 *
 */
package io.mycat.config;

/**
 * @author mycat
 */
public abstract class Versions {

    /**协议版本**/
    public static final byte PROTOCOL_VERSION = 10;

    /**server version**/
    public static byte[] SERVER_VERSION = "5.6.29-mycat-1.6.7.3-release-20190820173415".getBytes();

    public static void setServerVersion(String version) {
        byte[] mysqlVersionPart = version.getBytes();
        int startIndex;
        for (startIndex = 0; startIndex < SERVER_VERSION.length; startIndex++) {
            if (SERVER_VERSION[startIndex] == '-')
                break;
        }

        // 重新拼接mycat version字节数组
        byte[] newMycatVersion = new byte[mysqlVersionPart.length + SERVER_VERSION.length - startIndex];
        System.arraycopy(mysqlVersionPart, 0, newMycatVersion, 0, mysqlVersionPart.length);
        System.arraycopy(SERVER_VERSION, startIndex, newMycatVersion, mysqlVersionPart.length,
                SERVER_VERSION.length - startIndex);
        SERVER_VERSION = newMycatVersion;
    }
}
