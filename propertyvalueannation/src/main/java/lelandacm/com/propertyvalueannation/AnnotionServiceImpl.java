package lelandacm.com.propertyvalueannation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class AnnotionServiceImpl {
    private final AcmeProperties properties;
    private final MyProperties myProperties;

    @Autowired
    public AnnotionServiceImpl(AcmeProperties properties, MyProperties myProperties) {
        this.properties = properties;
        this.myProperties = myProperties;
    }


    @PostConstruct
    public void openConnection() {
        System.out.println("properties:" + properties);
        System.out.println("myProperties:"+myProperties);
    }
}
