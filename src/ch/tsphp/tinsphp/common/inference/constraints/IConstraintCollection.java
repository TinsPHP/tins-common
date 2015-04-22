/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.inference.constraints;

import java.util.List;

public interface IConstraintCollection extends IReadOnlyConstraintCollection
{
    void addConstraint(IConstraint constraint);

    void setBindings(List<IOverloadBindings> bindings);
}
