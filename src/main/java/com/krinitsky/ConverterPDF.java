package com.krinitsky;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

import org.apache.pdfbox.tools.imageio.ImageIOUtil;
import org.fit.pdfdom.PDFDomTree;

public class ConverterPDF {

    private File pathToSave;
    private File pdfFile;

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

}