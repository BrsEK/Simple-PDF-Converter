package com.krinitsky;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;

import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.charset.StandardCharsets;

import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;
import org.fit.pdfdom.PDFDomTree;

public class ConverterPDF {

    private File pathToSave;
    private File pdfFile;
    public final static String EXTENSION_TXT = ".txt";
    public static final String EXTENSION_JPEG = ".jpeg";
    public static final String EXTENSION_PNG = ".png";

    public ConverterPDF(File pathToSave, File pdfFile) {
        this.pathToSave = pathToSave;
        this.pdfFile = pdfFile;
    }

    /**
     * Method convert pdf file to image format and save it.
     *
     * @param extension Extension for new file.
     */
    public void convertToImg(String extension) throws IOException {
        PDDocument document = PDDocument.load(pdfFile);
        PDFRenderer pdfRenderer = new PDFRenderer(document);
        for (int page = 0; page < document.getNumberOfPages(); ++page) {
            BufferedImage bim = pdfRenderer.renderImageWithDPI(
                    page, 300, ImageType.RGB);
            ImageIOUtil.writeImage(bim, String.format("%s/%s%d%s",
                    pathToSave, pdfFile.getName().split(".pdf")[0], page, extension), 300);
        }
        document.close();
    }

    /**
     * Method convert pdf file to html format
     */
    public void convertToHTML() throws IOException {
        PDDocument pdf = PDDocument.load(pdfFile);
        Writer output = new PrintWriter(String.format("%s/%s%s", pathToSave,
                pdfFile.getName().split(".pdf")[0],
                ".html"), StandardCharsets.UTF_8);
        new PDFDomTree().writeText(pdf, output);
        output.close();
    }

    /**
     * Method convert pdf file to txt format
     */
    public void convertToText() throws IOException {
        String parsedText;
        PDFParser parser = new PDFParser(new RandomAccessFile(pdfFile, "r"));
        parser.parse();
        COSDocument cosDoc = parser.getDocument();
        PDFTextStripper pdfStripper = new PDFTextStripper();
        PDDocument pdDoc = new PDDocument(cosDoc);
        parsedText = pdfStripper.getText(pdDoc);
        PrintWriter pw = new PrintWriter(String.format("%s/%s%s",
                pathToSave, pdfFile.getName().split(".pdf")[0], EXTENSION_TXT));
        pw.print(parsedText);
        cosDoc.close();
        pw.close();
    }
}