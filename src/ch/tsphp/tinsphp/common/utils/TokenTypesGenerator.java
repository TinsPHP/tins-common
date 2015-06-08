/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.utils;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;

/**
 * Used to generate the TokenTypes class out of an ANTLR tokens file.
 */
public final class TokenTypesGenerator
{
    private TokenTypesGenerator() {
    }

    public static void main(String[] args) throws IOException {
        List<String> arguments = Arrays.asList(args);

        String tokensFilePath = getArgumentStrict(arguments,
                "-t",
                "path to tokens file needs to be specified with the option -t",
                "option -t given but path to tokens file was missing");
        File tokensFile = new File(tokensFilePath);
        if (!tokensFile.exists()) {
            throw new FileNotFoundException("could not find the specified tokens file \"" + tokensFilePath + "\"");
        }

        File javaFile = new File(getArgumentStrict(arguments,
                "-j",
                "output path of the java file needs to be specified with the option -j",
                "option -j given but output path of the class file was missing"));

        String header = getArgument(arguments,
                "-h",
                "option -h given but header was missing",
                "package >> PleaseSpecify <<;\npublic class TokenTypes{\n"
        );
        header = header.replace("\\n", "\n");

        String footer = getArgument(arguments,
                "-f",
                "option -f given but footer was missing",
                "}"
        );
        footer = footer.replace("\\n", "\n");

        String encoding = getArgument(arguments,
                "-e",
                "option -e given but encoding was missing",
                "UTF-8"
        );

        generateTokenTypesClass(tokensFile, javaFile, header, footer, encoding);
    }

    private static String getArgumentStrict(List<String> arguments, String option,
            String errMsgOptionMissing, String errMsgValueMissing) {
        int index = arguments.indexOf(option);
        if (index == -1) {
            throw new IllegalArgumentException(errMsgOptionMissing);
        }
        if (index + 1 == arguments.size()) {
            throw new IllegalArgumentException(errMsgValueMissing);
        }
        return arguments.get(index + 1);
    }

    private static String getArgument(
            List<String> arguments, String option, String errorMessage, String defaultValue) {

        int index = arguments.indexOf(option);
        if (index != -1) {
            if (index + 1 == arguments.size()) {
                throw new IllegalArgumentException(errorMessage);
            }
            return arguments.get(index + 1);
        }
        return defaultValue;
    }

    public static void generateTokenTypesClass(
            File tokensFile, File javaFile, String header, String footer, String encoding)
            throws IOException {

        BufferedReader reader = null;
        BufferedWriter writer = null;

        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(tokensFile), encoding));
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(javaFile), encoding));

            writer.write(header);

            writeTokenTypes(reader, writer);

            writer.write(footer);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    //do nothing
                }
            }
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    //do nothing
                }
            }
        }
    }

    private static void writeTokenTypes(BufferedReader reader, BufferedWriter writer) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.length() > 0 && line.charAt(0) != '\'') {
                String[] token = line.split("=");
                if (token.length == 2) {
                    writer.append("    public static final int ")
                            .append(token[0]).append(" = ").append(token[1]).append(";")
                            .append("\n");
                }
            } else {
                break;
            }
        }
    }
}
