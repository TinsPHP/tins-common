/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

/*
 * This file is based on the file ICaseInsensitiveScope from the TSPHP project.
 * TSPHP is also published under the Apache License 2.0
 * For more information see http://tsphp.ch/wiki/display/TSPHP/License
 */

package ch.tsphp.tinsphp.common.scopes;

import ch.tsphp.common.IScope;
import ch.tsphp.common.ITSPHPAst;
import ch.tsphp.common.symbols.ISymbol;

/**
 * Represents a scope which provides the possibility to resolve identifiers in a case insensitive manner.
 * <p/>
 * As an example, foo, Foo, fOo, FOO would all be resolve when wants to resolve the identifier "foo".
 */
public interface ICaseInsensitiveScope extends IScope
{
    ISymbol resolveCaseInsensitive(ITSPHPAst identifier);
}
