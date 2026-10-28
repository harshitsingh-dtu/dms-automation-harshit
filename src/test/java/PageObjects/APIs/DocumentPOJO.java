package PageObjects.APIs;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;


@Getter @Setter
@Slf4j
@Data
public class DocumentPOJO {
    private String documentVersionId;
    private String documentId;
}


