package fr.eletutour.eweather.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ewanletutour
 * @version 1.0.0
 * @since 1.0.0
 * <p>
 * Alert class
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Alert {

    private String title;
    private String time;
    private String expire;
    private String uri;

    public Alert withTitle(String title) {
        this.setTitle(title);
        return this;
    }

    public Alert withUri(String uri) {
        this.setUri(uri);
        return this;
    }

    public Alert withTime(String time) {
        this.setTime(time);
        return this;
    }

    public Alert withExpire(String expire) {
        this.setExpire(expire);
        return this;
    }
}
