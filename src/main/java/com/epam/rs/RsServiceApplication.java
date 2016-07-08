package com.epam.rs;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Evgeny_Akulenko on 7/8/2016.
 */

@ApplicationPath("/service")
public class RsServiceApplication extends Application {

    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<Class<?>>();
        /*classes.add(ContactsResource.class);
        classes.add(ContactInfoWriter.class);
        classes.add(ContactInfoReader.class);*/
        return classes;
    }
}