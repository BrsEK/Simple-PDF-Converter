package com.krinitsky;

public enum FormatName {
    PDF_TO_JPEG("pdf to jpeg"),
    PDF_TO_PNG("pdf to png"),
    PDF_TO_HTML("pdf to html"),
    PDF_TO_TEXT("pdf to text");


    private String format;

    FormatName(String format) {
        this.format = format;
    }


    public String getFormat() {
        return format;
    }

}
