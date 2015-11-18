/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dummy.model;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Thomas
 */
public class Weather {
    private static final Map<String, Weather> items = new HashMap<>();
    
    public static Weather find(long id){
        return items.get(id+"");
    }
    
    public static Collection<Weather> list(){
        return items.values();
    }
    private String weather;
    private Date date;

    public Weather(String weather, Date date) {
        this.weather = weather;
        this.date = date;
        items.put(date+"", this);
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
