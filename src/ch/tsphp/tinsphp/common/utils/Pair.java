/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.utils;

public final class Pair<T1, T2>
{
    public final T1 first;
    public final T2 second;

    public static <T1, T2> Pair<T1, T2> pair(T1 operatorName, T2 operatorType) {
        return new Pair<>(operatorName, operatorType);
    }

    public Pair(T1 firstItem, T2 secondItem) {
        first = firstItem;
        second = secondItem;
    }

}
