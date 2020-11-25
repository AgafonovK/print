package com.xvr;

import java.time.Duration;

public interface Document {

    Duration documentDurationPrint();

    DocumentType documentType();

    DocumentSizePaper documentSizePaper();

}
