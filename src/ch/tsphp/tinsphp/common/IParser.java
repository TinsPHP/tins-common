/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

/*
 * This class is based on the file IParser from the TSPHP project.
 * TSPHP is also published under the Apache License 2.0
 * For more information see http://tsphp.ch/wiki/display/TSPHP/License
 */

package ch.tsphp.tinsphp.common;

import ch.tsphp.common.ParserUnitDto;
import ch.tsphp.tinsphp.common.issues.EIssueSeverity;
import ch.tsphp.tinsphp.common.issues.IIssueReporter;

import java.io.IOException;
import java.io.InputStream;
import java.util.EnumSet;

public interface IParser extends IIssueReporter
{
    /**
     * Parse the inputString and return the corresponding abstract syntax ITSPHPAst (AST).
     *
     * @return An abstract syntax ITSPHPAst (AST)
     * @see <a href="http://www.antlr3.org/api/Java/org/antlr/runtime/ANTLRStringStream.html">
     * http://www.antlr3.org/api/Java/org/antlr/runtime/ANTLRStringStream.html</a>
     */
    ParserUnitDto parse(String inputString);

    /**
     * Parse the data and return the corresponding abstract syntax ITSPHPAst (AST).
     *
     * @return An abstract syntax ITSPHPAst (AST)
     * @see <a href="http://www.antlr3.org/api/Java/org/antlr/runtime/ANTLRStringStream.html">
     * http://www.antlr3.org/api/Java/org/antlr/runtime/ANTLRStringStream.html</a>
     */
    ParserUnitDto parse(char[] data, int numberOfActualCharsInArray);

    /**
     * Parse the inputStream and return the corresponding abstract syntax ITSPHPAst (AST).
     *
     * @return An abstract syntax ITSPHPAst (AST)
     * @see <a href="http://www.antlr3.org/api/Java/org/antlr/runtime/ANTLRInputStream.html">
     * http://www.antlr3.org/api/Java/org/antlr/runtime/ANTLRInputStream.html</a>
     */
    ParserUnitDto parseInputStream(InputStream input) throws IOException;

    /**
     * Parse the inputStream and return the corresponding abstract syntax ITSPHPAst (AST).
     *
     * @return An abstract syntax ITSPHPAst (AST)
     * @see <a href="http://www.antlr3.org/api/Java/org/antlr/runtime/ANTLRInputStream.html">
     * http://www.antlr3.org/api/Java/org/antlr/runtime/ANTLRInputStream.html</a>
     */
    ParserUnitDto parseInputStream(InputStream input, int initialBufferSize) throws IOException;

    /**
     * Parse the inputStream and return the corresponding abstract syntax ITSPHPAst (AST).
     *
     * @return An abstract syntax ITSPHPAst (AST)
     * @see <a href="http://www.antlr3.org/api/Java/org/antlr/runtime/ANTLRInputStream.html">
     * http://www.antlr3.org/api/Java/org/antlr/runtime/ANTLRInputStream.html</a>
     */
    ParserUnitDto parseInputStream(InputStream input, String encoding) throws IOException;

    /**
     * Parse the inputStream and return the corresponding abstract syntax ITSPHPAst (AST).
     *
     * @return An abstract syntax ITSPHPAst (AST)
     * @see <a href="http://www.antlr3.org/api/Java/org/antlr/runtime/ANTLRInputStream.html">
     * http://www.antlr3.org/api/Java/org/antlr/runtime/ANTLRInputStream.html</a>
     */
    ParserUnitDto parseInputStream(InputStream input, int initialBufferSize, String encoding) throws IOException;

    /**
     * Parse the inputStream and return the corresponding abstract syntax ITSPHPAst (AST).
     *
     * @return An abstract syntax ITSPHPAst (AST)
     * @see <a href="http://www.antlr3.org/api/Java/org/antlr/runtime/ANTLRInputStream.html">
     * http://www.antlr3.org/api/Java/org/antlr/runtime/ANTLRInputStream.html</a>
     */
    ParserUnitDto parseInputStream(InputStream input, int initialBufferSize, int readBufferSize, String encoding)
            throws IOException;

    /**
     * Parse the file and return the corresponding abstract syntax ITSPHPAst (AST).
     *
     * @return An abstract syntax ITSPHPAst (AST)
     * @see <a href="http://www.antlr3.org/api/Java/org/antlr/runtime/ANTLRFileStream.html">
     * http://www.antlr3.org/api/Java/org/antlr/runtime/ANTLRFileStream.html</a>
     */
    ParserUnitDto parseFile(String filename) throws IOException;

    /**
     * Parse the file and return the corresponding abstract syntax ITSPHPAst (AST).
     *
     * @return An abstract syntax ITSPHPAst (AST)
     * @see <a href="http://www.antlr3.org/api/Java/org/antlr/runtime/ANTLRFileStream.html">
     * http://www.antlr3.org/api/Java/org/antlr/runtime/ANTLRFileStream.html</a>
     */
    ParserUnitDto parseFile(String fileName, String encoding) throws IOException;

    /**
     * Indicate whether one or more syntax errors have been found during the check.
     * <p/>
     * Syntax error should always be fatal errors.
     *
     * @return True if fatal errors have been found otherwise false.
     */
    @Override
    boolean hasFound(EnumSet<EIssueSeverity> severities);
}
