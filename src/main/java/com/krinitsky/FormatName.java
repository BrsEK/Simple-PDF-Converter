package com.krinitsky;

public enum FormatName {
    PDF_TO_JPG("pdf to jpg"),
    PDF_TO_JPEG("pdf to jpeg"),
    PDF_TO_PNG("pdf to png"),
    PDF_TO_DOCX("pdf to docx"),
    PDF_TO_EXEL("pdf to exel"),
    PDF_TO_HTML("pdf to html");


    private String format;

    FormatName(String format) {
        this.format = format;
    }


    public String getFormat() {
        return format;
    }

}
