/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.tinsphp.common.test;

import ch.tsphp.tinsphp.common.utils.TokenTypesGenerator;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;

public class TokenTypesGeneratorTest
{

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void main_TokensFileOptionNotGiven_ThrowsIllegalArgumentException() throws IOException {
        String[] args = new String[]{
                "tokensFile",
                "-o", "ClassFile.java ",
                "-h", "header",
                "-f", "footer",
                "-e", "UTF-8"
        };

        try {
            TokenTypesGenerator.main(args);
            Assert.fail("IllegalArgumentException expected but none was thrown");

            //assert
        } catch (IllegalArgumentException ex) {
            assertThat(ex.getMessage(), is("path to tokens file needs to be specified with the option -t"));
        }
    }

    @Test
    public void main_TokensFileNotGiven_ThrowsIllegalArgumentException() throws IOException {
        String[] args = new String[]{
                "-j", "ClassFile.java ",
                "-h", "header",
                "-f", "footer",
                "-e", "UTF-8",
                "-t", //missing tokens file
        };

        try {
            TokenTypesGenerator.main(args);
            Assert.fail("IllegalArgumentException expected but none was thrown");

            //assert
        } catch (IllegalArgumentException ex) {
            assertThat(ex.getMessage(), is("option -t given but path to tokens file was missing"));
        }
    }

    @Test(expected = FileNotFoundException.class)
    public void main_TokensFileDoesNotExist_FileNotFoundException() throws IOException {
        String[] args = new String[]{
                "-j", "ClassFile.java ",
                "-h", "header",
                "-f", "footer",
                "-e", "UTF-8",
                "-t", "nonExistingTokensFile.tokens"
        };

        TokenTypesGenerator.main(args);

        //assert in @Test annotation -> expected
    }

    @Test
    public void main_ClassFileOptionNotGiven_ThrowsIllegalArgumentException() throws IOException {
        File tokensFile = folder.newFile("foo.tokens");
        String[] args = new String[]{
                "-t", tokensFile.getPath(),
                "ClassFile.java",
                "-h", "header",
                "-f", "footer",
                "-e", "UTF-8"
        };

        try {
            TokenTypesGenerator.main(args);
            Assert.fail("IllegalArgumentException expected but none was thrown");

            //assert
        } catch (IllegalArgumentException ex) {
            assertThat(ex.getMessage(), is("output path of the java file needs to be specified with the option -j"));
        }
    }

    @Test
    public void main_ClassFileNotGiven_ThrowsIllegalArgumentException() throws IOException {
        File tokensFile = folder.newFile("foo.tokens");
        String[] args = new String[]{
                "-t", tokensFile.getPath(),
                "-h", "header",
                "-f", "footer",
                "-e", "UTF-8",
                "-j", //missing class file
        };

        try {
            TokenTypesGenerator.main(args);
            Assert.fail("IllegalArgumentException expected but none was thrown");

            //assert
        } catch (IllegalArgumentException ex) {
            assertThat(ex.getMessage(), is("option -j given but output path of the class file was missing"));
        }
    }

    @Test
    public void main_HeaderNotGiven_ThrowsIllegalArgumentException() throws IOException {
        File tokensFile = folder.newFile("foo.tokens");
        File javaFile = folder.newFile("TokenTypes.java");
        String[] args = new String[]{
                "-t", tokensFile.getPath(),
                "-j", javaFile.getPath(),
                "-f", "footer",
                "-e", "UTF-8",
                "-h", //missing header
        };

        try {
            TokenTypesGenerator.main(args);
            Assert.fail("IllegalArgumentException expected but none was thrown");

            //assert
        } catch (IllegalArgumentException ex) {
            assertThat(ex.getMessage(), is("option -h given but header was missing"));
        }
    }

