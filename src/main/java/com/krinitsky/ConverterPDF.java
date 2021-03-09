package com.krinitsky;

import java.io.File;

public class ConverterPDF {

    private File pathToSave;
    private File pdfFile;

    public ConverterPDF(File pathToSave, File pdfFile) {
        this.pathToSave = pathToSave;
        this.pdfFile = pdfFile;
    }

}