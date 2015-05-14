/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common;

import ch.tsphp.common.ICompilerListener;
import ch.tsphp.tinsphp.common.issues.IIssueReporter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * Represents the compiler of TinsPHP and acts as facade to the outside world of the compiler component.
 */
public interface ICompiler extends IIssueReporter
{
    void registerCompilerListener(ICompilerListener listener);

    void addCompilationUnit(String id, String inputString);

    void addCompilationUnit(String id, char[] data, int numberOfActualCharsInArray);

    void addCompilationUnit(String id, InputStream input) throws IOException;

    void addCompilationUnit(String id, InputStream input, int size) throws IOException;

    void addCompilationUnit(String id, InputStream input, String encoding) throws IOException;

    void addCompilationUnit(String id, InputStream input, int initialBufferSize, String encoding) throws IOException;

    void addCompilationUnit(String id, InputStream input, int initialBufferSize, int readBufferSize, String encoding)
            throws IOException;

    /**
     * Add the given file to the compilation units and use pathToFileInclFileName as identifier.
     */
    void addFile(String pathToFileInclFileName) throws IOException;

    /**
     * Add the given file to the compilation units and use pathToFileInclFileName as identifier.
     */
    void addFile(String pathToFileInclFileName, String encoding) throws IOException;

    void compile();

    boolean isCompiling();

    /**
     * Will drop all previous compiled compilation units and occurred exceptions.
     * <p/>
     * It will also make sure, that all sub components (parser, type checker, translator) are reset.
     */
    @Override
    void reset();

    boolean needsAReset();

    Map<String, String> getTranslations();
}
