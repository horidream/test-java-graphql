package com.horidream.test.testgraphql.domain.bank;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class UploadFile {
    String fileName;
    String mimeType;
}
