/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

/*
 * This class is based on the class MapHelperTest from the TSPHP project.
 * TSPHP is also published under the Apache License 2.0
 * For more information see http://tsphp.ch/wiki/display/TSPHP/License
 */

package ch.tsphp.tinsphp.common.test.unit.utils;


import ch.tsphp.tinsphp.common.utils.MapHelper;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.is;

public class MapHelperTest
{

    @Test
    public void addToListMap() {
        Map<String, List<String>> map = new HashMap<>();
        assertThat(map.size(), is(0));

        List<String> list = new ArrayList<>();
        list.add("v");
        MapHelper.addToListInMap(map, "k", "v");
        assertThat(map, hasEntry("k", list));
        assertThat(map.size(), is(1));

        list.add("v2");
        MapHelper.addToListInMap(map, "k", "v2");
        assertThat(map, hasEntry("k", list));
        assertThat(map.size(), is(1));


        List<String> list2 = new ArrayList<>();
        list2.add("a");
        MapHelper.addToListInMap(map, "x", "a");
        assertThat(map, hasEntry("k", list));
        assertThat(map, hasEntry("x", list2));
        assertThat(map.size(), is(2));
    }

    @Test
    public void addToSetInMap() {
        Map<String, Set<String>> map = new HashMap<>();
        assertThat(map.size(), is(0));

        Set<String> set = new HashSet<>();
        set.add("v");
        MapHelper.addToSetInMap(map, "k", "v");
        assertThat(map, hasEntry("k", set));
        assertThat(map.size(), is(1));

        set.add("v2");
        MapHelper.addToSetInMap(map, "k", "v2");
        assertThat(map, hasEntry("k", set));
        assertThat(map.size(), is(1));

        Set<String> set2 = new HashSet<>();
        set2.add("a");
        MapHelper.addToSetInMap(map, "x", "a");
        assertThat(map, hasEntry("k", set));
        assertThat(map, hasEntry("x", set2));
        assertThat(map.size(), is(2));
    }
}
