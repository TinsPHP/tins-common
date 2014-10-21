/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common;

public class DummyClass
{
    public boolean dummyMethod(boolean b) {
        if (b) {
            return b || !b;
        } else {
            return true;
        }
    }
}
