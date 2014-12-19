/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common;

import ch.tsphp.common.ITSPHPAst;
import ch.tsphp.tinsphp.common.issues.IIssueReporter;
import org.antlr.runtime.tree.TreeNodeStream;

/**
 * Represents the inference engine of TinsPHP.
 */
public interface IInferenceEngine extends IIssueReporter
{
    void enrichWithDefinitions(ITSPHPAst ast, TreeNodeStream treeNodeStream);

    void enrichWithReferences(ITSPHPAst ast, TreeNodeStream treeNodeStream);

    void enrichtWithTypes(ITSPHPAst ast, TreeNodeStream treeNodeStream);

    /**
     * Reset the inference engine.
     * <p/>
     * It will forget about previous definitions etc. and will drop previous exceptions
     */
    @Override
    void reset();
}
