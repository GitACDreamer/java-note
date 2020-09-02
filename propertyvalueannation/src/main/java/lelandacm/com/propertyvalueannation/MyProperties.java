package lelandacm.com.propertyvalueannation;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.net.InetAddress;
import java.util.List;

@ConstructorBinding
@ConfigurationProperties("my")
public class MyProperties {
    private String secret ;
    private Integer number ;
    private Long bigNumber;
    private String uuid;
    private Integer withIn10;
    private Integer numberRange;

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Long getBigNumber() {
        return bigNumber;
    }

    public void setBigNumber(Long bigNumber) {
        this.bigNumber = bigNumber;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getWithIn10() {
        return withIn10;
    }

    public void setWithIn10(Integer withIn10) {
        this.withIn10 = withIn10;
    }

    public Integer getNumberRange() {
        return numberRange;
    }

    public void setNumberRange(Integer numberRange) {
        this.numberRange = numberRange;
    }

    @Override
    public String toString() {
        return "MyProperties{" +
                "secret='" + secret + '\'' +
                ", number=" + number +
                ", bigNumber=" + bigNumber +
                ", uuid='" + uuid + '\'' +
                ", withIn10=" + withIn10 +
                ", numberRange=" + numberRange +
                '}';
    }
}
