/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

/*
 * This file is based on the file MapHelper from the TSPHP project.
 * TSPHP is also published under the Apache License 2.0
 * For more information see http://tsphp.ch/wiki/display/TSPHP/License
 */

package ch.tsphp.tinsphp.common.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Provides a helper method to add an object to a list inside a map.
 */
public final class MapHelper
{

    private MapHelper() {
    }

    /**
     * Add the given value to the list of the corresponding key.
     * <p/>
     * If there is not yet a list for the corresponding key then a new list for the key is created as well.
     *
     * @param map   The map containing the lists
     * @param key   The key to be used
     * @param value The value to be put into the list of the corresponding key
     */
    public static <TKey, TValue> void addToListInMap(Map<TKey, List<TValue>> map, TKey key, TValue value) {
        if (map.containsKey(key)) {
            map.get(key).add(value);
        } else {
            List<TValue> list = new ArrayList<>();
            list.add(value);
            map.put(key, list);
        }
    }

    /**
     * Add the given value to the set of the corresponding key.
     * <p/>
     * If there is not yet a set for the corresponding key then a new set for the key is created as well.
     *
     * @param map   The map containing the sets
     * @param key   The key to be used
     * @param value The value to be put into the set of the corresponding key
     */
    public static <TKey, TValue> void addToSetInMap(Map<TKey, Set<TValue>> map, TKey key, TValue value) {
        if (map.containsKey(key)) {
            map.get(key).add(value);
        } else {
            Set<TValue> list = new HashSet<>();
            list.add(value);
            map.put(key, list);
        }
    }
}
