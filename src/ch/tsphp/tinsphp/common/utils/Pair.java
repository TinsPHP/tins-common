/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.utils;

/**
 * A simple immutable pair with fields first and second.
 *
 * @param <TFirst>  The type of the field first
 * @param <TSecond> The type of the field second
 */
@SuppressWarnings("checkstyle:visibilitymodifier")
public final class Pair<TFirst, TSecond>
{
    public final TFirst first;
    public final TSecond second;

    public Pair(TFirst firstItem, TSecond secondItem) {
        first = firstItem;
        second = secondItem;
    }

    public static <TFirst, TSecond> Pair<TFirst, TSecond> pair(TFirst operatorName, TSecond operatorType) {
        return new Pair<>(operatorName, operatorType);
    }

}
