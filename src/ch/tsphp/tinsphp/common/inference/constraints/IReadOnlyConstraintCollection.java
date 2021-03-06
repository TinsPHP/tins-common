/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.inference.constraints;

import java.util.List;

/**
 * The read-only version of the constraint collection.
 */
public interface IReadOnlyConstraintCollection
{
    String getAbsoluteName();

    List<IConstraint> getConstraints();

    List<IBindingCollection> getBindings();
}
