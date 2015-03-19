/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.test.unit.utils;

import ch.tsphp.tinsphp.common.utils.Pair;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class PairTest
{

    @Test
    public void Pair_Standard_JustToSatisfyTheBuild() {
        //no arrange necessary

        Pair<String, Integer> pair = new Pair<>("a", 1);

        assertThat(pair.first, is("a"));
        assertThat(pair.second, is(1));
    }

    @Test
    public void pair_Standard_JustToSatisfyTheBuild() {
        //no arrange necessary

        Pair<String, Integer> pair = Pair.pair("a", 1);

        assertThat(pair.first, is("a"));
        assertThat(pair.second, is(1));
    }
}