    @Test
    public void main_FooterNotGiven_ThrowsIllegalArgumentException() throws IOException {
        File tokensFile = folder.newFile("foo.tokens");
        File javaFile = folder.newFile("TokenTypes.java");
        String[] args = new String[]{
                "-t", tokensFile.getPath(),
                "-j", javaFile.getPath(),
                "-h", "header",
                "-e", "UTF-8",
                "-f", //missing footer
        };

        try {
            TokenTypesGenerator.main(args);
            Assert.fail("IllegalArgumentException expected but none was thrown");

            //assert
        } catch (IllegalArgumentException ex) {
            assertThat(ex.getMessage(), is("option -f given but footer was missing"));
        }
    }

    @Test
    public void main_EncodingNotGiven_ThrowsIllegalArgumentException() throws IOException {
        File tokensFile = folder.newFile("foo.tokens");
        File javaFile = folder.newFile("TokenTypes.java");
        String[] args = new String[]{
                "-t", tokensFile.getPath(),
                "-j", javaFile.getPath(),
                "-h", "header",
                "-f", "footer",
                "-e", //missing enconding
        };

        try {
            TokenTypesGenerator.main(args);
            Assert.fail("IllegalArgumentException expected but none was thrown");

            //assert
        } catch (IllegalArgumentException ex) {
            assertThat(ex.getMessage(), is("option -e given but encoding was missing"));
        }
    }


    @Test
    public void main_SpecifyingHeaderAndFooterEmptyTokensFile_GeneratesFileWithHeaderAndFooterOnly()
            throws IOException {
        File tokensFile = folder.newFile("foo.tokens");
        File classFile = folder.newFile("class.java");
        String[] args = new String[]{
                "-t", tokensFile.getPath(),
                "-j", classFile.getPath(),
                "-h", "header\n",
                "-f", "footer",
                "-e", "UTF-8",
        };

        TokenTypesGenerator.main(args);

        byte[] encoded = Files.readAllBytes(Paths.get(classFile.getPath()));
        String content = new String(encoded, "UTF-8");
        assertThat(content, is("header\nfooter"));
    }

    @Test
    public void main_EmptyTokensFileAndHeaderFooterNotSpecified_GeneratesFileWithStandardHeaderAndFooterOnly()
            throws IOException {
        File tokensFile = folder.newFile("foo.tokens");
        File classFile = folder.newFile("class.java");
        String[] args = new String[]{
                "-t", tokensFile.getPath(),
                "-j", classFile.getPath(),
                "-e", "UTF-8",
        };

        TokenTypesGenerator.main(args);

        byte[] encoded = Files.readAllBytes(Paths.get(classFile.getPath()));
        String content = new String(encoded, "UTF-8");
        assertThat(content, is("package >> PleaseSpecify <<;\nclass TokenTypes{\n}"));
    }

    @Test
    public void main_EmptyTokensFileNothingOptionalDefined_GeneratesFileWithStandardHeaderAndFooterInUTF8()
            throws IOException {
        File tokensFile = folder.newFile("foo.tokens");
        File classFile = folder.newFile("class.java");
        String[] args = new String[]{
                "-t", tokensFile.getPath(),
                "-j", classFile.getPath(),
        };

        TokenTypesGenerator.main(args);

        byte[] encoded = Files.readAllBytes(Paths.get(classFile.getPath()));
        String content = new String(encoded, "UTF-16");
        assertThat(content, is(not("package >> PleaseSpecify <<;\nclass TokenTypes{\n}")));
        encoded = Files.readAllBytes(Paths.get(classFile.getPath()));
        content = new String(encoded, "UTF-8");
        assertThat(content, is("package >> PleaseSpecify <<;\nclass TokenTypes{\n}"));

    }

    @Test
    public void main_ReplacePseudoNewLineInHeader_GeneratesFileWithNewLines()
            throws IOException {
        File tokensFile = folder.newFile("foo.tokens");
        File classFile = folder.newFile("class.java");
        String[] args = new String[]{
                "-t", tokensFile.getPath(),
                "-j", classFile.getPath(),
                "-h", "header\\n",
                "-f", "footer"
        };

        TokenTypesGenerator.main(args);

        byte[] encoded = Files.readAllBytes(Paths.get(classFile.getPath()));
        String content = new String(encoded, "UTF-8");
        assertThat(content, is("header\nfooter"));
    }

