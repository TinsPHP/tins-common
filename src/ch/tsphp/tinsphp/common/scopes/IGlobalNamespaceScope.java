/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

/*
 * This file is based on the file IGlobalNamespaceScope from the TSPHP project.
 * TSPHP is also published under the Apache License 2.0
 * For more information see http://tsphp.ch/wiki/display/TSPHP/License
 */

package ch.tsphp.tinsphp.common.scopes;

import ch.tsphp.tinsphp.common.inference.constraints.IConstraintCollection;

/**
 * A global namespace scope contains all corresponding namespaces.
 * <p/>
 * For instance, the global default namespace scope contains all default namespaces which are most probably defined
 * in several files.
 */
public interface IGlobalNamespaceScope extends ICaseInsensitiveScope, IConstraintCollection
{
}
