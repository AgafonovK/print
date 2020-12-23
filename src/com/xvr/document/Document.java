package com.xvr.document;

import java.time.Duration;


public class Document {

    private Duration durationPrintDocument;
    private PaperSizeDocument paperSizeDocument;
    private TypeDocument typeDocument;

    public Document() {

    }

    public Document(PaperSizeDocument paperSizeDocument) {
        this.paperSizeDocument = paperSizeDocument;

    }

    public Document(Duration durationPrintDocument, PaperSizeDocument sizePaperDocument,
                    TypeDocument typeDocument) {

    }


    public PaperSizeDocument getSizePaperDocument() {
        return paperSizeDocument;
    }


    public void setSizePaperDocument(PaperSizeDocument paperSizeDocument) {
        this.paperSizeDocument = paperSizeDocument;
    }

    public TypeDocument getTypeDocument() {
        return typeDocument;
    }

    public void setTypeDocument(TypeDocument typeDocument) {
        this.typeDocument = typeDocument;
    }

    public Duration getDurationPrintDocument() {
        return durationPrintDocument;
    }

    public void setDurationPrintDocument(Duration durationPrintDocument) {
        this.durationPrintDocument = durationPrintDocument;
    }
}