    @Test
    public void main_ReplacePseudoNewLineInFooter_GeneratesFileWithNewLines()
            throws IOException {
        File tokensFile = folder.newFile("foo.tokens");
        File classFile = folder.newFile("class.java");
        String[] args = new String[]{
                "-t", tokensFile.getPath(),
                "-j", classFile.getPath(),
                "-h", "header",
                "-f", "\\nfooter"
        };

        TokenTypesGenerator.main(args);

        byte[] encoded = Files.readAllBytes(Paths.get(classFile.getPath()));
        String content = new String(encoded, "UTF-8");
        assertThat(content, is("header\nfooter"));
    }

    @Test
    public void main_tokensFileWith3NamedTokens_GeneratesClassWith3StaticIntegers()
            throws IOException {
        File tokensFile = folder.newFile("foo.tokens");
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tokensFile), "UTF-8"));
        writer.write("A=1\nB=2\nC=3\n\n");
        writer.close();
        File classFile = folder.newFile("class.java");
        String[] args = new String[]{
                "-t", tokensFile.getPath(),
                "-j", classFile.getPath(),
                "-h", "package test;\nclass TokenTypes{\n",
        };

        TokenTypesGenerator.main(args);

        byte[] encoded = Files.readAllBytes(Paths.get(classFile.getPath()));
        String content = new String(encoded, "UTF-8");
        assertThat(content, is(
                "package test;\n"
                        + "class TokenTypes{\n"
                        + "    public static int A = 1;\n"
                        + "    public static int B = 2;\n"
                        + "    public static int C = 3;\n"
                        + "}"));
    }

    @Test
    public void main_tokensFileWith3NamedTokensAnd2UnnamedTokens_GeneratesClassWith3StaticIntegers()
            throws IOException {
        File tokensFile = folder.newFile("foo.tokens");
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tokensFile), "UTF-8"));
        writer.write("A=1\nB=2\nC=3\n'{'=1\n'}'=2\n'='=3\n");
        writer.close();
        File classFile = folder.newFile("class.java");
        String[] args = new String[]{
                "-t", tokensFile.getPath(),
                "-j", classFile.getPath(),
                "-h", "package test;\nclass TokenTypes{\n",
        };

        TokenTypesGenerator.main(args);

        byte[] encoded = Files.readAllBytes(Paths.get(classFile.getPath()));
        String content = new String(encoded, "UTF-8");
        assertThat(content, is(
                "package test;\n"
                        + "class TokenTypes{\n"
                        + "    public static int A = 1;\n"
                        + "    public static int B = 2;\n"
                        + "    public static int C = 3;\n"
                        + "}"));
    }

    @Test(expected = FileNotFoundException.class)
    public void generateTokenTypesClass_TokensFileNotFound_ThrowsFileNotFoundException() throws IOException {
        File tokensFile = new File("nonExistingPath/nonExistingFile");
        File classFile = folder.newFile("class.java");

        TokenTypesGenerator.generateTokenTypesClass(tokensFile, classFile, "h", "f", "UTF-8");

        //assert in annotation
    }

    @Test(expected = FileNotFoundException.class)
    public void generateTokenTypesClass_ClassFileNotFound_ThrowsFileNotFoundException() throws IOException {
        File tokensFile = folder.newFile("foo.tokens");
        File classFile = new File("nonExistingPath/nonExistingFile");

        TokenTypesGenerator.generateTokenTypesClass(tokensFile, classFile, "h", "f", "UTF-8");

        //assert in annotation
    }

    @Test(expected = UnsupportedEncodingException.class)
    public void generateTokenTypesClass_UnsupportedEncoding_ThrowsUnsupportedEncodingException() throws IOException {
        File tokensFile = folder.newFile("foo.tokens");
        File classFile = folder.newFile("class.java");

        TokenTypesGenerator.generateTokenTypesClass(tokensFile, classFile, "h", "f", "encoding");

        //assert in annotation
    }
}

