package lelandacm.com.propertyvalueannation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class AnnotionServiceImpl {
    private final AcmeProperties properties;

    @Autowired
    public AnnotionServiceImpl(AcmeProperties properties) {
        this.properties = properties;
    }


    @PostConstruct
    public void openConnection() {
        System.out.println("properties:" + properties);
    }}
