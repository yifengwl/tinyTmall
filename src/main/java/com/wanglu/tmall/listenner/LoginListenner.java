package com.wanglu.tmall.listenner;

import com.wanglu.tmall.model.User;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wanglu on 17/2/7.
 */
public class LoginListenner implements HttpSessionAttributeListener {
    /**
     * 用于存放账号和session对应关系的map
     */
    private Map<String, HttpSession> map = new HashMap<String, HttpSession>();

    /**
     * 当向session中放入数据触发
     */
    public void attributeAdded(HttpSessionBindingEvent event) {

        String name = event.getName();

        if (name.equals("user")) {
            String user = ((User) event.getValue()).getName();
            if (map.get(user) != null) {
                HttpSession session = map.get(user);
                session.removeAttribute(user);
                session.invalidate();
            }
            map.put(user, event.getSession());
        }

    }
    /**
     * 当向session中移除数据触发
     */
    public void attributeRemoved(HttpSessionBindingEvent event) {
        String name = event.getName();

        if (name.equals("username")) {
            String user = (String) event.getValue();
            map.remove(user);

        }
    }

    public void attributeReplaced(HttpSessionBindingEvent event) {

    }

    public  Map<String, HttpSession>  getMap() {
        return map;
    }

    public void setMap( Map<String, HttpSession>  map) {
        this.map = map;
    }

}
